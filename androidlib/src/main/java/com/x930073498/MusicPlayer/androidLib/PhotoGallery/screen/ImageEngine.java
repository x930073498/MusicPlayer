package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen;

import android.content.Context;
import android.view.View;

/**
 * Created by x930073498 on 17-5-9.
 */

public interface ImageEngine<T extends View> {
    T imageView(Context context, View root);

    void display(T imageView,int width,int height);
}
