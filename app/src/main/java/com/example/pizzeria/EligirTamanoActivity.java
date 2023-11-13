package com.example.pizzeria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EligirTamanoActivity extends AppCompatActivity {

    private Pizza pizza;
    private Cliente cliente;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eligir_tamano_layout);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        pizza = (Pizza) getIntent().getParcelableExtra("Pizza");
        cliente = (Cliente) getIntent().getParcelableExtra("Cliente");

        TextView txtView = findViewById(R.id.txtNombrePizza);
        ImageView imgPizza = (ImageView) findViewById(R.id.imgPizza);

        txtView.setText(pizza.getNombre());
        imgPizza.setImageResource(pizza.getImagen());


    }

    public  void activarBoton(View view){
        Button botonConfirmar = (Button) findViewById(R.id.btnConfirmarTamano);
        botonConfirmar.setEnabled(true);

    }

    public void confirmarTamano(View view){

        if (findViewById(R.id.rbuttonPizzaPequeña).isSelected()){
            pizza.setTamaño(Tamaño.PEQUEÑA);
            pizza.setPrecio(4.50);
        }
        else if (findViewById(R.id.rbuttonPizzaMediana).isSelected()){
            pizza.setTamaño(Tamaño.MEDIANA);
            pizza.setPrecio(6.50);
        }
        else if (findViewById(R.id.rbuttonGrande).isSelected()){
            pizza.setTamaño(Tamaño.GRANDE);
            pizza.setPrecio(9.50);
        }
        else if (findViewById(R.id.rbuttonFamiliar).isSelected()){
            pizza.setTamaño(Tamaño.FAMILIAR);
            pizza.setPrecio(12);
        }



        if (cliente.getPedidoActual() == null){
            Pedido p = new Pedido();
            p.anadirPizza(pizza);
            cliente.setPedidoActual(p);
        }
        else {
            Pedido pedidoActual = cliente.getPedidoActual();
            pedidoActual.anadirPizza(pizza);
        }

        Intent intent = new Intent(EligirTamanoActivity.this, ConfirmarActivity.class);
        intent.putExtra("Pizza", pizza);
        startActivity(intent);




    }

  /*  private void mostrarAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(cliente.getPedidoActual().imprimir())
                .setTitle("Tamaño confirmado")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(EligirTamanoActivity.this, PizzeriaJerezActivity.class);
                        intent.putExtra("Cliente", cliente);
                        startActivity(intent);
                    }
                });


        AlertDialog dialog = builder.create();
        dialog.show();
    } */

}
