package com.lastfm.akudreams.lastfmtest;

import android.util.Log;

import com.google.gson.stream.JsonReader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lastfm.akudreams.lastfmtest.models.Album;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String API_KEY = "e82d0c65c3f5c07f1f5957aab2a30e67";

    private LastFmApi lastFmApi;

    public NetworkService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.baseUrl("http://ws.audioscrobbler.com/");
        lastFmApi = builder.build().create(LastFmApi.class);
    }

    public void searchAlbums(String searchWord, SearchAlbumListener searchAlbumListener) {
        lastFmApi.searchAlbums(createParamsToSearchAlbum(searchWord))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    List<Album> albums = response.getResults().getAlbums();
                    searchAlbumListener.onAlbumsLoaded(albums);
                }, error -> Log.e("Error", "Error searching albums:" + error));
    }

    private Map<String, Object> createParamsToSearchAlbum(String searchWord) {
        Map<String, Object> params = new HashMap<>();
        params.put("api_key", API_KEY);
        params.put("method", "album.search");
        params.put("album", searchWord);
        params.put("format", "json");
        return params;
    }

}
