package com.x930073498.MusicPlayer.screen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.x930073498.MusicPlayer.screen.view.SecondView;
import com.x930073498.MusicPlayer.screen.viewModel.SecondViewModel;
import com.x930073498.core.mvvm.BaseActivity;
import com.x930073498.musicplayer.R;
import com.x930073498.musicplayer.databinding.ActivitySecondBinding;

/**
 * Created by x930073498 on 17-5-5.
 */

public class SecondActivity extends BaseActivity<ActivitySecondBinding, SecondViewModel> implements SecondView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        dataBinding.setVM(ViewModel);
    }

    @Override
    protected boolean useAndroidInject() {
        return true;
    }

    @Override
    public void onBackPressed() {
        setResultAndFinish();
    }

    @Override
    public void setResultAndFinish() {
//        Intent intent = new Intent();
//        intent.putExtra("data", "test");
//        setResult(1000, intent);
//        finish();
        startActivity(new Intent(this, SongSearchActivity.class));
    }
}
