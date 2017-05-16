package com.x930073498.androidLib.RxResultActivity;

import android.content.Intent;
import android.os.Bundle;
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
public class RxResultN<T> {

    private Class<? extends AppCompatActivity> target;

    private Class<T> result;

    private int requestCode = -1;
    private String key;
    private Bundle bundle = new Bundle();

    private RxResultN(Class<T> result) {
        this.result = result;
    }


    public RxResultN<T> requestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public RxResultN<T> key(String key) {
        this.key = key;
        return this;
    }

    public RxResultN<T> bundle(Bundle bundle) {
        if (bundle == null) bundle = new Bundle();
        this.bundle = bundle;
        return this;
    }

    public RxResultN<T> activity(Class<? extends AppCompatActivity> target) {
        this.target = target;
        return this;
    }

    public static <T> RxResultN<T> of(Class<T> result) {
        return new RxResultN<>(result);
    }

    public Observable<T> start(AppCompatActivity activity) {
        return start(activity.getSupportFragmentManager());
    }

    public Observable<T> start(Fragment fragment) {
        return start(fragment.getFragmentManager());
    }


    @SuppressWarnings("unchecked")
    private Observable<T> start(FragmentManager fragmentManager) {
        ResultHandleFragmentN<T> fragment = (ResultHandleFragmentN<T>) fragmentManager.findFragmentByTag(
                ResultHandleFragmentN.class.getSimpleName().concat(String.valueOf(requestCode)));

        if (fragment == null) {
            fragment = ResultHandleFragmentN.newInstance( key, requestCode);
            fragmentManager.beginTransaction()
                    .add(fragment, fragment.getClass().getSimpleName().concat(String.valueOf(requestCode)))
                    .commit();
        } else if (fragment.isDetached()) {
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.attach(fragment);
            transaction.commit();
        }

        final ResultHandleFragmentN<T> finalFragment = fragment;
        return finalFragment.getAttachSubject().filter(aBoolean -> aBoolean).flatMap(new Function<Boolean, ObservableSource<T>>() {
            @Override
            public ObservableSource<T> apply(@NonNull Boolean aBoolean)
                    throws Exception {
                Intent intent = new Intent(finalFragment.getActivity(), target);
                intent.putExtras(bundle);
                finalFragment.startActivityForResult(intent, requestCode == -1 ? ResultHandleFragmentN.REQUEST_CODE : requestCode);
                return finalFragment.getResultSubject();
            }
        }).take(1);
    }
}
