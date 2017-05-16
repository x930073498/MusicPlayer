package com.x930073498.core.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by x930073498 on 17-5-2.
 */
@Module
public class ApiModule {
    String baseUrl = "http://120.77.80.82:3389/";

//    public ApiModule(String baseUrl) {
//        this.baseUrl = baseUrl;
//    }

    @Provides
    @Singleton

    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return client;
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
