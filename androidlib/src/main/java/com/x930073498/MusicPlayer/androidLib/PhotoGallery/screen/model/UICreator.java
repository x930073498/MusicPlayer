package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ViewCreator;

/**
 * Created by 930073498 on 2017/6/1.
 */

public class UICreator<CONTENT extends ViewCreator, FLOAT extends ViewCreator, ACTION extends ViewCreator, PROGRESS extends ViewCreator> {
    private CONTENT contentCreator;
    private FLOAT floatView;
    private ACTION actionView;
    private PROGRESS progressView;

    public PROGRESS getProgressView() {
        return progressView;
    }

    public void setProgressView(PROGRESS progressView) {
        this.progressView = progressView;
    }

    public ACTION getActionView() {
        return actionView;
    }

    public void setActionView(ACTION actionView) {
        this.actionView = actionView;
    }

    public CONTENT getContentCreator() {
        return contentCreator;
    }

    public void setContentCreator(CONTENT contentCreator) {
        this.contentCreator = contentCreator;
    }

    public FLOAT getFloatView() {
        return floatView;
    }

    public void setFloatView(FLOAT floatView) {
        this.floatView = floatView;
    }
}
