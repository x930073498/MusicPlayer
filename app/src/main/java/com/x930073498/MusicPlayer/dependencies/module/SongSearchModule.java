package com.x930073498.MusicPlayer.dependencies.module;

import android.app.ProgressDialog;
import android.content.Intent;

import com.x930073498.MusicPlayer.screen.activity.SongSearchActivity;
import com.x930073498.MusicPlayer.screen.model.SearchSongResult;
import com.x930073498.MusicPlayer.screen.view.SongSearchView;
import com.x930073498.MusicPlayer.screen.viewModel.SongSearchViewModel;
import com.x930073498.androidLib.Log.Log;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x930073498 on 17-5-5.
 */
@Module
public class SongSearchModule {

    @Provides
    SongSearchView songSearchView(SongSearchActivity activity) {
        return activity;
    }

    @Provides
    SearchSongResult searchSongResult() {
        return new SearchSongResult();
    }

    @Provides
    SongSearchViewModel songSearchViewModel(SongSearchActivity activity, SearchSongResult result) {
        SongSearchViewModel model = new SongSearchViewModel(activity, result, activity);
        Intent intent=activity.getIntent();
        String key=intent.getStringExtra("key");
        model.setKey(key);
        return model;
    }

    @Provides
    ProgressDialog progressDialog(SongSearchActivity activity) {

        return new ProgressDialog(activity);
    }


}
