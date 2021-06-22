package com.example.projetombo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btCalculadora;
    private Button btLocal;
    private Button btNavegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCalculadora = (Button) findViewById(R.id.viewCalculadora);
        btLocal = (Button) findViewById(R.id.viewLocal);
        btNavegador = (Button) findViewById(R.id.viewNavegador);

        btCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Calculadora.class);
                startActivity(it);
            }
        });

        btLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Localizador.class);
                startActivity(it);
            }
        });

        btNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Navegador.class);
                startActivity(it);
            }
        });


    }
}