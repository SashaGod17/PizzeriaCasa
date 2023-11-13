
package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
    }

    public void IniciarSesion(View view){
        TextInputEditText inputUsuario = findViewById(R.id.inputUsuario);
        String usuario = inputUsuario.getText().toString();
        TextInputEditText inputContra = findViewById(R.id.inputContra);
        String contra = inputContra.getText().toString();

        ArrayList<Cliente> clientes = DAOClientes.getInstance().getLista();
        for(Cliente c : clientes){
            if (c.getNombre().equalsIgnoreCase(usuario) && c.getConstraseña().equals(contra)){
                cliente = c;
            }
        }
        if (cliente == null){
            mostrarAlertDialog();
            inputUsuario.setText(null);
            inputContra.setText(null);
        }
        else{
            Intent i = new Intent(MainActivity.this, PizzeriaJerezActivity.class);
            i.putExtra("Cliente", cliente);
            startActivity(i);
        }

    }

    private void mostrarAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Usuario o contraseña incorrecta!! \n Intentalo de Nuevo")
                .setTitle("Error")
                .setPositiveButton("OK", null);


        AlertDialog dialog = builder.create();
        dialog.show();
    }



}