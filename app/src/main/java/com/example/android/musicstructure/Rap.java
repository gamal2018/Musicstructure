package com.example.android.musicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.musicstructure.Song;
import com.example.android.musicstructure.SongAdapter;
import com.example.android.musicstructure.NowPlaying;

import java.util.ArrayList;

public class Rap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Create a list of Rap songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("God's Plan", "Drake", R.drawable.rap_icon));
        songs.add(new Song("Shook Ones, Part II", "Mobb Deep", R.drawable.rap_icon));
        songs.add(new Song("Nuthin' but a G Thang", "Dr. Dre", R.drawable.rap_icon));
        songs.add(new Song("Lose Yourself", "Eminem", R.drawable.rap_icon));
        songs.add(new Song(" Rapper's Delight", "The Sugarhill Gang", R.drawable.rap_icon));
        songs.add(new Song("Juicy", "The Notorious B.I.G.", R.drawable.rap_icon));
        songs.add(new Song("Ric Flair Drip", "Offset", R.drawable.rap_icon));
        songs.add(new Song("Mask Off", "Future", R.drawable.rap_icon));
        songs.add(new Song("California Love", "Tupac Shakur", R.drawable.rap_icon));
        songs.add(new Song("Regulate", "Warren G", R.drawable.rap_icon));

        //create object of SongAdapter
        SongAdapter songAdapter = new SongAdapter(this, songs);
        //add songAdapter to listView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        //Now playing Activity opened when user click on song to play
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Create a new intent to open Now playing
                Intent NowPlayingIntent = new Intent(Rap.this, NowPlaying.class);
                //create an object of Song and store the data of current song
                Song s = songs.get(position);
                //pass Song Name to the NowPlayingIntent
                NowPlayingIntent.putExtra("Song Name", s.getSongName());
                //pass Artist Name to the NowPlayingIntent
                NowPlayingIntent.putExtra("Artist Name", s.getArtistName());
                // Start the NowPlaying activity
                startActivity(NowPlayingIntent);
            }
        });
    }
}
