package com.x930073498.MusicPlayer.androidLib.PhotoGallery.dependencies;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by x930073498 on 17-5-9.
 */

@Singleton
@Component(modules = {
        InjectorsModule.class
})
public interface GalleryComponent {

    void inject(Application app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder app(Application application);


        GalleryComponent build();
    }
}
