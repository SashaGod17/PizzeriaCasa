package com.example.pizzeria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ConfirmarActivity extends AppCompatActivity {
    Pizza pizza;
    Cliente cliente;
    double precioTotal = 0;

    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_layout);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        usuario = getIntent().getStringExtra("usuario");
        cliente = DAOClientes.getInstance().buscarCliente(usuario);
        TextView txtResumen = findViewById(R.id.txtResumen);
        TextView txtPrecio = findViewById(R.id.txtPrecio);
        ArrayList<Pizza> pizzas = cliente.getPedidoActual().getListaPizzas();
        for(Pizza p : pizzas){
            precioTotal += p.getPrecio();
        }
        cliente.getPedidoActual().setPrecioTotal(precioTotal);
        txtPrecio.setText("Precio total: " + precioTotal + "€");
        txtResumen.setText(cliente.getPedidoActual().imprimir());
    }

    public void confirmarPedido(View view) {
        cliente.anadirPedido(cliente.getPedidoActual());
        cliente.setPedidoActual(null);
        mostrarAlertDialog();
    }

    private void mostrarAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Pedido realizado correctamente")
                .setTitle("Pedido Confirmado")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ConfirmarActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });


        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
