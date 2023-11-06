package com.example.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;

public class DAONuestrasPizzas {
    private ArrayList<Pizza> lista = new ArrayList<Pizza>();
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private static DAONuestrasPizzas dao =null;


    private DAONuestrasPizzas() {
        this.ingredientes.add(Ingrediente.POLLO);
        this.ingredientes.add(Ingrediente.CHAMPIÑONES);
        this.ingredientes.add(Ingrediente.TOMATE);
        this.lista.add(new Pizza("Pizza Barbacoa", this.ingredientes));
        this.lista.add(new Pizza("Pizza 4 Quesos", this.ingredientes));
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
