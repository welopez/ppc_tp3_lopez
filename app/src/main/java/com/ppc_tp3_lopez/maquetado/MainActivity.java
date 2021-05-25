package com.ppc_tp3_lopez.maquetado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGrupoRiesgo;
    Button btnInfoPacientes;
    Button btnCargaDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrupoRiesgo = findViewById(R.id.btnGrupoRiesgo);
        btnGrupoRiesgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(intent);
            }
        });

        btnInfoPacientes = findViewById(R.id.btnInfoPacientes);
        btnInfoPacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(intent);
            }
        });

        btnCargaDatos = (Button) findViewById(R.id.btnCargaDatos);
        btnCargaDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla4.class);
                startActivity(intent);
            }
        });
    }
}