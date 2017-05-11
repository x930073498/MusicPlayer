package com.x930073498.androidLib.PhotoGallery.screen.manager;

import com.x930073498.androidLib.PhotoGallery.screen.model.Config;

/**
 * Created by x930073498 on 17-5-10.
 */

public class RxGalleryManager {
    private RxGalleryManager() {
    }

    private Config config;

    private static class ManagerHolder {
        private static RxGalleryManager manager = new RxGalleryManager();
    }

    public static RxGalleryManager getInstance() {
        return ManagerHolder.manager;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
