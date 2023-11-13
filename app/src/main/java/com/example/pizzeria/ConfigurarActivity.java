package com.example.pizzeria;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class ConfigurarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        View vista = findViewById(R.id.configLayout);
        vista.setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        Button btnRojo = findViewById(R.id.btnRojo);
        Button btnVerde = findViewById(R.id.btnVerde);
        Button btnAzul = findViewById(R.id.btnAzul);
        btnRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(Color.RED);
            }
        });
        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(Color.BLUE);
            }
        });
        btnVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(Color.GREEN);
            }
        });
    }
    private void cambiarColor(int color){
        ManejadorColores.setColor(color);

        actualizarColorDeFondoEnTodasLasActividades();

        reiniciarActividadActual();
    }

    private void actualizarColorDeFondoEnTodasLasActividades() {
        for (Activity activity : AppManager.getInstance().getActivities()) {
            if (activity != null) {
                activity.getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
            }
        }
    }

    private void reiniciarActividadActual() {

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
