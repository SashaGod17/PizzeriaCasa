package com.example.pizzeria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NuestrasPizzasActivity extends AppCompatActivity {

    ArrayList<Pizza> arrayPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuestras_pizzas);

        RecyclerView rvNuestrasPizzas = (RecyclerView) findViewById(R.id.rvNuestrasPizzas);

        //arrayPizzas = DAONuestrasPizzas.getInstance().getLista();
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(Ingrediente.TOMATE);
        ingredientes.add(Ingrediente.ATUN);
        ingredientes.add(Ingrediente.CHAMPIÑONES);

        arrayPizzas.add(new Pizza("Barbacoa", ingredientes));
        PizzaAdapter adapter = new PizzaAdapter(arrayPizzas);
        rvNuestrasPizzas.setAdapter(adapter);
        rvNuestrasPizzas.setLayoutManager(new LinearLayoutManager(this));
    }

}
