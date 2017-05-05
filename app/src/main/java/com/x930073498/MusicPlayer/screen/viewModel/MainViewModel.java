package com.x930073498.MusicPlayer.screen.viewModel;

import com.x930073498.MusicPlayer.screen.model.MainModel;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.core.mvvm.IVM;
import com.x930073498.musicplayer.R;

import javax.inject.Inject;


/**
 * Created by rakshakhegde on 26/04/17.
 */

public class MainViewModel extends IVM<MainView, MainModel> {

//    private MainView V;

    @Inject
   public MainViewModel(MainView V) {
        super(V);
    }

    public MainViewModel() {
    }

    public MainViewModel(MainView view, MainModel data) {
        super(view, data);
    }

    public void showBtnClicked() {
        view.showMessage(R.string.showing_toast);
    }

    public void startActivity() {
        view.handStartActivity();
    }
}
