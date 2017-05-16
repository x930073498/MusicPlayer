package com.x930073498.MusicPlayer.dependencies.module;

import android.util.Log;

import com.x930073498.MusicPlayer.screen.activity.SecondActivity;
import com.x930073498.MusicPlayer.screen.activity.SongSearchActivity;
import com.x930073498.MusicPlayer.screen.model.SearchSongResult;
import com.x930073498.MusicPlayer.screen.model.SecondModel;
import com.x930073498.MusicPlayer.screen.view.SecondView;
import com.x930073498.MusicPlayer.screen.view.SongSearchView;
import com.x930073498.MusicPlayer.screen.viewModel.SecondViewModel;
import com.x930073498.MusicPlayer.screen.viewModel.SongSearchViewModel;

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
    SearchSongResult searchSongResult(SongSearchActivity activity) {
        return new SearchSongResult();
    }

    @Provides
    SongSearchViewModel songSearchViewModel(SongSearchActivity activity) {
        SongSearchViewModel model = new SongSearchViewModel();
        model.setData(searchSongResult(activity));
        model.setView(activity);
        return model;
    }


}
