package com.x930073498.MusicPlayer.dependencies.core;

import com.x930073498.MusicPlayer.App;
import com.x930073498.core.http.ApiModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by rakshakhegde on 26/04/17.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        InjectorsModule.class,
        ApiModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder app(App application);


        AppComponent build();
    }
}
