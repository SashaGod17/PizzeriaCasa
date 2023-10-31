package com.example.pizzeria;

import java.util.ArrayList;

public class Pizza {

    private int imagen;
    private Tamaño tamaño;
    private ArrayList<Ingrediente> ingredientes;
    private String nombre;



    public Pizza(String nombre, Tamaño tamaño, int imagen, ArrayList<Ingrediente> ingredientes){
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.imagen = imagen;
        this.ingredientes = ingredientes;
    }

    public Pizza(String nombre, Tamaño tamaño){
        this.nombre = nombre;
        this.imagen = Integer.parseInt(null);
        this.tamaño = tamaño;
        this.ingredientes = new ArrayList<Ingrediente>();

    }

    public Pizza(String nombre, Tamaño tamaño, ArrayList<Ingrediente> ingredientes){
        this.nombre = nombre;
        this.imagen = Integer.parseInt(null);
        this.tamaño = tamaño;
        this.ingredientes = ingredientes;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Tamaño getTamaño() {
        return tamaño;
    }

    public void setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void anadirIngrediente(Ingrediente i){
        this.ingredientes.add(i);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
