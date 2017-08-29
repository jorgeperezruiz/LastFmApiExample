package com.lastfm.akudreams.lastfmtest;

import com.lastfm.akudreams.lastfmtest.models.AlbumSearchResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface LastFmApi {
    @GET("2.0/")
    Observable<AlbumSearchResponse> searchAlbums(@QueryMap Map<String, Object> options);
}
