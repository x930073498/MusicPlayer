package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.edit;

import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ImageEngine;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager.RxGalleryManager;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

import java.util.List;

public class RxEditGallery<P extends PhotoItem, V extends View> extends EditStarter<P> {


    public RxEditGallery<P,V> index(int index) {
        RxGalleryManager.getInstance().getConfig().setDefaultIndex(index);
        return this;
    }


    public RxEditGallery<P,V> use(ImageEngine engine) {
        RxGalleryManager.getInstance().getConfig().setImageEngine(engine);
        return this;
    }

    public RxUIEditGallery<P, V> ui() {
        return new RxUIEditGallery<>();
    }

    public RxEditGallery(List<P> source) {
        RxGalleryManager.getInstance().getConfig().setSource(source);
    }
}