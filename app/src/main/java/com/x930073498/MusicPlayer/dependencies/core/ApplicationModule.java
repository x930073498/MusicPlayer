package com.x930073498.MusicPlayer.dependencies.core;

import android.app.Application;
import android.content.Context;

import com.x930073498.MusicPlayer.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AMarinaG on 27/04/2016.
 */
@Module
public class ApplicationModule {
  private App application;

  public ApplicationModule(App application) {
    this.application = application;
  }

  @ForApplication
  @Provides
  @Singleton
  public Application provideApplication() {
    return application;
  }

  @ForApplication
  @Provides
  @Singleton
  public App provideApp() {
    return application;
  }

  @ForApplication
  @Provides
  @Singleton
  public Context provideContext() {
    return application.getApplicationContext();
  }

}
