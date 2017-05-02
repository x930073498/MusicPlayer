package com.x930073498.core.base;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DaggerActivity;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingFragmentInjector;

/**
 * Created by x930073498 on 17-5-2.
 */

public abstract class BaseActivity<DATA_BINDING extends ViewDataBinding> extends RxAppCompatActivity implements HasDispatchingFragmentInjector {
    protected DATA_BINDING binding;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = LayoutInflater.from(getContext()).inflate(layoutResID, null, false);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        binding = DataBindingUtil.bind(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        binding = DataBindingUtil.bind(view);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    protected <T extends BaseActivity> T getContext() {
        return (T) this;
    }
}
