
package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Cliente cliente;
    String usuario;
    String contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(ManejadorColores.getColor());
        AppManager.getInstance().addActivity(this);
    }

    public void IniciarSesion(View view){
        TextInputEditText inputUsuario = findViewById(R.id.inputUsuario);
        usuario = inputUsuario.getText().toString();
        TextInputEditText inputContra = findViewById(R.id.inputContra);
        contra = inputContra.getText().toString();

        ArrayList<Cliente> clientes = DAOClientes.getInstance().getLista();
        for(Cliente c : clientes){
            if (c.getNombre().equalsIgnoreCase(usuario) && c.getConstraseña().equals(contra)){
                cliente = DAOClientes.getInstance().buscarCliente(usuario);
                mostrarSesionIniciada();

            }
        }
        if(usuario.isEmpty()&&contra.isEmpty()){
            mostrarAlertDialogFaltaTodo();
        }
        else if(usuario.isEmpty()){
            mostrarAlertDialogFaltaUsuario();
            inputUsuario.setText(null);
            inputContra.setText(null);
        }
        else if(contra.isEmpty()){
            mostrarAlertDialogFaltaContra();
            inputUsuario.setText(null);
            inputContra.setText(null);
        }
        else if (cliente == null){
            mostrarAlertDialog();
            inputUsuario.setText(null);
            inputContra.setText(null);
        }
        else if (!cliente.getNombre().equalsIgnoreCase(usuario) || !cliente.getConstraseña().equalsIgnoreCase(contra)){
        mostrarAlertDialog();
        }

    }

    private void mostrarAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Usuario o Contraseña incorrecto!!")
                .setTitle("Error")
                .setPositiveButton("OK", null);


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void mostrarAlertDialogFaltaUsuario() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("El campo de USUARIO está vacio")
                .setTitle("Error")
                .setPositiveButton("OK", null);


        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void mostrarAlertDialogFaltaContra() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("El campo de CONTRASEÑA está vacio")
                .setTitle("Error")
                .setPositiveButton("OK", null);


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void mostrarAlertDialogFaltaTodo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("El campo de USUARIO y CONTRASEÑA están vacios")
                .setTitle("Error")
                .setPositiveButton("OK", null);


        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void mostrarSesionIniciada() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sesion Iniciada")
                .setTitle("OK")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, PizzeriaJerezActivity.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);

                    }
                });


        AlertDialog dialog = builder.create();
        dialog.show();
    }

}