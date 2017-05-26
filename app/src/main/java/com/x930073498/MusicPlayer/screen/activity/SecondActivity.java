package com.x930073498.MusicPlayer.screen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.x930073498.MusicPlayer.R;
import com.x930073498.MusicPlayer.databinding.ActivitySecondBinding;
import com.x930073498.MusicPlayer.screen.view.SecondView;
import com.x930073498.MusicPlayer.screen.viewModel.SecondViewModel;
import com.x930073498.MusicPlayer.core.mvvm.BaseActivity;

import java.util.ArrayList;

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
        ArrayList<String> data=new ArrayList<>();
        data.add("t");
        data.add("e");
        data.add("s");
        data.add("t");
        Intent intent = new Intent();
        intent.putExtra("data", data);
        setResult(1000, intent);
        finish();
    }

    @Override
    public void startNextActivity() {
        startActivity(new Intent(this, SongSearchActivity.class).putExtra("key", "叶里"));
    }
}
