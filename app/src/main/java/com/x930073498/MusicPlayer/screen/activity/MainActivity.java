package com.x930073498.MusicPlayer.screen.activity;

import android.app.Application;
import android.os.Bundle;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.x930073498.MusicPlayer.R;
import com.x930073498.MusicPlayer.databinding.ActivityMainBinding;
import com.x930073498.MusicPlayer.screen.view.MainView;
import com.x930073498.MusicPlayer.screen.viewModel.MainViewModel;
import com.x930073498.androidLib.Log.Log;
import com.x930073498.androidLib.RxResultActivity.RxResult;
import com.x930073498.core.mvvm.BaseActivity;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;


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
