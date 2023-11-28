package com.example.pizzeria;

import java.util.ArrayList;

public class DAONuestrasPizzas {
    private ArrayList<Pizza> lista = new ArrayList<Pizza>();
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private static DAONuestrasPizzas dao =null;


    private DAONuestrasPizzas() {
        this.ingredientes.add(Ingrediente.Pollo);
        this.ingredientes.add(Ingrediente.Champiñones);
        this.ingredientes.add(Ingrediente.Tomate);
        this.lista.add(new Pizza("Pizza Barbacoa", this.ingredientes));
        this.lista.add(new Pizza("Pizza 4 Quesos", this.ingredientes, R.drawable.cuantro_queesos));
        this.lista.add(new Pizza("Pizza Margarita", this.ingredientes,R.drawable.margarita ));
        this.lista.add(new Pizza("Pizza Hawaiiana", this.ingredientes, R.drawable.hawaiiana));
    }
    public static DAONuestrasPizzas getInstance() {
        if (dao == null) {
            dao = new DAONuestrasPizzas();
        }
        return dao;
    }
    public ArrayList<Pizza> getLista(){
        return this.lista;
    }

}
