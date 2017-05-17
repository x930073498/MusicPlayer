package com.x930073498.MusicPlayer.screen.viewModel;

import android.databinding.Bindable;
import android.text.TextUtils;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
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



    public SongSearchViewModel(SongSearchView view, SearchSongResult data, LifecycleProvider<ActivityEvent> lifecycleProvider) {
        super(view, data, lifecycleProvider);
    }

    public void showChooseDialog() {
        view.showChooseDialog();
    }

    @Override
    protected boolean useRxBus() {
        return true;
    }

    public void loadData() {
        loadData(retrofit);
    }

    public void loadData(Retrofit retrofit) {
        if (this.retrofit == null) this.retrofit = retrofit;
        if (TextUtils.isEmpty(from)) setFrom(SongSourceApi.FROM_ALL);
        if (TextUtils.isEmpty(key)) setKey("长歌名行不行");
        view.showProgress("正在获取数据");
        SongSourceApi songSourceApi = retrofit.create(SongSourceApi.class);
        switch (from) {
            case SongSourceApi.FROM_ALL:
                songSourceApi.getResult(from, key).subscribeOn(Schedulers.io()).compose(lifecycleProvider.bindToLifecycle()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    setData(searchSongResult);
                    view.dismissProgress();
                });
                break;
            case SongSourceApi.FROM_XIAMI:

                songSourceApi.getXiamiResult(from, key).compose(lifecycleProvider.bindToLifecycle()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    SearchSongResult result = new SearchSongResult();
                    result.setSourceFromXiami(searchSongResult);
                    setData(result);
                    view.dismissProgress();
                });
                break;
            case SongSourceApi.FROM_QQ:
                songSourceApi.getOtherSingleResult(from, key).compose(lifecycleProvider.bindToLifecycle()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    SearchSongResult result = new SearchSongResult();
                    result.setSourceFromQQ(searchSongResult);
                    setData(result);
                    view.dismissProgress();
                });
                break;
            case SongSourceApi.FROM_NETEASE:
                songSourceApi.getOtherSingleResult(from, key).compose(lifecycleProvider.bindToLifecycle()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchSongResult -> {
                    SearchSongResult result = new SearchSongResult();
                    result.setSourceFromNetease(searchSongResult);
                    setData(result);
                    view.dismissProgress();
                });
                break;
        }

    }

}
