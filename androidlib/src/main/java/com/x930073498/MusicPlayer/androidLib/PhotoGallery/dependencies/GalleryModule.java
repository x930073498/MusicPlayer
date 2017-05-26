package com.x930073498.MusicPlayer.androidLib.PhotoGallery.dependencies;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.activity.GalleryActivity;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.view.IView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x930073498 on 17-5-9.
 */
@Module
public class GalleryModule {
    @Provides
    IView mainView(GalleryActivity activity){
        return activity;
    }
}
