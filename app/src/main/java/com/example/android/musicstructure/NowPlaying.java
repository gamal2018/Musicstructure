package com.example.android.musicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicstructure.MainActivity;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Restore the current Song Name and display it
        TextView song_Text_View=(TextView)findViewById(R.id.songName);
        String song = getIntent().getStringExtra("Song Name");
        song_Text_View.setText("Song Name : "+song);

        //Restore the current Artist Name and display it
        TextView artist_Text_View=(TextView)findViewById(R.id.ArtistName);
        String artist = getIntent().getStringExtra("Artist Name");
        artist_Text_View.setText("Artist Name : "+artist);

        //Back to home page
        ImageView homePage = (ImageView) findViewById(R.id.home);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}
