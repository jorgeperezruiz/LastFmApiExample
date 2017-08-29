package com.lastfm.akudreams.lastfmtest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class AlbumSearchResponseContent {

    @SerializedName("opensearch:itemsPerPage")
    private String itemsPerPage;

    @SerializedName("albummatches")
    private Map<String, List<Album>> albumsMap;

    public List<Album> getAlbums() {
        return albumsMap.get("album");
    }
}
