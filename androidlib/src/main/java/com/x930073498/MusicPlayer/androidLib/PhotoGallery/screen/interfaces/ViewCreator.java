package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

import java.util.List;

/**
 * Created by 930073498 on 2017/6/1.
 */

public interface ViewCreator<P extends PhotoItem, L extends List<P>, V extends View> {
    V create(Dialog dialog, ViewGroup parent, int index, L source);

    ImageEngine.SourceCallback sourceCallback(V view);

    ImageEngine.ThumbnailCallback thumbnailCallback(V view);
}
