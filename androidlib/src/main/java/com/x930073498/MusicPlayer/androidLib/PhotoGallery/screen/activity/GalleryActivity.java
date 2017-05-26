package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.view.IView;

/**
 * Created by x930073498 on 17-5-9.
 */

public class GalleryActivity extends RxAppCompatActivity implements IView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showDeleteSnackBar() {

    }
}
