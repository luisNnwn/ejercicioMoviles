package com.example.linearlayoutwebviewymas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Spinner_ejercicio extends AppCompatActivity {
    private Spinner spinner;
    private EditText num1, num2;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_ejercicio);

        spinner = findViewById(R.id.select);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.resul);

        String[] opciones = {"Suma", "Resta", "Multiplicacion", "Division"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Metodo que se ejecuta cuando el usuario hace clic en un boton
    public void operar(View view) {

        // Obtener el texto ingresado en los campos num1 y num2
        String strNum1 = num1.getText().toString();
        String strNum2 = num2.getText().toString();

        // Verificar si alguno de los dos campos esta vacio
        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            // Mostrar mensaje de error si falta un numero
            resultado.setText("Error: Ingrese ambos numeros.");
            return; // Salir del metodo
        }

        double n1, n2; // Variables donde se guardaran los numeros convertidos

        try {
            // Intentar convertir los textos a numeros decimales
            n1 = Double.parseDouble(strNum1);
            n2 = Double.parseDouble(strNum2);
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir mostrar mensaje
            resultado.setText("Error: Ingrese valores numericos validos.");
            return;
        }

        // Obtener la operacion seleccionada en el Spinner (lista desplegable)
        String operacion = spinner.getSelectedItem().toString();
        double res; // Variable para guardar el resultado

        // Elegir la operacion segun lo que el usuario selecciono
        switch (operacion) {
            case "Suma":
                res = n1 + n2;
                resultado.setText("Resultado: " + res);
                break;

            case "Resta":
                res = n1 - n2;
                resultado.setText("Resultado: " + res);
                break;

            case "Multiplicacion":
                res = n1 * n2;
                resultado.setText("Resultado: " + res);
                break;

            case "Division":
                if (n2 != 0) {
                    // Si el segundo numero no es cero, se puede dividir
                    res = n1 / n2;
                    resultado.setText("Resultado: " + res);
                } else {
                    // Si se intenta dividir por cero mostrar error
                    resultado.setText("Error: Division por cero");
                }
                break;

            default:
                // Si la operacion seleccionada no es valida
                resultado.setText("Error: Operacion no valida");
                break;
        }
    }
}