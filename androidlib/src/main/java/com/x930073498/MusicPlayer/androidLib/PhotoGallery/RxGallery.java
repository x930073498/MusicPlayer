package com.x930073498.MusicPlayer.androidLib.PhotoGallery;

import android.app.Application;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.dependencies.DaggerGalleryComponent;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.ImageEngine;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager.RxGalleryManager;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.Config;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

import java.util.List;

/**
 * Created by x930073498 on 17-5-9.
 */

public class RxGallery {

    private RxGallery() {
    }

    public static void init(Application app, ImageEngine imageEngine) {
        DaggerGalleryComponent.builder()
                .app(app)
                .build()
                .inject(app);
    }

    public RxGallery of() {
        return new RxGallery();
    }

    public RxGallery source(List<PhotoItem> source) {
        Config config = RxGalleryManager.getInstance().getConfig();
        if (config == null) config = new Config();
        config.setSource(source);
        RxGalleryManager.getInstance().setConfig(config);
        return this;
    }

}
