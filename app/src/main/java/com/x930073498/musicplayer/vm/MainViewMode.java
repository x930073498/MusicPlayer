package com.x930073498.musicplayer.vm;

import com.x930073498.core.mvvm.IData;
import com.x930073498.core.mvvm.IVM;
import com.x930073498.core.mvvm.IVeiw;
import com.x930073498.musicplayer.MainActivity;
import com.x930073498.musicplayer.model.MainModel;
import com.x930073498.musicplayer.view.MainView;

import dagger.Provides;

/**
 * Created by x930073498 on 17-5-3.
 */

public class MainViewMode extends IVM<MainView, MainModel> {

    public MainViewMode(MainView view, MainModel data) {
        super(view, data);
    }

}
