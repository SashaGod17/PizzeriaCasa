package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PizzeriaJerezActivity extends AppCompatActivity {

    Cliente cliente;
    Pedido pedidoActual;

    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzeria_jerez_layout);
        usuario = getIntent().getStringExtra("usuario");
        cliente = DAOClientes.getInstance().buscarCliente(usuario);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        Button btnElegir =(Button) findViewById(R.id.btnEligirPizza);
        Button btnCarrito = (Button) findViewById(R.id.btnCarrito);
        if(cliente.getPedidoActual()!=null) btnCarrito.setEnabled(true);
        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PizzeriaJerezActivity.this, ElegirPizzaActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);

            }
        });
        Button btnSalir = (Button) findViewById(R.id.btnSalir);
      /*  btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });*/
        Button btnConfigurar = (Button) findViewById(R.id.btnConfigurar);
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PizzeriaJerezActivity.this, ConfigurarActivity.class);
                startActivity(intent);

            }
        });


    }
    public void irAlCarrito(View view){
        Intent intent = new Intent(PizzeriaJerezActivity.this, ConfirmarActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);

    }

    //@Override
   // public void onBackPressed(){

    //}
}
