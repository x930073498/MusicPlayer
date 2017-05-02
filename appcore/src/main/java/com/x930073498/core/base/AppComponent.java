package com.x930073498.core.base;

import android.content.Context;

import com.x930073498.core.http.ApiModule;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by x930073498 on 17-5-2.
 */

@Component(modules = {ApiModule.class, ApplicationModule.class})
public interface AppComponent {

}
