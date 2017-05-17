package com.x930073498.MusicPlayer.dependencies.core;

import android.app.Application;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.x930073498.MusicPlayer.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by x930073498 on 17-5-2.
 */
@Module
public class ApiModule {
    private String baseUrl = "http://120.77.80.82:3389/";
//    public ApiModule(String baseUrl) {
//        this.baseUrl = baseUrl;
//    }

    private Context context;

    public ApiModule(Context context, String baseUrl) {
        this.baseUrl = baseUrl;
        this.context = context;
    }

    @Provides
    @Singleton
    Cache provideCache() {
        String cacheDir = context.getCacheDir().getAbsolutePath();
        File file = new File(cacheDir, "http");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Cache(file, 1024 * 1024 * 3);
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideBuilder(Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .cache(cache);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    String provideBaseUrl() {
        return baseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        return retrofit;
    }
}
