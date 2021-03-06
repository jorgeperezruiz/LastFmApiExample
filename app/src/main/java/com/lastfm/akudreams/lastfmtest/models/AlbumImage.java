package com.lastfm.akudreams.lastfmtest.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class AlbumImage {

    @SerializedName("#text")
    private String url;
    @SerializedName("size")
    private String size;

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }
}

