package com.x930073498.core.mvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwangjr.rxbus.RxBus;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


import javax.inject.Inject;

import dagger.android.AndroidInjection;


/**
 * Created by x930073498 on 17-5-3.
 */

public abstract class BaseActivity<DATA_BINDING extends ViewDataBinding, VM extends IVM> extends RxAppCompatActivity  {
    protected DATA_BINDING dataBinding;
    protected VM ViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    protected Context getContext() {
        return this;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View contentView = LayoutInflater.from(this).inflate(layoutResID, null, false);
        dataBinding = DataBindingUtil.bind(contentView);
        setContentView(contentView);
        if (ViewModel==null) Log.d("xj","view_model is null");

    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        if (dataBinding == null) dataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        if (dataBinding == null) dataBinding = DataBindingUtil.bind(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
