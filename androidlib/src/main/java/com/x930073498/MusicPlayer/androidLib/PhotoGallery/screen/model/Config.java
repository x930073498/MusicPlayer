package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.RxGallery;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ImageEngine;

import java.util.List;

/**
 * Created by x930073498 on 17-5-10.
 */

public class Config {
    private List<? extends PhotoItem> source;
    private int defaultIndex;
    private
    @RxGallery.MODE
    int mode;
    private ImageEngine imageEngine;


    public ImageEngine getImageEngine() {
        return imageEngine;
    }

    public void setImageEngine(ImageEngine imageEngine) {
        this.imageEngine = imageEngine;
    }

    public
    @RxGallery.MODE
    int getMode() {
        return mode;
    }

    public void setMode(@RxGallery.MODE int mode) {
        this.mode = mode;
    }

    public int getDefaultIndex() {
        return defaultIndex;
    }

    public void setDefaultIndex(int defaultIndex) {
        this.defaultIndex = defaultIndex;
    }

    public List<? extends PhotoItem> getSource() {
        return source;
    }

    public void setSource(List<? extends PhotoItem> source) {
        this.source = source;
    }
}
