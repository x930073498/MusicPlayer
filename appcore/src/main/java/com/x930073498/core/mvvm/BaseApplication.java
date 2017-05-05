package com.x930073498.core.mvvm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by x930073498 on 17-5-3.
 */

public  class BaseApplication extends Application
        implements HasActivityInjector
        , HasSupportFragmentInjector
{
    @Inject
    DispatchingAndroidInjector<Activity> activityAndroidInjector;


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityAndroidInjector;
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return null;
    }
}
