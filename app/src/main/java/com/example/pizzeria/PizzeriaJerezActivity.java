package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PizzeriaJerezActivity extends AppCompatActivity {

    Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzeria_jerez_layout);
        cliente = (Cliente) getIntent().getParcelableExtra("Cliente");
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        Button btnElegir =(Button) findViewById(R.id.btnEligirPizza);
        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PizzeriaJerezActivity.this, NuestrasPizzasActivity.class);
                intent.putExtra("Cliente", cliente);
                startActivity(intent);
            }
        });
        Button btnConfigurar = (Button) findViewById(R.id.btnConfigurar);
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PizzeriaJerezActivity.this, ConfigurarActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
