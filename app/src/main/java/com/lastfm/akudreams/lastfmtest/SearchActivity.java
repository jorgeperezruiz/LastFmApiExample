package com.lastfm.akudreams.lastfmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.lastfm.akudreams.lastfmtest.models.Album;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchAlbumListener {

    private AlbumsGridRecyclerViewAdapter albumsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        FloatingSearchView searchView = findViewById(R.id.floating_search_view);
        searchView.setOnSearchListener(onSearchListener);

        RecyclerView albumsGridView = findViewById(R.id.albums_recyclerView);
        albumsAdapter = new AlbumsGridRecyclerViewAdapter();
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(getResources().getInteger(R.integer.columns), StaggeredGridLayoutManager.VERTICAL);
        albumsGridView.setLayoutManager(layoutManager);
        albumsGridView.setAdapter(albumsAdapter);

    }

    private final FloatingSearchView.OnSearchListener onSearchListener = new FloatingSearchView.OnSearchListener() {
        @Override
        public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
            // no op
        }

        @Override
        public void onSearchAction(String currentQuery) {
            new NetworkService().searchAlbums(currentQuery, SearchActivity.this);
        }
    };

    @Override
    public void onAlbumsLoaded(List<Album> albums) {
        albumsAdapter.add(albums);
    }
}
