package com.csto.prueba1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText correo, pass;

    private TextView anuncio;

    private String correoR, passR, generoR, microR, comidaR;

    boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = (EditText) findViewById(R.id.TXT_correo);
        pass = (EditText) findViewById(R.id.TXT_pass);
        anuncio = (TextView) findViewById(R.id.txt_anuncio);

        try {anuncio.setText(getIntent().getStringExtra("anuncio"));}catch (Exception e){}


    }

    public void Reguistrarse(View v){Intent I = new Intent(getApplicationContext(),MainActivity2.class);startActivity(I);}

    public void IniciarSecion(View v) {

        SQLiteDatabase db;
        Base_datos conn = new Base_datos(getApplicationContext());
        db = conn.getReadableDatabase();

        String SQL = "SELECT id_persona FROM persona " +
                "WHERE nom = ? and pass  = ? ;";

        String[] WHERE = {correo.getText().toString(), pass.getText().toString()};

        Cursor C = db.rawQuery(SQL, WHERE);

        if (C != null) {

            if (C.moveToFirst()) {

                Intent I = new Intent(getApplicationContext(), MainActivity3.class);
                I.putExtra("ID", C.getString(0));
                startActivity(I);

            }else {
                anuncio.setText("Datos erroneos, registrese");}

        } else {
            anuncio.setText("Datos erroneos, registrese");
        }

    }

}