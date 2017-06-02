package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.show;

import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ShowContentCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ViewCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager.RxGalleryManager;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

/**
 * Created by 930073498 on 2017/6/1.
 */

public class RxUIShowGallery<P extends PhotoItem,V extends View> extends ShowStarter {
    RxUIShowGallery() {

    }

    public <R extends View,T extends ViewCreator<P,R,R>> RxUIShowGallery<P,V> floatOver(T creator) {
        RxGalleryManager.getInstance().getUi().setFloatView(creator);
        return this;
    }

    public <R extends View,T extends ViewCreator<P,R,R>> RxUIShowGallery<P,V> action(T creator) {
        RxGalleryManager.getInstance().getUi().setActionView(creator);
        return this;
    }

    public <R extends View,T extends ViewCreator<P,R,R>>RxUIShowGallery<P,V> progress(T creator) {
        RxGalleryManager.getInstance().getUi().setProgressView(creator);
        return this;
    }

    public <T extends View> RxUIShowGallery<P,V>content(ShowContentCreator<P,T, V> creator) {
        RxGalleryManager.getInstance().getUi().setContentCreator(creator);
        return this;
    }

}
