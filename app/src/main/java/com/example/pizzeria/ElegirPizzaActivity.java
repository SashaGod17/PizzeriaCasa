package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ElegirPizzaActivity extends AppCompatActivity {

    private Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligir);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        cliente = (Cliente) getIntent().getParcelableExtra("Cliente");
        Button boton = (Button) findViewById(R.id.btnNuestrasPizzas);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nuestrasPizzas = new Intent(ElegirPizzaActivity.this, NuestrasPizzasActivity.class);
                nuestrasPizzas.putExtra("Cliente", cliente);
                startActivity(nuestrasPizzas);
            }
        });
    }

   /* public void irNuestrasPizzas(View v){
        System.out.println("Intento iniciado");
        Intent nuestrasPizzas = new Intent(ElegirPizzaActivity.this, NuestrasPizzasActivity.class);
        startActivity(nuestrasPizzas);

    } */
}
