package com.x930073498.MusicPlayer.dependencies.core;

import android.app.Application;
import android.content.Context;

import com.x930073498.MusicPlayer.App;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AMarinaG on 27/04/2016.
 */
@Module
public class ApplicationModule {
    App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @ForApplication
    @Provides
    @Singleton
    public Application provideApplication(App app) {
        return app;
    }

    @ForApplication
    @Provides
    @Singleton
    public App provideApp() {
        return app;
    }

    @ForApplication
    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application;
    }

}
