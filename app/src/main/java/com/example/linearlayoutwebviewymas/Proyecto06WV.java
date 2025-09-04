package com.example.linearlayoutwebviewymas;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Proyecto06WV extends AppCompatActivity {

    //declaramos el webView
    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_proyecto06_wv);

        //traspaso de variables
        webView1 = (WebView) findViewById(R.id.webView1);
        //obtenemos la direccion de la actividad anterior
        Bundle bundle = getIntent().getExtras();
        //si la direccion no esta vacia la cargamos
        if (bundle != null && bundle.containsKey("direccion")) {
            String dato = bundle.getString("direccion");
            //si la direccion no empieza con http o https la agregamos
            if (!TextUtils.isEmpty(dato)) {
                if (!dato.startsWith("http://") && !dato.startsWith("https://")) {
                    dato = "https://" + dato;
                }
                //cargamos la direccion
                webView1.loadUrl(dato);
            } else {
                //si la direccion esta vacia mostramos un mensaje
                Toast.makeText(this, "La dirección está vacía", Toast.LENGTH_SHORT).show();
            }
        } else {
            //si no se recibe ninguna direccion mostramos un mensaje
            Toast.makeText(this, "No se recibió ninguna dirección", Toast.LENGTH_SHORT).show();
        }

        //configuramos el webView para que muestre la pagina web con javascript habilitado
        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView1.setWebViewClient(new WebViewClient());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //metodo para finalizar la actividad
    public void finalizar(View v) {
        finish();
    }
}