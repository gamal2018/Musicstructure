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

public class Pop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Create a list of Pop songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Havana", "Camila Cabello", R.drawable.pop_icon));
        songs.add(new Song("Shape of You", "Ed Sheeran", R.drawable.pop_icon));
        songs.add(new Song("New Rules", "Dua Lipa", R.drawable.pop_icon));
        songs.add(new Song("Finesse", "Bruno Mars", R.drawable.pop_icon));
        songs.add(new Song("That's What I Like", "Bruno Mars", R.drawable.pop_icon));
        songs.add(new Song("Attention", "Charlie Puth", R.drawable.pop_icon));
        songs.add(new Song("Closer", "The Chainsmokers", R.drawable.pop_icon));
        songs.add(new Song("Uptown Funk", "Mark Ronson", R.drawable.pop_icon));
        songs.add(new Song("What About Us", "P!nk", R.drawable.pop_icon));
        songs.add(new Song("Rolling in the Deep", "Adele", R.drawable.pop_icon));

        //create object of SongAdapter
        SongAdapter songAdapter = new SongAdapter(this, songs);
        //add songAdapter to listView
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        //Now playing intent opened when user click on song to play
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Create a new intent to open Now playing
                Intent NowPlayingIntent = new Intent(Pop.this, NowPlaying.class);
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
