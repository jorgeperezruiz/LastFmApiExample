package com.lastfm.akudreams.lastfmtest.models;

import com.google.gson.annotations.SerializedName;

public class AlbumSearchResponse {

    @SerializedName("results")
    private AlbumSearchResponseContent results;

    public AlbumSearchResponseContent getResults() {
        return results;
    }
}
