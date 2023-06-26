package com.example.ogrencidestekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView toDoApp;
    LinearLayout goKronometre;
    LinearLayout goCalculator;

    LinearLayout goPhoto;

    LinearLayout goBar;

    LinearLayout goDeneme2;

    LinearLayout goPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDoApp = findViewById(R.id.toDoList);
        goKronometre = findViewById(R.id.kronometreScreen);
        goCalculator = findViewById(R.id.goCalculator);
        goPhoto = findViewById(R.id.photoScreen);
        goBar = findViewById(R.id.goBar);
        goDeneme2 = findViewById(R.id.goDeneme2);
        goPass = findViewById(R.id.goPassword);

        goPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PasswordChangeActivity.class);
                startActivity(i);
            }
        });

        goDeneme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Deneme2023_Scren.class);
                startActivity(i);
            }
        });


        goBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Bar_Screen.class);
                startActivity(i);
            }
        });

        goPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Photo2_Screen.class);
                startActivity(i);
            }
        });

        goCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Puan_Screen.class);
                startActivity(i);
            }
        });

        goKronometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Kronometre_Screen.class);
                startActivity(i);
            }
        });

        toDoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ToDoList_Screen.class);
                startActivity(i);
            }
        });
    }
}