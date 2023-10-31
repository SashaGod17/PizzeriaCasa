package com.example.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;

public class DAONuestrasPizzas {
    private ArrayList<Pizza> lista;

    private static DAONuestrasPizzas dao;;


    private DAONuestrasPizzas() {
        this.lista.add(new Pizza("Pizza Barbacoa", new ArrayList<Ingrediente>(Arrays.asList(Ingrediente.POLLO, Ingrediente.TERNERA, Ingrediente.SALSA_BARBACOA))));
        this.lista.add(new Pizza("Pizza 4 Quesos", new ArrayList<Ingrediente>(Arrays.asList(Ingrediente.MOZARELLA, Ingrediente.QUESOS_VARIADOS, Ingrediente.TOMATE))));
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
