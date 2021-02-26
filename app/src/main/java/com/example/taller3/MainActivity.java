package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button config, continuar;
    private ConstraintLayout pagina1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        config = findViewById(R.id.config);
        continuar = findViewById(R.id.continuar);
        pagina1 = findViewById(R.id.pagina1);

        config.setOnClickListener(

                v->{
                    Intent i = new Intent(this, colorPagina.class);
                    startActivity(i);
                }
        );

        continuar.setOnClickListener(

                v->{

                    String nombreUsuario = nombre.getText().toString();


                    if(nombreUsuario==null || nombreUsuario.isEmpty()){

                        Toast.makeText(this,"No ha digitado su nombre",Toast.LENGTH_SHORT).show();
                    }else{

                        Intent i = new Intent(this, calculoNota.class);
                        i.putExtra("nombre", nombreUsuario);
                        startActivity(i);
                        nombre.setText("");

                    }

                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String colorPantalla = preferences.getString("color", "#FFFFFF");
        pagina1.setBackgroundColor(Color.parseColor(colorPantalla));

    }
}