package com.x930073498.MusicPlayer.screen.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.x930073498.MusicPlayer.screen.view.SongSearchView;
import com.x930073498.MusicPlayer.screen.viewModel.SongSearchViewModel;
import com.x930073498.core.mvvm.BaseActivity;
import com.x930073498.musicplayer.R;
import com.x930073498.musicplayer.databinding.ActivitySongSearchBinding;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by x930073498 on 17-5-16.
 */

public class SongSearchActivity extends BaseActivity<ActivitySongSearchBinding, SongSearchViewModel> implements SongSearchView {
    @Inject
    Retrofit retrofit;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_search);
        dialog = new ProgressDialog(this);
        dataBinding.setVM(ViewModel);
        ViewModel.setRetrofit(retrofit);
    }

    @Override
    protected boolean useAndroidInject() {
        return true;
    }

    @Override
    public void showProgress(String msg) {
        dialog.setMessage(msg);
        dialog.show();
    }

    @Override
    public void dismissProgress() {
        dialog.dismiss();
    }

    @Override
    public void showChooseDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
    }

}
