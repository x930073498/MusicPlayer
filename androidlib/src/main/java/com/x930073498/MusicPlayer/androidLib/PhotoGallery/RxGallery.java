package com.x930073498.MusicPlayer.androidLib.PhotoGallery;

import android.support.annotation.IntDef;
import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ImageEngine;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.edit.RxEditGallery;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.manager.RxGalleryManager;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.show.RxShowGallery;

import java.util.List;

/**
 * Created by x930073498 on 17-5-9.
 */

public class RxGallery<P extends PhotoItem, V extends View> {
    public final static int MODE_SHOW = 1;
    public final static int MODE_EDIT = 2;


    private RxGallery() {
    }


    public static <P extends PhotoItem, V extends View>  RxGallery<P,V> of(ImageEngine<P, V> engine) {
        RxGalleryManager.getInstance().create();
        RxGalleryManager.getInstance().setImageEngine(engine);
        return new RxGallery<P, V>();
    }


    public RxEditGallery<P, V> edit(List<P> source) {
        RxGalleryManager.getInstance().getConfig().setMode(MODE_EDIT);
        return new RxEditGallery<>(source);
    }

    public RxShowGallery<P, V> show(List<P> source) {
        RxGalleryManager.getInstance().getConfig().setMode(MODE_SHOW);
        return new RxShowGallery<>(source);
    }

    @IntDef(value = {MODE_SHOW
            , MODE_EDIT
    })
    public @interface MODE {
    }


}
