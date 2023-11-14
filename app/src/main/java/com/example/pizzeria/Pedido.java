package com.example.pizzeria;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido implements Parcelable {
    private ArrayList<Pizza> listaPizzas;
    private double precioTotal;
    private LocalDate fechaPedido;
    @SuppressLint("NewApi")
    public Pedido(){
        this.fechaPedido = LocalDate.now();
        this.listaPizzas = new ArrayList<Pizza>();
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

    public void anadirPizza(Pizza p){
        this.listaPizzas.add(p);
    }

    public String imprimir(){
        String cadena = "";
        for (Pizza p : listaPizzas){
            cadena += p.toString();
            cadena += "\n";
        }
        return cadena;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.listaPizzas);
        dest.writeDouble(this.precioTotal);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dest.writeSerializable(this.fechaPedido);
        }
    }

    public void readFromParcel(Parcel source) {
        this.listaPizzas = source.createTypedArrayList(Pizza.CREATOR);
        this.precioTotal = source.readDouble();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.fechaPedido = (LocalDate) source.readSerializable();
        }
    }

    protected Pedido(Parcel in) {
        this.listaPizzas = in.createTypedArrayList(Pizza.CREATOR);
        this.precioTotal = in.readDouble();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.fechaPedido = (LocalDate) in.readSerializable();
        }
    }

    public static final Parcelable.Creator<Pedido> CREATOR = new Parcelable.Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel source) {
            return new Pedido(source);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };
}
