package com.example.android.musicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the image for pop music
        ImageView pop = (ImageView) findViewById(R.id.pop);
        // handle the user click on the pop music image
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Pop}
                Intent popIntent = new Intent(MainActivity.this, com.example.android.musicstructure.Pop.class);
                //start pop activity
                startActivity(popIntent);
            }
        });

        //find the image for jazz music
        ImageView jazz = (ImageView) findViewById(R.id.jazz);
        // handle the user click on the jazz music image
        jazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link jazz}
                Intent jazzIntent = new Intent(MainActivity.this, com.example.android.musicstructure.Jazz.class);
                //start jazz activity
                startActivity(jazzIntent);
            }
        });

        //find the image for rap music
        ImageView rap = (ImageView) findViewById(R.id.rap);
        // handle the user click on the rap music image
        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link rap}
                Intent rapIntent = new Intent(MainActivity.this, com.example.android.musicstructure.Rap.class);
                //start rap activity
                startActivity(rapIntent);
            }
        });

        //find the image for rock music
        ImageView rock = (ImageView) findViewById(R.id.rock);
        // handle the user click on the rock music image
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link rock}
                Intent rockIntent = new Intent(MainActivity.this, com.example.android.musicstructure.Rock.class);
                //start rock activity
                startActivity(rockIntent);
            }
        });
    }
}
