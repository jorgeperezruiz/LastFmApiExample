package com.lastfm.akudreams.lastfmtest;

import com.lastfm.akudreams.lastfmtest.models.Album;

import java.util.List;

public interface SearchAlbumListener {
    void onAlbumsLoaded(List<Album> albums);
}
