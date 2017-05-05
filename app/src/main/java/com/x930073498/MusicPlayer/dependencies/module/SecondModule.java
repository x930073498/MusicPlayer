package com.x930073498.MusicPlayer.dependencies.module;

import com.x930073498.MusicPlayer.screen.activity.SecondActivity;
import com.x930073498.MusicPlayer.screen.model.SecondModel;
import com.x930073498.MusicPlayer.screen.view.SecondView;
import com.x930073498.MusicPlayer.screen.viewModel.SecondViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x930073498 on 17-5-5.
 */
@Module
public class SecondModule {
    @Provides
    SecondView secondView(SecondActivity activity){
        return activity;
    }

    @Provides
    SecondModel secondModel(SecondActivity activity){
        return new SecondModel();
    }
    @Provides
    SecondViewModel secondViewModel(SecondActivity activity){
        SecondViewModel secondViewModel=new SecondViewModel(secondView(activity),secondModel(activity));
        return secondViewModel;
    }
}
