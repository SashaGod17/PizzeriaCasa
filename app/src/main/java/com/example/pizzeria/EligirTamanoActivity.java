package com.example.pizzeria;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EligirTamanoActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eligir_tamano_layout);

        if (getIntent() != null && getIntent().hasExtra("TituloPizza") && getIntent().hasExtra("ImagenPizza")){
            String tituloPizza = getIntent().getStringExtra("TituloPizza");
            int img = getIntent().getIntExtra("ImagenPizza", R.id.imgPizza);

            TextView txtView = findViewById(R.id.txtNombrePizza);
            ImageView imgPizza = findViewById(R.id.imgPizza);

            txtView.setText(tituloPizza);
            imgPizza.setImageResource(img);

        }
    }
}
