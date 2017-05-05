package com.x930073498.MusicPlayer.dependencies.module;

import com.x930073498.MusicPlayer.screen.activity.MainActivity;
import com.x930073498.MusicPlayer.screen.model.MainModel;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.MusicPlayer.screen.viewModel.MainViewModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    @Provides
    MainView mainView(MainActivity act) {
        return act;
    }

    @Provides
    MainModel mainModel(MainActivity activity) {
        MainModel model=new MainModel("测试");
        model.setStartAction("跳转");
        return model;
    }

    @Provides
    MainViewModel mainViewModel(MainActivity activity){

     return new MainViewModel(activity,mainModel(activity));
    }


}
