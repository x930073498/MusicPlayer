package com.x930073498.MusicPlayer.screen.viewModel;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.x930073498.MusicPlayer.R;
import com.x930073498.MusicPlayer.screen.model.MainModel;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.MusicPlayer.core.mvvm.IVM;


/**
 * Created by rakshakhegde on 26/04/17.
 */

public class MainViewModel extends IVM<MainView, MainModel> {


    public MainViewModel(MainView view, MainModel data, @NonNull LifecycleProvider<ActivityEvent> lifecycleProvider) {
        super(view, data, lifecycleProvider);
    }

    public void showBtnClicked() {
        view.showMessage(R.string.showing_toast);
    }

    public void startActivity() {
        view.handStartActivity();
    }

    public void loadData() {

    }

}
