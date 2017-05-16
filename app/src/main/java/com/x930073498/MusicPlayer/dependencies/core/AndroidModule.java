package com.x930073498.MusicPlayer.dependencies.core;

import android.app.Application;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AMarinaG on 27/04/2016.
 */
@Module
public class AndroidModule {
  @Provides
  public LayoutInflater provideLayoutInflater(@ForApplication Application application) {
    return LayoutInflater.from(application);
  }
}
