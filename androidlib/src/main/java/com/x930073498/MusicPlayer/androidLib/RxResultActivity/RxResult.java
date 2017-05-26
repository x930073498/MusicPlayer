package com.x930073498.MusicPlayer.androidLib.RxResultActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

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

    private Class<? extends Activity> target;

    private Class<T> result;

    private Bundle bundle=new Bundle();

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

    public RxResult<T> bundle(Bundle bundle) {
        if (bundle==null)bundle=new Bundle();
        this.bundle = bundle;
        return this;
    }

    public RxResult<T> activity(Class<? extends Activity> target) {
        this.target = target;
        return this;
    }

    public static <T> RxResult<T> of(Class<T> result) {
        return new RxResult<>(result);
    }

    public Observable<T> start(Activity activity) {
        return start(activity.getFragmentManager());
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
                intent.putExtras(bundle);
                finalFragment.startActivityForResult(intent, requestCode == -1 ? ResultHandleFragment.REQUEST_CODE : requestCode);
                return finalFragment.getResultSubject();
            }
        }).take(1);
    }
}
