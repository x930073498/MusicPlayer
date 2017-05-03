package com.x930073498.musicplayer.module;

import com.x930073498.musicplayer.MainActivity;
import com.x930073498.musicplayer.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x930073498 on 17-5-3.
 */
@Module
public abstract class MainModule {
    @Provides
    MainView activity(MainActivity view) {
        return view;
    }
}
