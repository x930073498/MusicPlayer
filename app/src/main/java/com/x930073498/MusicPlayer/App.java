package com.x930073498.MusicPlayer;


import com.x930073498.MusicPlayer.dependencies.core.AndroidModule;
import com.x930073498.MusicPlayer.dependencies.core.ApiModule;
import com.x930073498.MusicPlayer.dependencies.core.ApplicationModule;
import com.x930073498.MusicPlayer.dependencies.core.DaggerAppComponent;

import dagger.Module;
import dagger.Provides;
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
        return DaggerAppComponent
                .builder()
                .apiModule(new ApiModule(this, "http://120.77.80.82:3389/"))
                .applicationModule(new ApplicationModule(this))
                .build();
    }


}
