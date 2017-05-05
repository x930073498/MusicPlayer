package com.x930073498.MusicPlayer.screen.model;

import android.databinding.Bindable;

import com.x930073498.core.mvvm.IData;
import com.x930073498.musicplayer.BR;

/**
 * Created by x930073498 on 17-5-4.
 */

public class MainModel extends IData {
    private String toastText;
    private String startAction;

    public MainModel(String toastText) {
        this.toastText = toastText;
    }

    @Bindable
    public String getStartAction() {
        return startAction;
    }

    public void setStartAction(String startAction) {
        this.startAction = startAction;
        notifyPropertyChanged(BR.startAction);
    }

    @Bindable
    public String getToastText() {
        return toastText;
    }

    public void setToastText(String toastText) {
        this.toastText = toastText;
        notifyPropertyChanged(BR.toastText);
    }
}
