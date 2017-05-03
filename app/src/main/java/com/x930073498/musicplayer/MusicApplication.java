package com.x930073498.musicplayer;

import com.x930073498.core.mvvm.BaseApplication;
import com.x930073498.musicplayer.component.DaggerAppComponent;

/**
 * Created by x930073498 on 17-5-3.
 */

public class MusicApplication extends BaseApplication {
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
