package com.x930073498.androidLib.PhotoGallery.dependencies;
import com.x930073498.androidLib.PhotoGallery.screen.activity.GalleryActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by rakshakhegde on 26/04/17.
 */
@Module
public abstract class InjectorsModule {

    @ContributesAndroidInjector(modules = {GalleryModule.class})
    abstract GalleryActivity activity();
}
