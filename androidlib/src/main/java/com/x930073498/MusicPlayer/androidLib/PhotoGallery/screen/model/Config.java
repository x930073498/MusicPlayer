package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model;

import java.util.List;

/**
 * Created by x930073498 on 17-5-10.
 */

public class Config {
    private boolean delete=false;
    private List<PhotoItem> source;

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public List<PhotoItem> getSource() {
        return source;
    }

    public void setSource(List<PhotoItem> source) {
        this.source = source;
    }
}
