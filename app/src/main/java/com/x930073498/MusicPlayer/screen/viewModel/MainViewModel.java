package com.x930073498.MusicPlayer.screen.viewModel;

import android.util.Log;

import com.x930073498.MusicPlayer.R;
import com.x930073498.MusicPlayer.screen.model.MainModel;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.core.mvvm.IVM;

import javax.inject.Inject;

import retrofit2.Retrofit;


/**
 * Created by rakshakhegde on 26/04/17.
 */

public class MainViewModel extends IVM<MainView, MainModel> {
    @Inject
    Retrofit retrofit;

    @Inject
    public MainViewModel(MainView V) {
        super(V);
    }

    public MainViewModel() {
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
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

    public void loadData() {
        if (retrofit == null) {
            Log.d("xj", "retrofit is null");
        } else {
            Log.d("xj", "retrofit is not null");

        }
    }

}
