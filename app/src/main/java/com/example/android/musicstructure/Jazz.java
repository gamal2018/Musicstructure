package com.example.android.musicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.android.musicstructure.NowPlaying;
import com.example.android.musicstructure.Song;
import com.example.android.musicstructure.SongAdapter;

import java.util.ArrayList;

public class Jazz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Create a list of jazz songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Take Five", "Dave Brubeck", R.drawable.jazz_icon));
        songs.add(new Song("So What", "Miles Davis", R.drawable.jazz_icon));
        songs.add(new Song("Round Midnight", "Thelonious Mon", R.drawable.jazz_icon));
        songs.add(new Song("All Blues", "Miles Davis", R.drawable.jazz_icon));
        songs.add(new Song(" Fly Me to the Moon", "Frank Sinatra", R.drawable.jazz_icon));
        songs.add(new Song("My Funny Valentine", "Ella Fitzgerald", R.drawable.jazz_icon));
        songs.add(new Song("What a Wonderful World", "Louis Armstrong", R.drawable.jazz_icon));
        songs.add(new Song("Summertime", "Ella Fitzgerald", R.drawable.jazz_icon));
        songs.add(new Song("Body And Soul", "Amy Winehouse", R.drawable.jazz_icon));
        songs.add(new Song("Autumn Leaves", "Eva Cassidy", R.drawable.jazz_icon));

        //create object of SongAdapter
        SongAdapter songAdapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        //add songAdapter to listView
        listView.setAdapter(songAdapter);

        //Now playing Activity opened when user click on song to play
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Create a new intent to open Now playing
                Intent NowPlayingIntent = new Intent(Jazz.this, NowPlaying.class);
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
