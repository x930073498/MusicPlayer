package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ImageEngine;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ViewCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.Config;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.UICreator;

/**
 * Created by x930073498 on 17-5-10.
 */

public class RxGalleryManager {
    private RxGalleryManager() {
    }

    private ImageEngine imageEngine;

    private UICreator<? extends ViewCreator, ? extends ViewCreator, ? extends ViewCreator, ? extends ViewCreator> uiCreator;

    public ImageEngine getImageEngine() {
        return imageEngine;
    }

    public void setImageEngine(ImageEngine imageEngine) {
        this.imageEngine = imageEngine;
    }

    private Config config;

    private static class ManagerHolder {
        private static RxGalleryManager manager = new RxGalleryManager();
    }

    public static RxGalleryManager getInstance() {
        return ManagerHolder.manager;
    }

    public void create() {
        config = new Config();
    }

    public Config getConfig() {
        return config = (config == null ? new Config() : config);
    }

    public <T extends ViewCreator, R extends ViewCreator, V extends ViewCreator, S extends ViewCreator> UICreator<T, R, V, S> getUi() {
        return (UICreator<T, R, V, S>) (uiCreator == null ? new UICreator<T, R, V, S>() : uiCreator);
    }


}
