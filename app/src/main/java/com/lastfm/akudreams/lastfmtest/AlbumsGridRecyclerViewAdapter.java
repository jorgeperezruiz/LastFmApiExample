package com.lastfm.akudreams.lastfmtest;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lastfm.akudreams.lastfmtest.models.Album;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import static com.lastfm.akudreams.lastfmtest.AlbumActivity.ALBUM_ARG;

public class AlbumsGridRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Album> albums;

    public AlbumsGridRecyclerViewAdapter() {
        this.albums = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View inflatedView = inflater.inflate(R.layout.album_holder, parent, false);
        return new AlbumViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AlbumViewHolder) {
            ((AlbumViewHolder) holder).updateWith(albums.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public void add(List<Album> albums) {
        this.albums.addAll(albums);
        notifyDataSetChanged();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private ImageView albumImageView;

        AlbumViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.album_title);
            albumImageView = itemView.findViewById(R.id.album_thumbnail);
        }

        void updateWith(Album album) {
            titleTextView.setText(album.getName());
            if (album.getImages().size() > 2) {
                Glide.with(albumImageView.getContext()).load(album.getImages().get(1).getUrl()).into(albumImageView);
            }

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), AlbumActivity.class);
                intent.putExtra(ALBUM_ARG, Parcels.wrap(album));
                itemView.getContext().startActivity(intent);
            });
        }

    }
}
