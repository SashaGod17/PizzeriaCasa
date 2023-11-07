package com.example.pizzeria;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String correo;
    private String constraseña;
    private ArrayList<Pizza> favoritas;

    private ArrayList<Pedido> historialPedidos;

    public Cliente(String nombre, String correo, String constraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.constraseña = constraseña;
        this.favoritas = new ArrayList<Pizza>();
    }
}
