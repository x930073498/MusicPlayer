package com.x930073498.MusicPlayer.screen.activity;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.x930073498.MusicPlayer.R;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.RxGallery;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.photoAttacher.ImageParser;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ImageEngine;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.interfaces.ViewCreator;
import com.x930073498.MusicPlayer.androidLib.PhotoGallery.screen.model.PhotoItem;
import com.x930073498.MusicPlayer.androidLib.RxResultActivity.RxResult;
import com.x930073498.MusicPlayer.core.mvvm.BaseActivity;
import com.x930073498.MusicPlayer.databinding.ActivityMainBinding;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.MusicPlayer.screen.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBinding.setVM(ViewModel);
        ViewModel.loadData();
    }

    @Override
    protected boolean useAndroidInject() {
        return true;
    }

    @Override
    public void showMessage(int message) {
        toast(message);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void handStartActivity() {
//
       RxGallery.of(new ImageEngine<PhotoItem, ProgressBar>() {
           @Override
           public ImageParser<ProgressBar> parser() {
               return null;
           }

           @Override
           public void showSourceImage(PhotoItem item, ProgressBar imageView, Drawable placeholder, SourceCallback sourceCallback) {

           }

           @Override
           public void loadThumbnailAsync(PhotoItem item, ProgressBar imageView, ThumbnailCallback callback) {

           }
       }).show(new ArrayList<>()).ui().action(new ViewCreator<PhotoItem, View, View>() {
           @Override
           public <L extends List<PhotoItem>> View create(Dialog dialog, ViewGroup parent, int index, L source) {
               return null;
           }

           @Override
           public ImageEngine.SourceCallback sourceCallback(View view) {
               return null;
           }

           @Override
           public ImageEngine.ThumbnailCallback thumbnailCallback(View view) {
               return null;
           }
       }).start(this);

        RxResult
                .of(ArrayList.class)
                .activity(SecondActivity.class)
                .requestCode(1000)
                .key("data")
                .start(this)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .flatMap(new Function<ArrayList, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull ArrayList arrayList) throws Exception {
                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < arrayList.size(); i++) {
                            builder.append(arrayList.get(i).toString());
                        }
                        return Observable.just(builder.toString());
                    }
                })
                .subscribe(this::toast);
    }

}
