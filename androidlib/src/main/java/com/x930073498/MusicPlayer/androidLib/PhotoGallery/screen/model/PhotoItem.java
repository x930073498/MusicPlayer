package com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.IntDef;
import android.text.TextUtils;

import com.x930073498.MusicPlayer.androidLib.utils.RegexUtil;
import com.x930073498.androidlib.BR;
import com.x930073498.MusicPlayer.java.lib.utils.MD5Util;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by x930073498 on 17-5-9.
 */

public class PhotoItem extends BaseObservable {
    public static final int NOT_UPDATE = 0;
    public static final int UPDATING = 1;
    public static final int UPDATED = 2;
    public static final int UPDATE_FAILURE = 3;

    private String id;
    private String name;
    private String md5;
    private boolean isFile = false;
    private boolean isRemote = false;
    private String localPath;
    private String remotePath;
    private String thumbnailsPath;
    private boolean hasThumbnails = false;
    @UpdateStatus
    private int updateStatus = NOT_UPDATE;

    @IntDef(value = {NOT_UPDATE, UPDATING, UPDATED, UPDATE_FAILURE})
    @Retention(RetentionPolicy.SOURCE)
    @interface UpdateStatus {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
        notifyPropertyChanged(BR.md5);
    }

    @Bindable
    public boolean isFile() {
        return isFile;

    }

    public void setFile(boolean file) {
        isFile = file;
        notifyPropertyChanged(BR.file);
    }

    @Bindable
    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
        notifyPropertyChanged(BR.remote);
    }

    @Bindable
    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
        notifyPropertyChanged(BR.localPath);
    }

    @Bindable
    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
        notifyPropertyChanged(BR.remotePath);
    }

    @UpdateStatus
    @Bindable
    public int getUpdateStatus() {
        return updateStatus;

    }


    public void setUpdateStatus(@UpdateStatus int updateStatus) {
        this.updateStatus = updateStatus;
        notifyPropertyChanged(BR.updateStatus);
    }

    public String getThumbnailsPath() {
        return thumbnailsPath;
    }

    public void setThumbnailsPath(String thumbnailsPath) {
        this.thumbnailsPath = thumbnailsPath;
    }

    public boolean HasThumbnails() {
        return hasThumbnails;
    }

    public void setHasThumbnails(boolean hasThumbnails) {
        this.hasThumbnails = hasThumbnails;
    }

    public static PhotoItem parse(File file) {
        if (file == null || !file.exists()) return null;
        PhotoItem photoItem = new PhotoItem();
        photoItem.setUpdateStatus(NOT_UPDATE);
        photoItem.setFile(true);
        Flowable.just(file).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).map(MD5Util::getFileMd5).subscribe(s -> {
            photoItem.setId(s);
            photoItem.setMd5(s);
        });
        photoItem.setHasThumbnails(false);
        photoItem.setLocalPath(file.getAbsolutePath());
        photoItem.setName(file.getName());
        photoItem.setRemote(false);
        photoItem.setRemotePath(null);
        photoItem.setThumbnailsPath(photoItem.getLocalPath());
        return photoItem;
    }

    public static PhotoItem parse(String path) {
        if (TextUtils.isEmpty(path) || TextUtils.isEmpty(path.trim())) return null;
        if (RegexUtil.isNetUrl(path)) {
            PhotoItem photoItem = new PhotoItem();
            photoItem.setUpdateStatus(UPDATED);
            photoItem.setFile(false);
            photoItem.setHasThumbnails(false);
            photoItem.setRemote(true);
            photoItem.setId(path);
            photoItem.setMd5(null);
            photoItem.setName(path);
            photoItem.setLocalPath(null);
            photoItem.setThumbnailsPath(path);
            photoItem.setRemotePath(path);
            return photoItem;
        } else {
            File file = new File(path);
            if (!file.exists()) return null;
            else return parse(file);
        }
    }

    public static PhotoItem parse(String path, String thumbnailsPath) {
        PhotoItem item = parse(path);
        if (item == null) return null;
        item.setThumbnailsPath(thumbnailsPath);
        if (TextUtils.isEmpty(thumbnailsPath)) {
            item.setHasThumbnails(false);
            return item;
        } else if (!TextUtils.isEmpty(thumbnailsPath) && !thumbnailsPath.equals(path)) {
            item.setHasThumbnails(true);
        } else {
            item.setHasThumbnails(false);
        }
        return item;
    }
}
