package com.x930073498.MusicPlayer.http.api;

import android.support.annotation.StringDef;

import com.x930073498.MusicPlayer.screen.model.SearchSongResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by x930073498 on 17-5-16.
 */

public interface SongSourceApi {
    String FROM_NETEASE = "netease";
    String FROM_XIAMI = "xiami";
    String FROM_QQ = "qq";
    String FROM_ALL = "all";

    @StringDef({FROM_NETEASE, FROM_XIAMI, FROM_QQ, FROM_ALL})
    @interface VendorDef {

    }

    @GET("search/song/{vendor}")
    Observable<SearchSongResult> getResult(@VendorDef @Path("vendor") String vendor, @Query("key") String key);
}
