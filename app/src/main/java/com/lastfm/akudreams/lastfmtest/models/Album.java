package com.lastfm.akudreams.lastfmtest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {
    @SerializedName("name")
    private String name;
    @SerializedName("artist")
    private String artist;
    @SerializedName("url")
    private String url;
    @SerializedName("streamable")
    private String streamable;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("image")
    private List<AlbumImage> images;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public String getStreamable() {
        return streamable;
    }

    public String getMbid() {
        return mbid;
    }

    public List<AlbumImage> getImages() {
        return images;
    }

}
