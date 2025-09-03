package com.example.linearlayoutwebviewymas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListView_ejercicio extends AppCompatActivity {
    private String[] paises = {
            "Antigua y Barbuda", "Argentina", "Bahamas", "Barbados", "Belice", "Bolivia",
            "Brasil", "Canadá", "Chile", "Colombia", "Costa Rica", "Cuba", "Dominica",
            "Ecuador", "El Salvador", "Estados Unidos", "Granada", "Guatemala", "Guyana",
            "Haití", "Honduras", "Jamaica", "México", "Nicaragua", "Panamá", "Paraguay",
            "Perú", "República Dominicana", "San Cristóbal y Nieves", "San Vicente y las Granadinas",
            "Santa Lucía", "Surinam", "Trinidad y Tobago", "Uruguay", "Venezuela"
    };

    private String[] habitantes = {
            "97000","47327407","400000","287000","400000","12000000","214000000","38000000","19000000","52000000",
            "5000000","11000000","72000","18000000","6500000","333000000","112000","18000000","800000","11500000",
            "10000000","3000000","129000000","6700000", "4400000","7400000","34000000","11000000","53000",
            "110000","180000","600000","1400000","3500000","28000000"
    };


    private TextView tv1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_ejercicio);

        tv1 = findViewById(R.id.tv1);
        lv1 = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                tv1.setText("La poblacion de : " + lv1.getItemAtPosition(position) + "\nes: " + habitantes[position]);
                Toast.makeText(ListView_ejercicio.this, "La población de " + paises[position] + " es: " + habitantes[position], Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}