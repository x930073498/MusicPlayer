package com.x930073498.MusicPlayer.io.fabianterhorst.floppy;

/**
 * Created by fabianterhorst on 22.09.16.
 */

public interface OnEqualListener<T> {
    boolean isEqual(T currentObject, T newObject);
}
