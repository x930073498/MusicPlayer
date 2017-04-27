package com.x930073498.musicplayer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.caimuhao.rxpicker.RxPicker;
import com.caimuhao.rxpicker.bean.ImageItem;
import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerViewAdapter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.x930073498.musicplayer.databinding.ActivityMainBinding;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.PublishSubject;
import sj.mblog.L;


public class MainActivity extends RxAppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setText("测试");

        RxPicker.init((imageView, path, width, height) -> Glide.with(imageView.
                getContext())
                .load(path)
                .override(width, height)
                .dontAnimate()
                .centerCrop()
                .into(imageView));

//         Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setOnClickListener((v) -> {
//
//        });

//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }


//    public void select(View view) {
//        RxPicker.of().single(false).camera(true).limit(3, 6).start(this).subscribe(imageItems -> Flowable.fromIterable(imageItems).map(ImageItem::getPath).subscribe(L::d));
//    }

    public void onClick(View view) {
        RxPicker.of().single(false).camera(false).limit(0, 3).start(this).subscribe(imageItems -> L.d(Flowable.fromIterable(imageItems).blockingFirst().getPath()), Throwable::printStackTrace);
    }
}
