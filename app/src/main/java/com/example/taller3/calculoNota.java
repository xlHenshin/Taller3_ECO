package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculoNota extends AppCompatActivity {

    private EditText proyectoparcial1, proyectoparcial2, quices, parcial1, parcial2;
    private Button calcular;
    private ConstraintLayout pagina3;
    private String nombreUsuario;
    private double promedio;
    private boolean verification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_nota);

        verification = true;

        proyectoparcial1 = findViewById(R.id.proyectoparcial1);
        proyectoparcial2 = findViewById(R.id.proyectoparcial2);
        quices = findViewById(R.id.quices);
        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);
        calcular = findViewById(R.id.calcular);
        pagina3 = findViewById(R.id.pagina3);

        nombreUsuario = getIntent().getExtras().getString("nombre");

        calcular.setOnClickListener(

                v -> {

                    verification=true;
                    calcularPromedio();
                    if (verification) {

                        Intent i = new Intent(this, resultadoCalculo.class);
                        i.putExtra("nombre", nombreUsuario);
                        String prom = String.valueOf(promedio);
                        i.putExtra("promedio", prom);
                        startActivity(i);
                        finish();

                    }
                }

        );

    }

    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String colorPantalla = preferences.getString("color", "#FFFFFF");
        pagina3.setBackgroundColor(Color.parseColor(colorPantalla));

    }

    public void calcularPromedio() {

        String proyecto1 = proyectoparcial1.getText().toString();
        String proyecto2 = proyectoparcial2.getText().toString();
        String quiz = quices.getText().toString();
        String par1 = parcial1.getText().toString();
        String par2 = parcial2.getText().toString();

        double nota1, nota2, nota3, nota4, nota5;
        nota1 = 0;
        nota2 = 0;
        nota3 = 0;
        nota4 = 0;
        nota5 = 0;


        String[] listaNotas = new String[]{
                proyecto1,
                proyecto2,
                quiz,
                par1,
                par2
        };

        if (verification) {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] == null || listaNotas[i].isEmpty()) {
                    Toast.makeText(this, "Ingrese todos los valores", Toast.LENGTH_SHORT).show();
                    verification = false;
                } else {

                    double numeroNota = Double.parseDouble(listaNotas[i]);
                    if (numeroNota > 5) {
                        Toast.makeText(this, "Las calificacion van de 1 a 5", Toast.LENGTH_SHORT).show();
                        verification = false;
                    } else {

                        if (i == 0) {
                            nota1 = numeroNota;
                        } else if (i == 1) {
                            nota2 = numeroNota;
                        } else if (i == 2) {
                            nota3 = numeroNota;
                        } else if (i == 3) {
                            nota4 = numeroNota;
                        } else if (i == 4) {
                            nota5 = numeroNota;
                        }

                    }

                    double prom = ((nota1 * 0.25) + (nota2 * 0.25) + (nota3 * 0.20) + (nota4 * 0.15) + (nota5 * 0.15));
                    promedio = Math.round(prom * 100.0) / 100.0;

                    Log.e(">>>", "" + promedio);

                }
            }

        }

    }

}