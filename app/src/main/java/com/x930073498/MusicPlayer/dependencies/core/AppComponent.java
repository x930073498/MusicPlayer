package com.x930073498.MusicPlayer.dependencies.core;

import com.x930073498.MusicPlayer.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by rakshakhegde on 26/04/17.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        InjectorsModule.class,
        ApiModule.class,
        ApplicationModule.class,
})
public interface AppComponent extends AndroidInjector<App> {

}
