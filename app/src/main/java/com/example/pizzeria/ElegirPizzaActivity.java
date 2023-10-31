package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ElegirPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligir);
    }

    public void irNuestrasPizzas(View v){
        Intent nuestrasPizzas = new Intent(ElegirPizzaActivity.this, NuestrasPizzasActivity.class);
        startActivity(nuestrasPizzas);

    }
}
