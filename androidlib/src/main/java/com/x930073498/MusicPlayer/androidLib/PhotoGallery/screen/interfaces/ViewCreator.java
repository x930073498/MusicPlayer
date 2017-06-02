package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

import java.util.List;

/**
 * Created by 930073498 on 2017/6/1.
 */

public interface ViewCreator<P extends PhotoItem, V extends View,R extends View> {
    <L extends List<P>> V create(Dialog dialog, ViewGroup parent, int index, L source);
    ImageEngine.SourceCallback sourceCallback(R view);

    ImageEngine.ThumbnailCallback thumbnailCallback(R view);
}
