package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NuestrasPizzasActivity extends AppCompatActivity {

    ArrayList<Pizza> arrayPizzas = new ArrayList<Pizza>();
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuestras_pizzas);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        cliente = (Cliente) getIntent().getParcelableExtra("Cliente");
        arrayPizzas = DAONuestrasPizzas.getInstance().getLista();
        for(Pizza p:arrayPizzas){
            System.out.println(p.toString());
        }



        RecyclerView rvNuestrasPizzas = (RecyclerView) findViewById(R.id.rvNuestrasPizzas);

        PizzaAdapter adapter = new PizzaAdapter(this.arrayPizzas);
        rvNuestrasPizzas.setAdapter(adapter);
        rvNuestrasPizzas.setLayoutManager(new LinearLayoutManager(this));
    }

    public void eligirTamano(View view){
        Pizza pizza;
        if (view.getTag() instanceof  Pizza){
            pizza = (Pizza) view.getTag();
            Intent i = new Intent(NuestrasPizzasActivity.this, EligirTamanoActivity.class);
            i.putExtra("Pizza", pizza);
            i.putExtra("Cliente", cliente);
            startActivity(i);
        }
    }



}
