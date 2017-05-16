package com.x930073498.MusicPlayer.screen.view;


import com.x930073498.core.mvvm.IView;

/**
 * Created by x930073498 on 17-5-16.
 */

public interface SongSearchView extends IView {

    void showProgress(String msg);
    void dismissProgress();
    void showChooseDialog();
}
