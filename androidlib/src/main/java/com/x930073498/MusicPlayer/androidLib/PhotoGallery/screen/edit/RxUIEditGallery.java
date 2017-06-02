package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.edit;

import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.EditContentCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ProgressCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ViewCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager.RxGalleryManager;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

/**
 * Created by 930073498 on 2017/6/1.
 */

public class RxUIEditGallery<P extends PhotoItem,V extends View> extends EditStarter<P> {
    RxUIEditGallery() {

    }

    public <T extends ViewCreator> RxUIEditGallery<P,V> floatOver(T creator) {
        RxGalleryManager.getInstance().getUi().setFloatView(creator);
        return this;
    }

    public <T extends ViewCreator> RxUIEditGallery<P,V> action(T creator) {
        RxGalleryManager.getInstance().getUi().setFloatView(creator);
        return this;
    }

    public RxUIEditGallery<P,V> progress(ProgressCreator creator) {
        RxGalleryManager.getInstance().getUi().setProgressView(creator);
        return this;
    }


    public <R extends View> RxUIEditGallery<P,V> content(EditContentCreator<P,R,V> creator) {
        RxGalleryManager.getInstance().getUi().setContentCreator(creator);
        return this;
    }
}
