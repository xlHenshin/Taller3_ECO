package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resultadoCalculo extends AppCompatActivity {

    private TextView nombre2, resultado;
    private Button otraVez;
    private ConstraintLayout pagina4;
    private String nombreUsuario, promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_calculo);

        nombre2 = findViewById(R.id.nombre2);
        resultado = findViewById(R.id.resultado);
        otraVez = findViewById(R.id.calcular2);
        pagina4 = findViewById(R.id.pagina4);

        nombreUsuario = getIntent().getExtras().getString("nombre");
        promedio = getIntent().getExtras().getString("promedio");
        Log.e(">>>", "" + promedio);

        nombre2.setText(nombreUsuario);
        resultado.setText(promedio);

        otraVez.setOnClickListener(

                v->{

                    finish();

                }
        );


    }

    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String colorPantalla = preferences.getString("color", "#FFFFFF");
        pagina4.setBackgroundColor(Color.parseColor(colorPantalla));

    }
}