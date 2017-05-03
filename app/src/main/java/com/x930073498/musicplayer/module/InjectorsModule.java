package com.x930073498.musicplayer.module;

import com.x930073498.musicplayer.MainActivity;
import com.x930073498.musicplayer.vm.MainViewMode;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by x930073498 on 17-5-3.
 */
@Module
public abstract class InjectorsModule {
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();
}
