package com.example.linearlayoutwebviewymas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class botones extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    private Button sumar, restar, multiplicar, dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_botones);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.resultado);
        sumar = findViewById(R.id.sumar);
        restar = findViewById(R.id.restar);
        multiplicar = findViewById(R.id.multiplicar);
        dividir = findViewById(R.id.dividir);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //funcion para sumar y mostrar el resultado
    public void sumar(View view) {
        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();
        if (!valor1.isEmpty() && !valor2.isEmpty()) {
            int resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
            result.setText(String.valueOf(resultado));
        } else {
            result.setText("Ingrese ambos números");
        }
    }

    //funcion para restar y mostrar el resultado
    public void restar(View view) {
        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();
        if (!valor1.isEmpty() && !valor2.isEmpty()) {
            int resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
            result.setText(String.valueOf(resultado));
        } else {
            result.setText("Ingrese ambos números");
        }
    }

    //funcion para multiplicar y mostrar el resultado
    public void multiplicar(View view) {
        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();
        if (!valor1.isEmpty() && !valor2.isEmpty()) {
            int resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
            result.setText(String.valueOf(resultado));
        } else {
            result.setText("Ingrese ambos números");
        }
    }

    //funcion para dividir y mostrar el resultado
    public void dividir(View view) {
        String valor1 = num1.getText().toString();
        String valor2 = num2.getText().toString();
        if (!valor1.isEmpty() && !valor2.isEmpty()) {
            if (Integer.parseInt(valor2) != 0) {
                int resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
                result.setText(String.valueOf(resultado));
            } else {
                result.setText("No se puede dividir por cero");
            }
        } else {
            result.setText("Ingrese ambos números");
        }
    }

    public void salir(View view) {
        finish();
    }
}