package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity3 extends AppCompatActivity implements OnMapReadyCallback {

    private TextView texto;
    private GoogleMap mMap;
    private static String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        texto = (TextView) findViewById(R.id.TXT_bienvenida);

        String id = getIntent().getStringExtra("ID");

        SQLiteDatabase db;
        Base_datos conn = new Base_datos(getApplicationContext());
        db = conn.getReadableDatabase();

        String SQL = "SELECT * FROM persona " +
                "WHERE id_persona = ? ;";

        String[] WHERE = {id};

        Cursor C = db.rawQuery(SQL,WHERE);

        String nombre = "";
        String pass = "";
        String sexo = "Mujer";
        String comida = "";
        String micro = "Usa micro";

        if(C!=null){

            if(C.moveToFirst()){

                ID = C.getString(0);
                nombre = C.getString(1);
                pass = C.getString(2);
                comida = C.getString(4);

                if(C.getInt(3) == 0){sexo = "Hombre";}
                if(C.getInt(5) == 0 ){micro = "Le gusta caminar";}

                texto.setText(
                        "Usuario: "+nombre+
                        "\nContraseña: "+pass+
                        "\nComida favorita: "+comida+
                        "\nSexo: "+sexo+
                        "\n"+micro);

            }

        }



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void CerrarSecion(View v){

        Intent I = new Intent(getApplicationContext(),MainActivity.class);
        I.putExtra("anuncio","Secion cerrada");
        startActivity(I);

    }

    public void EliminarSecion(View v){

        Intent I = new Intent(getApplicationContext(),MainActivity.class);

        SQLiteDatabase db;
        Base_datos conn = new Base_datos(getApplicationContext());
        db = conn.getReadableDatabase();

        String where = " id_persona = ? ";
        String[] PKS = {ID};

        db.delete("persona",where,PKS);

        I.putExtra("anuncio","Usted ahora no existe, por lo tanto no puede leer esto");
        startActivity(I);

    }


}