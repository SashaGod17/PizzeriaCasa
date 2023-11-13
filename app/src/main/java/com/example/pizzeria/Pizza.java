package com.example.pizzeria;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Pizza implements Parcelable {

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

    public Pizza(String nombre, ArrayList<Ingrediente> ingredientes){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.tamaño = Tamaño.PEQUEÑA;
        this.imagen=R.drawable.pizza_default;
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

    public void calcualrPrecio(){
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
                precio += 9.50;
                break;
            case FAMILIAR:
                precio += 12;
                break;
        }
    }

    @Override
    public String toString() {
        return "Pizza " + nombre + "\nIngredientes=" + ingredientes +
                "\nTamaño=" + tamaño +
                "\nPrecio=" + precio
                ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imagen);
        dest.writeInt(this.tamaño == null ? -1 : this.tamaño.ordinal());
        dest.writeList(this.ingredientes);
        dest.writeString(this.nombre);
        dest.writeDouble(this.precio);
    }

    public void readFromParcel(Parcel source) {
        this.imagen = source.readInt();
        int tmpTamaño = source.readInt();
        this.tamaño = tmpTamaño == -1 ? null : Tamaño.values()[tmpTamaño];
        this.ingredientes = new ArrayList<Ingrediente>();
        source.readList(this.ingredientes, Ingrediente.class.getClassLoader());
        this.nombre = source.readString();
        this.precio = source.readDouble();
    }

    protected Pizza(Parcel in) {
        this.imagen = in.readInt();
        int tmpTamaño = in.readInt();
        this.tamaño = tmpTamaño == -1 ? null : Tamaño.values()[tmpTamaño];
        this.ingredientes = new ArrayList<Ingrediente>();
        in.readList(this.ingredientes, Ingrediente.class.getClassLoader());
        this.nombre = in.readString();
        this.precio = in.readDouble();
    }

    public static final Parcelable.Creator<Pizza> CREATOR = new Parcelable.Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel source) {
            return new Pizza(source);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };
}
