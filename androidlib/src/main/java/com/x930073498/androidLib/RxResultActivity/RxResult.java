package com.x930073498.androidLib.RxResultActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @author Smile
 * @time 2017/4/18  下午6:01
 * @desc ${TODD}
 */
public class RxResult<T> {

    private Class<? extends AppCompatActivity> target;

    private Class<T> result;

    private int requestCode = -1;
    private String key;

    private RxResult(Class<T> result) {
        this.result = result;
    }


    public RxResult<T> requestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public RxResult<T> key(String key) {
        this.key = key;
        return this;
    }

    public RxResult<T> activity(Class<? extends AppCompatActivity> target) {
        this.target = target;
        return this;
    }

    public static <T> RxResult<T> of(Class<T> result) {
        return new RxResult<>(result);
    }


    public Observable<T> start(AppCompatActivity activity) {
        return start(activity.getSupportFragmentManager());
    }


    public Observable<T> start(Fragment fragment) {
        return start(fragment.getFragmentManager());
    }

    @SuppressWarnings("unchecked")
    private Observable<T> start(FragmentManager fragmentManager) {
        ResultHandleFragment<T> fragment = (ResultHandleFragment<T>) fragmentManager.findFragmentByTag(
                ResultHandleFragment.class.getSimpleName().concat(String.valueOf(requestCode)));

        if (fragment == null) {
            fragment = ResultHandleFragment.newInstance(result, key, requestCode);
            fragmentManager.beginTransaction()
                    .add(fragment, fragment.getClass().getSimpleName().concat(String.valueOf(requestCode)))
                    .commit();
        } else if (fragment.isDetached()) {
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.attach(fragment);
            transaction.commit();
        }

        final ResultHandleFragment<T> finalFragment = fragment;
        return finalFragment.getAttachSubject().filter(aBoolean -> aBoolean).flatMap(new Function<Boolean, ObservableSource<T>>() {
            @Override
            public ObservableSource<T> apply(@NonNull Boolean aBoolean)
                    throws Exception {
                Intent intent = new Intent(finalFragment.getActivity(), target);
                finalFragment.startActivityForResult(intent, requestCode == -1 ? ResultHandleFragment.REQUEST_CODE : requestCode);
                return finalFragment.getResultSubject();
            }
        }).take(1);
    }
}
