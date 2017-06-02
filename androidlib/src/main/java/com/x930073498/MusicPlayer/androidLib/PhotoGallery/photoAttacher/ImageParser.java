package com.x930073498.MusicPlayer.androidLib.PhotoGallery.photoAttacher;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by 930073498 on 2017/5/31.
 */

public interface ImageParser<T extends View> {

    Drawable getDrawable(T view);

    void setImageMatrix(T view, Matrix matrix);

}
