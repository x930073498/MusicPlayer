package com.x930073498.MusicPlayer.screen.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.hwangjr.rxbus.RxBus;
import com.x930073498.MusicPlayer.R;
import com.x930073498.MusicPlayer.databinding.ActivitySongSearchBinding;
import com.x930073498.MusicPlayer.http.api.SongSourceApi;
import com.x930073498.MusicPlayer.screen.view.SongSearchView;
import com.x930073498.MusicPlayer.screen.viewModel.SongSearchViewModel;
import com.x930073498.core.mvvm.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ArrayList<String> items = new ArrayList<>();
        items.add(SongSourceApi.FROM_ALL);
        items.add(SongSourceApi.FROM_XIAMI);
        items.add(SongSourceApi.FROM_QQ);
        items.add(SongSourceApi.FROM_NETEASE);
        String[] strings = new String[]{"全部",
                "虾米音乐",
                "QQ音乐",
                "网易云音乐",

        };
        builder.setItems(strings, (dialog1, which) -> {
            dialog1.dismiss();
            RxBus.get().post("setFrom", items.get(which));

        });
        builder.show();
    }

}
