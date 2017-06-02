package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.show;

import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ImageEngine;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager.RxGalleryManager;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

import java.util.List;

public class RxShowGallery<P extends PhotoItem,V extends View> extends ShowStarter<P> {
    public RxShowGallery(List<? extends PhotoItem> source) {
        RxGalleryManager.getInstance().getConfig().setSource(source);
    }


    public RxShowGallery<P,V> index(int index) {
        RxGalleryManager.getInstance().getConfig().setDefaultIndex(index);
        return this;
    }


    public RxShowGallery<P,V> use(ImageEngine engine) {
        RxGalleryManager.getInstance().getConfig().setImageEngine(engine);
        return this;
    }


    public RxUIShowGallery<P,V> ui() {
        return new RxUIShowGallery<>();
    }

}