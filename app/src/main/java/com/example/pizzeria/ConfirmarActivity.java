package com.example.pizzeria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmarActivity extends AppCompatActivity {
    Pizza pizza;
    Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_layout);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        pizza = (Pizza) getIntent().getParcelableExtra("Pizza");
        cliente = (Cliente) getIntent().getParcelableExtra("Cliente");
        TextView txtResumen = findViewById(R.id.txtResumen);
        txtResumen.setText(pizza.toString());
    }

    public void confirmarPedido(View view) {
        //cliente.getPedidoActual().anadirPizza(pizza);
        //cliente.anadirPedido(cliente.getPedidoActual());
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
