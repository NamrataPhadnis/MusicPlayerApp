package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnTouchListener, View.OnClickListener {
    MediaPlayer mediaPlayer,mediaPlayer1;
    SoundPool soundPool;
    int explosion = 0;
    Random random=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        View view = new View(this);
        view.setOnClickListener(this);   //1
        view.setOnTouchListener(this);  //2three events
        view.setOnLongClickListener(this);  //3
        setContentView(view);
        mediaPlayer = MediaPlayer.create(this, R.raw.testmusic);
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundmusic);
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        explosion = soundPool.load(this, R.raw.explosion, 0);//
        view.setBackgroundColor(Color.rgb(random.nextInt(256),random.nextInt(278),random.nextInt(250)));

        // mediaPlayer.start();
        //mediaPlayer.seekTo(3000); made changes

    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer.start();
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //mediaPlayer.start();
        if (explosion != 0) {
            soundPool.play(explosion,1,1,0,0,1);
            view.setBackgroundColor(Color.rgb(random.nextInt(256),random.nextInt(278),random.nextInt(250)));

        }


        return false;
}

    @Override
    public void onClick(View view) {
       // mediaPlayer.stop();
        //mediaPlayer1.start();

    }
}
