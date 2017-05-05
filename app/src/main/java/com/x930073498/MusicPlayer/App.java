package com.x930073498.MusicPlayer;


import com.x930073498.MusicPlayer.dependencies.core.DaggerAppComponent;
import com.x930073498.core.mvvm.BaseApplication;


/**
 * Created by rakshakhegde on 26/04/17.
 */

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent
                .builder()
                .app(this)

                .build()
                .inject(this);
    }

}
