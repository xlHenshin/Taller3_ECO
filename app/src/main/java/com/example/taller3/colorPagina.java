package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class colorPagina extends AppCompatActivity {

    private Button azul, blanco, negro;
    private ConstraintLayout pagina2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_pagina);

        azul = findViewById(R.id.azul);
        blanco = findViewById(R.id.blanco);
        negro = findViewById(R.id.negro);
        pagina2 = findViewById(R.id.pagina2);

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);

        azul.setOnClickListener(

                v->{

                    String colorAzul = "#457FDF";
                    preferences.edit().putString("color",colorAzul).apply();
                    finish();

                }
        );

        blanco.setOnClickListener(

                v->{

                    String colorBlanco = "#FFFFFF";
                    preferences.edit().putString("color", colorBlanco).apply();
                    finish();

                }
        );

        negro.setOnClickListener(

                v->{

                    String colorNegro = "#32343A";
                    preferences.edit().putString("color", colorNegro).apply();
                    finish();

                }
        );

    }

    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String colorPantalla = preferences.getString("color", "#FFFFFF");
        pagina2.setBackgroundColor(Color.parseColor(colorPantalla));

    }
}