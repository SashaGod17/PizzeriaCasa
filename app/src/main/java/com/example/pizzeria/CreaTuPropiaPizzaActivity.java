package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreaTuPropiaPizzaActivity extends AppCompatActivity {

    Ingrediente[] ingredientes = Ingrediente.values();

    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_tu_propia_pizza_layout);
        usuario = getIntent().getStringExtra("usuario");
        GridLayout gridLayout = findViewById(R.id.gridLayout);


        gridLayout.setColumnCount(2);


        for (Ingrediente ingrediente : ingredientes) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(View.generateViewId());
            radioButton.setText(ingrediente.toString());


            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            radioButton.setLayoutParams(params);
            gridLayout.addView(radioButton);
        }
    }

    public void CrearPizzaPersonalizada(View view){
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        ArrayList<Ingrediente> ingredientesSeleccionados = new ArrayList<Ingrediente>();

        for(int i = 0; i<gridLayout.getChildCount();i++){
            RadioButton boton = (RadioButton) gridLayout.getChildAt(i);
            if(boton.isChecked()){
                Ingrediente ingrediente = Ingrediente.valueOf(boton.getText().toString());
                ingredientesSeleccionados.add(ingrediente);
            }
        }

        Pizza p = new Pizza("Personalizada", ingredientesSeleccionados);

        Intent i = new Intent(CreaTuPropiaPizzaActivity.this, EligirTamanoActivity.class);
        i.putExtra("Pizza", p);
        i.putExtra("usuario", usuario);
        startActivity(i);

    }
}
