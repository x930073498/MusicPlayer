package com.x930073498.MusicPlayer;


import com.x930073498.MusicPlayer.dependencies.core.DaggerAppComponent;
import com.x930073498.core.mvvm.BaseApplication;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


/**
 * Created by rakshakhegde on 26/04/17.
 */

public class App extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().app(this).build();
    }
}
