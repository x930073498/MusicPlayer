package com.x930073498.MusicPlayer.screen.viewModel;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.x930073498.MusicPlayer.screen.model.SecondModel;
import com.x930073498.MusicPlayer.screen.view.SecondView;
import com.x930073498.MusicPlayer.core.mvvm.IVM;

/**
 * Created by x930073498 on 17-5-5.
 */

public class SecondViewModel extends IVM<SecondView, SecondModel> {


    public SecondViewModel(SecondView view, SecondModel data, @NonNull LifecycleProvider<ActivityEvent> lifecycleProvider) {
        super(view, data, lifecycleProvider);
    }

    public void setResult() {
        view.setResultAndFinish();
    }

    public void startActivityNext() {
        view.startNextActivity();
    }
}
