package com.x930073498.MusicPlayer.dependencies.core;

import com.x930073498.MusicPlayer.dependencies.module.MainModule;
import com.x930073498.MusicPlayer.dependencies.module.SecondModule;
import com.x930073498.MusicPlayer.screen.activity.MainActivity;
import com.x930073498.MusicPlayer.screen.activity.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by rakshakhegde on 26/04/17.
 */
@Module
public abstract class InjectorsModule {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {SecondModule.class})
    abstract SecondActivity secondActivity();
//	Add more ContributesAndroidInjector here...
}
