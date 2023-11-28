package com.example.pizzeria;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DAONuestrasPizzas {
    private ArrayList<Pizza> lista = new ArrayList<Pizza>();
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private static DAONuestrasPizzas dao =null;

    private bdControlador bdControlador;


    private DAONuestrasPizzas(Context context) {
        this.bdControlador = new bdControlador(context);
        this.ingredientes.add(Ingrediente.Pollo);
        this.ingredientes.add(Ingrediente.Champiñones);
        this.ingredientes.add(Ingrediente.Tomate);
        this.lista.add(new Pizza("Pizza Barbacoa", this.ingredientes));
        this.lista.add(new Pizza("Pizza 4 Quesos", this.ingredientes, R.drawable.cuantro_queesos));
        this.lista.add(new Pizza("Pizza Margarita", this.ingredientes,R.drawable.margarita ));
        this.lista.add(new Pizza("Pizza Hawaiiana", this.ingredientes, R.drawable.hawaiiana));
    }
    public static DAONuestrasPizzas getInstance(Context context) {
        if (dao == null) {
            dao = new DAONuestrasPizzas( context);
        }
        return dao;
    }
    public ArrayList<Pizza> getLista(){

        Cursor cursor = this.bdControlador.obtenerPizzas();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                @SuppressLint("Range")
                int imagenResource = cursor.getInt(cursor.getColumnIndex("imagenResource"));

                ArrayList<Ingrediente> ingredientes = getIngredientesDePizza(nombre);
                this.lista.add(new Pizza(nombre, ingredientes, imagenResource));
            } while (cursor.moveToNext());

            cursor.close();
        }

        return this.lista;
    }

}
