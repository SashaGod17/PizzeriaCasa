package com.example.pizzeria;

import android.os.Bundle;
import android.view.View;

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
        arrayPizzas = DAONuestrasPizzas.getInstance().getLista();
        for(Pizza p:arrayPizzas){
            System.out.println(p.toString());
        }



        RecyclerView rvNuestrasPizzas = (RecyclerView) findViewById(R.id.rvNuestrasPizzas);

        PizzaAdapter adapter = new PizzaAdapter(this.arrayPizzas);
        rvNuestrasPizzas.setAdapter(adapter);
        rvNuestrasPizzas.setLayoutManager(new LinearLayoutManager(this));
    }

}
