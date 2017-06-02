package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.edit;

import android.content.Context;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.util.Utils;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by 930073498 on 2017/6/1.
 */

public class EditStarter<T extends PhotoItem> {
    public Observable<List<T>> start(Context context) {
        return Utils.startResult(context);
    }

}
