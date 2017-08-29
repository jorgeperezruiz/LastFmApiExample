package com.lastfm.akudreams.lastfmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lastfm.akudreams.lastfmtest.models.Album;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchAlbumListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        new NetworkService().searchAlbums("space", this);
    }

    @Override
    public void onAlbumsLoaded(List<Album> albums) {
        Log.d(SearchActivity.this.toString(), "Loaded albums " + albums.size());
    }
}
