package com.x930073498.androidLib.RxResultActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;

import com.trello.rxlifecycle2.components.support.RxFragment;

import java.io.Serializable;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by x930073498 on 17-5-5.
 */

public class ResultHandleFragmentN<T> extends RxFragment {
    public static final int REQUEST_CODE = 1200;

    private int requestCode;

    private String key;

    public static <T> ResultHandleFragmentN<T> newInstance(String key, int requestCode) {

        ResultHandleFragmentN<T> fragment = new ResultHandleFragmentN<>();
        fragment.key = key;
        fragment.requestCode = requestCode;
        return fragment;
    }


    PublishSubject<T> resultSubject = PublishSubject.create();
    BehaviorSubject<Boolean> attachSubject = BehaviorSubject.create();


    public PublishSubject<T> getResultSubject() {
        return resultSubject;
    }

    public BehaviorSubject<Boolean> getAttachSubject() {
        return attachSubject;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.requestCode) {
            if (getResult(data)==null)return;
            resultSubject.onNext(getResult(data));
        }
    }

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attachSubject.onNext(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            attachSubject.onNext(true);
        }
    }

    @SuppressWarnings("unchecked")
    private T getResult(Intent data) {
        if (data == null) return null;
        Serializable temp=data.getSerializableExtra(key);
        try {
            return (T)temp;
        }catch (Exception e){
            return null;
        }
    }
}
