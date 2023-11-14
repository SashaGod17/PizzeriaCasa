package com.example.pizzeria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EligirTamanoActivity extends AppCompatActivity {

    public Pizza pizza;
    public Cliente cliente;

    String usuario;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eligir_tamano_layout);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
        this.pizza = (Pizza) getIntent().getParcelableExtra("Pizza");
        usuario = getIntent().getStringExtra("usuario");
        cliente = DAOClientes.getInstance().buscarCliente(usuario);

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
        RadioButton peque = (RadioButton) findViewById(R.id.rbuttonPizzaPequeña);
        RadioButton mediana = (RadioButton) findViewById(R.id.rbuttonPizzaMediana);
        RadioButton grande = (RadioButton) findViewById(R.id.rbuttonGrande);
        RadioButton familiar = (RadioButton) findViewById(R.id.rbuttonFamiliar);

        if ( peque.isChecked()){
            this.pizza.setTamaño(Tamaño.PEQUEÑA);
        }
        else if (mediana.isChecked()){
            this.pizza.setTamaño(Tamaño.MEDIANA);

        }
        else if (grande.isChecked()){
            this.pizza.setTamaño(Tamaño.GRANDE);

        }
        else if (familiar.isChecked()){
            this.pizza.setTamaño(Tamaño.FAMILIAR);

        }

        pizza.calcualrPrecio();

        if (cliente.getPedidoActual() == null){
            Pedido p = new Pedido();
            p.anadirPizza(pizza);
            cliente.setPedidoActual(p);
        }
        else {
            Pedido pedidoActual = cliente.getPedidoActual();
            pedidoActual.anadirPizza(pizza);
        }

        mostrarAlertDialog();


    }

    private void mostrarAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Has seleccionado " + this.pizza.getTamaño())
                .setTitle("Tamaño confirmado")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(EligirTamanoActivity.this, PizzeriaJerezActivity.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);
                    }
                });


        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
