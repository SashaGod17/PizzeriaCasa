package com.example.pizzeria;

import android.annotation.SuppressLint;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Pizza> listaPizzas;
    private double precioTotal;
    private LocalDate fechaPedido;
    @SuppressLint("NewApi")
    public Pedido(){
        this.fechaPedido = LocalDate.now();
    }

    public ArrayList<Pizza> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(ArrayList<Pizza> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

}
