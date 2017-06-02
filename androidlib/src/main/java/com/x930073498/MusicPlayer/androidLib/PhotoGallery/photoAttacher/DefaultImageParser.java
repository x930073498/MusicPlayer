package com.x930073498.MusicPlayer.androidLib.PhotoGallery.photoAttacher;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by 930073498 on 2017/5/31.
 */

public class DefaultImageParser <T extends ImageView> implements ImageParser<T> {
    @Override
    public Drawable getDrawable(T view) {
        return view.getDrawable();
    }

    @Override
    public void setImageMatrix(T view, Matrix matrix) {
        view.setImageMatrix(matrix);
    }
}
