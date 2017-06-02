package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces;

import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.annotation.UiThread;
import android.view.View;

import com.x930073498.MusicPlayer.androidLib.PhotoGallery.photoAttacher.ImageParser;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;

/**
 * Created by x930073498 on 17-5-9.
 */

public interface ImageEngine<P extends PhotoItem, T extends View> {
    ImageParser<T> parser();


    /**
     * 状态码，取消加载原图
     */
    int STATUS_DISPLAY_CANCEL = -1;
    /**
     * 状态码，加载原图失败
     */
    int STATUS_DISPLAY_FAILED = 0;
    /**
     * 状态码，加载原图成功
     */
    int STATUS_DISPLAY_SUCCESS = 1;

    /**
     * 加载并显示原图
     *
     * @param item           photoItem
     * @param imageView      用于图片加载成功后显示的 ImageView
     * @param placeholder    加载完成之前显示的占位图
     * @param sourceCallback 图片加载过程的回调
     */
    void showSourceImage(P item, T imageView, Drawable placeholder, final SourceCallback sourceCallback);

    /**
     * 异步加载缩略图
     *
     * @param item     photoItem
     * @param callback 缩略图片加载完成的回调
     */
    void loadThumbnailAsync(P item, T imageView, final ThumbnailCallback callback);

    interface SourceCallback {
        @UiThread
        void onStart();

        @UiThread
        void onProgress(int progress);

        @UiThread
        void onFinish();

        @UiThread
        void onDelivered(@Status int status);
    }


    interface ThumbnailCallback {
        @UiThread
        void onFinish(Drawable drawable);
    }

    @IntDef(value = {STATUS_DISPLAY_CANCEL, STATUS_DISPLAY_FAILED, STATUS_DISPLAY_SUCCESS})
    @interface Status {

    }
}

