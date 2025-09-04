package com.example.linearlayoutwebviewymas;

//imports de la aplicacion
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;


/*Esta aplicación consta de 5 actividades, las cuales se acceden
* a través de los métodos de la clase MainActivity con la finalidad
* de primero, aplicar un layout horizontal y la función de webView y la implementación
* de los cinco problemas desarrollados en la unidad uno. Aplicando los conocimientos
* aprendidos en la clase*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /*Con estos metodos se lanzan las actividades correspondientes*/

    //metodo para lanzar el webView
    public void verWV (View view) {
        //obtenemos el texto del editText
        EditText et1 = findViewById(R.id.et1);
        //obtenemos la direccion
        String direccion = et1.getText().toString();
        //creamos el intent
        Intent intent = new Intent(this, Proyecto06WV.class);
        //pasamos la direccion a la actividad
        intent.putExtra("direccion", direccion);
        //lanzammos la actividad
        startActivity(intent);
    }

    //metodo para lanzar el ListView
    public void verListView (View view) {
        Intent intent = new Intent(this, ListView_ejercicio.class);
        startActivity(intent);
    }

    //metodo para lanzar RadioButtons
    public void verRadioButtons (View view) {
        Intent intent = new Intent(this, proyecto02_RadioButtons.class);
        startActivity(intent);
    }

    //metodo para lanzar CheckBox
    public void verCheckBox (View view) {
        Intent intent = new Intent(this, proyecto03_CheckBox.class);
        startActivity(intent);
    }

    //metodo para lanzar Spinner
    public void verSpinner (View view) {
        Intent intent = new Intent(this, Spinner_ejercicio.class);
        startActivity(intent);
    }

    //metodo para lanzar Botones
    public void verBotones (View view) {
        Intent intent = new Intent(this, botones.class);
        startActivity(intent);
    }



}