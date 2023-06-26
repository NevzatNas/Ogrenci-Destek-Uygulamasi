package com.example.ogrencidestekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class Kronometre_Screen extends AppCompatActivity {
    Button startBtn;
    Button resetBtn;
    Button pauseBtn;
    Chronometer chronometer;
    ImageView img;

    public int zamaniDurdur = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kronometre_screen);
        startBtn = findViewById(R.id.btnStart);
        resetBtn = findViewById(R.id.btnReset);
        pauseBtn = findViewById(R.id.btnPause);
        chronometer = findViewById(R.id.kronometre);
        img = findViewById(R.id.imageView11);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime() + zamaniDurdur);
                chronometer.start();
                startBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
                img.setImageDrawable(getDrawable(R.drawable.pause));
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                zamaniDurdur = 0;
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                img.setImageDrawable(getDrawable(R.drawable.start));
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zamaniDurdur = (int) (chronometer.getBase() - SystemClock.elapsedRealtime());
                chronometer.stop();
                pauseBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                img.setImageDrawable(getDrawable(R.drawable.start));
            }
        });

    }
}