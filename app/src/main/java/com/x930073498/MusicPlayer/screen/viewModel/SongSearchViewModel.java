package com.x930073498.MusicPlayer.screen.viewModel;

import android.databinding.Bindable;
import android.text.TextUtils;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.x930073498.MusicPlayer.BR;
import com.x930073498.MusicPlayer.http.api.SongSourceApi;
import com.x930073498.MusicPlayer.screen.model.SearchSongResult;
import com.x930073498.MusicPlayer.screen.view.SongSearchView;
import com.x930073498.core.mvvm.IVM;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by x930073498 on 17-5-16.
 */

public class SongSearchViewModel extends IVM<SongSearchView, SearchSongResult> {

    private Retrofit retrofit;


    private
    @SongSourceApi.VendorDef
    String from;
    private String key;

    @SongSourceApi.VendorDef
    @Bindable
    public String getFrom() {
        return from;
    }

    @Subscribe(tags = @Tag("setFrom"))
    public void setFrom(@SongSourceApi.VendorDef String from) {
        this.from = from;
        notifyPropertyChanged(BR.from);
    }

    @Bindable
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
        notifyPropertyChanged(BR.key);
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
        view.showChooseDialog();
    }


    public void loadData() {
        if (TextUtils.isEmpty(from)) setFrom(SongSourceApi.FROM_ALL);
        if (TextUtils.isEmpty(key)) setKey("长歌名行不行");
        view.showProgress("正在获取数据");
        SongSourceApi songSourceApi = retrofit.create(SongSourceApi.class);
        switch (from) {
            case SongSourceApi.FROM_ALL:
                songSourceApi.getResult(from, key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    setData(searchSongResult);
                    view.dismissProgress();
                });
                break;
            case SongSourceApi.FROM_XIAMI:

                songSourceApi.getXiamiResult(from, key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    SearchSongResult result = new SearchSongResult();
                    result.setSourceFromXiami(searchSongResult);
                    setData(result);
                    view.dismissProgress();
                });
                break;
            case SongSourceApi.FROM_QQ:
                songSourceApi.getOtherSingleResult(from, key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    SearchSongResult result = new SearchSongResult();
                    result.setSourceFromQQ(searchSongResult);
                    setData(result);
                    view.dismissProgress();
                });
                break;
            case SongSourceApi.FROM_NETEASE:
                songSourceApi.getOtherSingleResult(from, key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    SearchSongResult result = new SearchSongResult();
                    result.setSourceFromNetease(searchSongResult);
                    setData(result);
                    view.dismissProgress();
                });
                break;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
