package com.example.pizzeria;

import java.util.ArrayList;

public class Pizza {

    private int imagen;
    private Tamaño tamaño;
    private ArrayList<Ingrediente> ingredientes;
    private String nombre;

    private double precio = 0;

    public Pizza(String nombre, Tamaño tamaño, int imagen, ArrayList<Ingrediente> ingredientes){
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.imagen = imagen;
        this.ingredientes = ingredientes;
        calcualrPrecioInicial();
    }

    public Pizza(String nombre, Tamaño tamaño){
        this.nombre = nombre;
        this.imagen = Integer.parseInt(null);
        this.tamaño = tamaño;
        this.ingredientes = new ArrayList<Ingrediente>();
        calcualrPrecioInicial();
    }

    public Pizza(String nombre, Tamaño tamaño, ArrayList<Ingrediente> ingredientes){
        this.nombre = nombre;
        this.imagen = Integer.parseInt(null);
        this.tamaño = tamaño;
        this.ingredientes = ingredientes;
        calcualrPrecioInicial();
    }

    public Pizza(String nombre, ArrayList<Ingrediente> ingredientes){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.tamaño = Tamaño.PEQUEÑA;
        calcualrPrecioInicial();
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

    public void  setPrecio(double precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    private void calcualrPrecioInicial(){
        if (this.ingredientes.size()>5){
            for (int i = 0; i<(ingredientes.size()-5);i++){
                precio = precio + 0.5;
            }
        }
        switch (this.tamaño){
            case PEQUEÑA:
                precio += 4.5;
                break;
            case MEDIANA:
                precio += 6.5;
                break;
            case GRANDE:
                precio += 9;
                break;
            case FAMILIAR:
                precio += 12;
                break;
        }
    }
}
