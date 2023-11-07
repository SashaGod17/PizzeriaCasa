package com.example.pizzeria;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EligirTamanoActivity extends AppCompatActivity {

    private Pizza pizza;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eligir_tamano_layout);

        pizza = (Pizza) getIntent().getParcelableExtra("Pizza");

        TextView txtView = findViewById(R.id.txtNombrePizza);
        ImageView imgPizza = (ImageView) findViewById(R.id.imgPizza);

        txtView.setText(pizza.getNombre());
        imgPizza.setImageResource(pizza.getImagen());


    }
}
