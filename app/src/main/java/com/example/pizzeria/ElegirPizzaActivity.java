package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ElegirPizzaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligir);
        Button boton = (Button) findViewById(R.id.btnNuestrasPizzas);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Intento iniciado");
                Intent nuestrasPizzas = new Intent(ElegirPizzaActivity.this, NuestrasPizzasActivity.class);
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
