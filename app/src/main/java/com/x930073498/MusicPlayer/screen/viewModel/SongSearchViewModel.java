package com.x930073498.MusicPlayer.screen.viewModel;

import android.text.TextUtils;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.x930073498.MusicPlayer.http.api.SongSourceApi;
import com.x930073498.MusicPlayer.screen.model.SearchSongResult;
import com.x930073498.MusicPlayer.screen.view.SongSearchView;
import com.x930073498.core.mvvm.IVM;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by x930073498 on 17-5-16.
 */

public class SongSearchViewModel extends IVM<SongSearchView, SearchSongResult> {

    private Retrofit retrofit;

    @SongSourceApi.VendorDef
    private String from;
    private String key;

    @SongSourceApi.VendorDef
    public String getFrom() {
        return from;
    }

    public void setFrom(@SongSourceApi.VendorDef String from) {
        this.from = from;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public SongSearchViewModel(SongSearchView view, SearchSongResult data) {
        super(view, data);
    }

    public SongSearchViewModel(SongSearchView view) {
        super(view);
    }

    public SongSearchViewModel() {
    }

    public void showChooseDialog() {

    }

    @Subscribe(tags = @Tag("setFrom"))
    public void setFrom() {

    }

    public void loadData() {
        if (TextUtils.isEmpty(from)) setFrom(SongSourceApi.FROM_ALL);
        if (TextUtils.isEmpty(key)) setKey("长歌名行不行");
        view.showProgress("正在获取数据");
        SongSourceApi songSourceApi = retrofit.create(SongSourceApi.class);
        Observable<SearchSongResult> result = songSourceApi.getResult(from, key);
        result.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
            setData(searchSongResult);
            view.dismissProgress();
        });
    }
}
