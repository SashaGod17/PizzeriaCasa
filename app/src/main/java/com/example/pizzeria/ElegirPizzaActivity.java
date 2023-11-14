package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ElegirPizzaActivity extends AppCompatActivity {

    public Cliente cliente;

    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligir);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        usuario = getIntent().getStringExtra("usuario");
        cliente = DAOClientes.getInstance().buscarCliente(usuario);
        Button boton = (Button) findViewById(R.id.btnNuestrasPizzas);
        Button btnRepetir = (Button) findViewById(R.id.btnRepetirUltimoPedido);
        if(!cliente.getHistorialPedidos().isEmpty()) btnRepetir.setEnabled(true);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nuestrasPizzas = new Intent(ElegirPizzaActivity.this, NuestrasPizzasActivity.class);
                nuestrasPizzas.putExtra("usuario", usuario);
                startActivity(nuestrasPizzas);
            }
        });


    }

    public  void crearPizza(View view){
        Intent i = new Intent(ElegirPizzaActivity.this, CreaTuPropiaPizzaActivity.class);
        i.putExtra("usuario", usuario);
        startActivity(i);

    }

    public void RepetirUltimo(View view){
        Pedido p = cliente.getHistorialPedidos().get(cliente.getHistorialPedidos().size()-1);

        cliente.setPedidoActual(p);
        Intent i = new Intent(ElegirPizzaActivity.this, ConfirmarActivity.class);
        i.putExtra("usuario", usuario);
        startActivity(i);
    }

   /* public void irNuestrasPizzas(View v){
        System.out.println("Intento iniciado");
        Intent nuestrasPizzas = new Intent(ElegirPizzaActivity.this, NuestrasPizzasActivity.class);
        startActivity(nuestrasPizzas);

    } */
}
