package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        texto = (TextView) findViewById(R.id.TXT_bienvenida);

        String correoR = getIntent().getStringExtra("CORREO");
        String passR = getIntent().getStringExtra("PASS");
        String generoR = getIntent().getStringExtra("GENERO");
        String microR = getIntent().getStringExtra("MICRO");
        String comidaR = getIntent().getStringExtra("COMIDA");

        texto.setText("Correo: "+correoR+"\nContraseña: "+passR+"\nGenero: "+generoR+"\n"+microR+"\nComida: "+comidaR);

    }



}