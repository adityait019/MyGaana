package com.example.mygaana;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    // Declare a boolean variable to track the button's state
    boolean isPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mediaPlayer
        mediaPlayer=MediaPlayer.create(this,R.raw.scam_ringtone);
        //play Button
        ImageButton playPauseButton= (ImageButton) findViewById(R.id.play_pause_button);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isPlaying=!isPlaying;
                if(isPlaying)
                {
                    playPauseButton.setBackgroundResource(R.drawable.pause);
                    Toast.makeText(MainActivity.this,"play",Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();
                }
                else  //pause button
                {
                    playPauseButton.setBackgroundResource(R.drawable.play);
                    mediaPlayer.pause();
                    Toast.makeText(MainActivity.this,"paused",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //prev button
        ImageButton prevButton= (ImageButton) findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(-1000);
                Toast.makeText(MainActivity.this,"skipped 1 sec",Toast.LENGTH_SHORT).show();
            }
        });
        //next button
        ImageButton nextButton=(ImageButton)findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(1000);
                Toast.makeText(MainActivity.this,"skipped 1 sec",Toast.LENGTH_SHORT).show();
            }
        });
        //up volume button
        ImageButton upButton=(ImageButton) findViewById(R.id.increase_vol_id);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mediaPlayer.setVolume(0.1f,0.5f);
            }
        });

        //down volume button
        ImageButton downButton=(ImageButton) findViewById(R.id.minus_vol_id);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setVolume(0.5f,0.1f);
            }
        });
    }
}