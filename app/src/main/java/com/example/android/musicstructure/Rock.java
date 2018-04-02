package com.example.android.musicstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.musicstructure.Song;
import com.example.android.musicstructure.SongAdapter;
import com.example.android.musicstructure.NowPlaying;
import com.example.android.musicstructure.Song;
import com.example.android.musicstructure.SongAdapter;

import java.util.ArrayList;

public class Rock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Create a list of Rock songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Born To Be Wild","Steppenwolf",R.drawable.rock_icon));
        songs.add(new Song("Stairway to Heaven","Led Zeppelin",R.drawable.rock_icon));
        songs.add(new Song("Smells Like Teen Spirit","Nirvana",R.drawable.rock_icon));
        songs.add(new Song("Dream On","Aerosmith",R.drawable.rock_icon));
        songs.add(new Song("Smoke On The Water","Deep Purple",R.drawable.rock_icon));
        songs.add(new Song("Free Bird","Lynyrd Skynyrd",R.drawable.rock_icon));
        songs.add(new Song("Layla","Derek and the Dominos",R.drawable.rock_icon));
        songs.add(new Song("Whole Lotta Love","Led Zeppelin",R.drawable.rock_icon));
        songs.add(new Song("Radioactive","Imagine Dragons",R.drawable.rock_icon));
        songs.add(new Song("Comfortably Numb","Pink Floyd",R.drawable.rock_icon));

        //create object of SongAdapter
        SongAdapter songAdapter= new SongAdapter(this, songs);
        //add songAdapter to listView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        //Now playing Activity opened when user click on song to play
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Create a new intent to open Now playing
                Intent NowPlayingIntent = new Intent(Rock.this, NowPlaying.class);
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
