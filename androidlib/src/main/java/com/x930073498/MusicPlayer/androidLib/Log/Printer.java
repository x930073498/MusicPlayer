package com.x930073498.MusicPlayer.androidLib.Log;

public interface Printer {

    Log.Builder init();

    Log.Builder getLogBuilder();

    void setLastMethodClassName(String className);

    void d(Object... args);

    void e(Object... args);

    void e(Throwable throwable, Object... args);

    void w(Object... args);

    void i(Object... args);

    void v(Object... args);

    void wtf(Object... args);
}
