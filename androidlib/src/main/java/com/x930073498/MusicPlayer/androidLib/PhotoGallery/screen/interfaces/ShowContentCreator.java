package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces;

import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

import java.util.ArrayList;

/**
 * Created by 930073498 on 2017/6/1.
 */

public interface ShowContentCreator<P extends PhotoItem, T extends View, R extends View> extends ViewCreator<P,ArrayList<P>,T> {

}
