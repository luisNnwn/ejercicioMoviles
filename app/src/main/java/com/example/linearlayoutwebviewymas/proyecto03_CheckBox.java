package com.example.linearlayoutwebviewymas;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;


public class proyecto03_CheckBox extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv3;
    private CheckBox sumar, restar, multiplicar, dividir;


    @Override // constructor de la clase
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.proyecto03);

        // traspaso de variables
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv3 = (TextView)findViewById(R.id.tv3);


        sumar = (CheckBox)findViewById(R.id.sumar);
        restar = (CheckBox)findViewById(R.id.restar);
        multiplicar = (CheckBox)findViewById(R.id.multiplicar);
        dividir = (CheckBox)findViewById(R.id.dividir);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //construccion de metodos.
    public void operar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nrol2 = Integer.parseInt(valor2);

        String resultado = "";


        if (sumar.isChecked()==true) {
            int sumar = nro1 + nrol2;
            resultado += "La suma es: " + sumar + "\n";
        }
        if (restar.isChecked()==true) {
            int restar = nro1 - nrol2;
            resultado += "La resta es: " + restar + "\n";
        }
        if (multiplicar.isChecked()==true) {
            int multiplicar = nro1 * nrol2;
            resultado += "La multiplicacion es: " + multiplicar + "\n";
        }
        if (dividir.isChecked()==true) {
            int dividir = nro1 / nrol2;
            resultado += "La division es: " + dividir;

        }
        tv3.setText(resultado);


    }
}