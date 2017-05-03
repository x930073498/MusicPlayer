package com.x930073498.musicplayer.component;

import android.app.Application;


import com.x930073498.musicplayer.module.InjectorsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by x930073498 on 17-5-3.
 */

@Singleton
@Component(modules = {
        InjectorsModule.class
})
public interface AppComponent {

    void inject(Application app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder app(Application application);

        AppComponent build();
    }
}
