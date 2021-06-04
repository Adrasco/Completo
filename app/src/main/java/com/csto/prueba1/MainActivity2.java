package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText correo, pass1, pass2;
    private RadioButton hombre;
    private RadioButton mujer;
    private CheckBox micro;
    private Spinner comida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        correo = (EditText) findViewById(R.id.TXT_correoR);
        pass1 = (EditText) findViewById(R.id.TXT_contraseñaR);
        pass2 = (EditText) findViewById(R.id.TXT_contraseña2R);

        hombre = (RadioButton) findViewById(R.id.RB_1);
        mujer = (RadioButton) findViewById(R.id.RB_2);

        micro = (CheckBox) findViewById(R.id.CB_1);

        comida = (Spinner) findViewById(R.id.spinner);

    }

    public void verificar(View v){

        String error = "";

        String correo = this.correo.getText().toString();
        String pass1 = this.pass1.getText().toString();
        String pass2 = this.pass2.getText().toString();
        String genero = "Hombre";
        String micro = "no va en micro";
        String comida = this.comida.getSelectedItem().toString();

        if(this.hombre.isSelected()){genero = "Hombre";}
        if(this.mujer.isSelected()){genero = "Mujer";}
        if(this.micro.isSelected()){ micro = "Va en micro";}

        if(correo.equals("")){error += "\nCorreo vacio";}
        if(pass1.equals("")){error += "\nContraseña vacia";}
        if(pass2.equals("")){error += "\nRepita la contraseña";}
        if(comida.equals("Selecion..")){error += "\nSeleccione una comida";}

        if(!pass1.equals(pass2)){error += "\nLas contraseñas son distintas";}

        if(!error.equals("")){Toast.makeText(getApplicationContext(),error, Toast.LENGTH_LONG).show();}
        else{

            Intent I = new Intent(getApplicationContext(),MainActivity.class);
            I.putExtra("CORREO",correo);
            I.putExtra("PASS",pass1);
            I.putExtra("GENERO",genero);
            I.putExtra("MICRO",micro);
            I.putExtra("COMIDA",comida);
            startActivity(I);

        }

    }

}