package com.x930073498.MusicPlayer.core.mvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hwangjr.rxbus.RxBus;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.x930073498.MusicPlayer.androidLib.utils.ToastUtil;


import javax.inject.Inject;

import dagger.android.AndroidInjection;


/**
 * Created by x930073498 on 17-5-3.
 */

public abstract class BaseActivity<DATA_BINDING extends ViewDataBinding, VM extends IVM> extends RxAppCompatActivity {
    protected DATA_BINDING dataBinding;
    @Inject
    protected VM ViewModel;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (useAndroidInject())
            AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    protected final Context getContext() {
        return this;
    }

    @Override
    public final void setContentView(@LayoutRes int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null, false);
        dataBinding = DataBindingUtil.bind(view);
        super.setContentView(view);
    }

    @Override
    public final void setContentView(View view) {
        super.setContentView(view);
        dataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        dataBinding = DataBindingUtil.bind(view);
    }

    protected boolean useAndroidInject() {
        return false;
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    protected final void toast(String msg, int duration) {
        ToastUtil.show(this, msg, duration);
    }

    protected final void toast(String msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    protected final void toast(int resId, int duration) {
        ToastUtil.show(this, resId, duration);
    }

    protected final void toast(int resId) {
        toast(resId, Toast.LENGTH_SHORT);
    }
}
