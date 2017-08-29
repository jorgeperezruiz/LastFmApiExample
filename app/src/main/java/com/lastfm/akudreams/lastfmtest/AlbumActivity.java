package com.lastfm.akudreams.lastfmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lastfm.akudreams.lastfmtest.models.Album;

import org.parceler.Parcels;

public class AlbumActivity extends AppCompatActivity {

    public static final String ALBUM_ARG = "ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Album album = Parcels.unwrap(getIntent().getParcelableExtra(ALBUM_ARG));

        TextView titleTextView = findViewById(R.id.album_title);
        TextView artistTextView = findViewById(R.id.album_artist);
        ImageView albumImageView = findViewById(R.id.album_thumbnail);

        titleTextView.setText(album.getName().toUpperCase());
        artistTextView.setText(album.getArtist());
        Glide.with(albumImageView.getContext()).load(album.getImages().get(1).getUrl()).into(albumImageView);
    }
}
