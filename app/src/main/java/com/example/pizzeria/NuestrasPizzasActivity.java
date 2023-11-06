package com.example.pizzeria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NuestrasPizzasActivity extends AppCompatActivity {

    ArrayList<Pizza> arrayPizzas = new ArrayList<Pizza>();

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

        this.arrayPizzas.add(new Pizza("4 Quesos", ingredientes));
        this.arrayPizzas.add(new Pizza("Barbacoa", ingredientes));
        this.arrayPizzas.add(new Pizza("BBQ", ingredientes));
        PizzaAdapter adapter = new PizzaAdapter(this.arrayPizzas);
        rvNuestrasPizzas.setAdapter(adapter);
        rvNuestrasPizzas.setLayoutManager(new LinearLayoutManager(this));
    }

}
