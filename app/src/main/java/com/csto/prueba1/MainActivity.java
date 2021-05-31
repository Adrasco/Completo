package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText correo, pass;

    private String correoR, passR, generoR, microR, comidaR;

    boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = (EditText) findViewById(R.id.TXT_correo);
        pass = (EditText) findViewById(R.id.TXT_pass);

        try {

            correoR = getIntent().getStringExtra("CORREO");
            passR = getIntent().getStringExtra("PASS");
            generoR = getIntent().getStringExtra("GENERO");
            microR = getIntent().getStringExtra("MICRO");
            comidaR = getIntent().getStringExtra("COMIDA");

            if(!correoR.equals("")){this.b = true;}

        }catch (Exception e){this.b=false;}

    }

    public void Reguistrarse(View v){Intent I = new Intent(getApplicationContext(),MainActivity2.class);startActivity(I);}

    public void IniciarSecion(View v){

        if(this.b){

            String co = correo.getText().toString();
            String pas = pass.getText().toString();

            if(correoR.equals(co) && passR.equals(pas)) {

                Intent I = new Intent(getApplicationContext(), MainActivity3.class);
                I.putExtra("CORREO", correoR);
                I.putExtra("PASS", passR);
                I.putExtra("GENERO", generoR);
                I.putExtra("MICRO", microR);
                I.putExtra("COMIDA", comidaR);
                startActivity(I);
            }else{Toast.makeText(getApplicationContext(),"Datos de cuenta erroneos", Toast.LENGTH_LONG).show();}
        }
        else{Toast.makeText(getApplicationContext(),"Registrese", Toast.LENGTH_LONG).show();}}

}