package com.example.android.musicstructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicstructure.Song;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {


    public SongAdapter(Context context, ArrayList<Song> words) {
        super(context, 0, words);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID SongName_text_view.
        TextView mSongNameTextView = (TextView) listItemView.findViewById(R.id.SongName_text_view);
        // Get the Song from the currentSong object and set this text on the SongName TextView.
        mSongNameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID ArtistName_text_view.
        TextView ArtistNameTextView = (TextView) listItemView.findViewById(R.id.ArtistName_text_view);
        // Get the Song from the currentSong object and set this text on the ArtistName TextView.
        ArtistNameTextView.setText(currentSong.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this song or not
        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentSong.getAlbumArt());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}