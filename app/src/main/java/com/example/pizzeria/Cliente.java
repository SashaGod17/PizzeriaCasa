package com.example.pizzeria;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cliente implements Parcelable {
    private String nombre;
    private String correo;
    private String constraseña;
    private ArrayList<Pizza> favoritas;

    private ArrayList<Pedido> historialPedidos;

    private Pedido pedidoActual;

    public Cliente(String nombre, String correo, String constraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.constraseña = constraseña;
        this.favoritas = new ArrayList<Pizza>();
        this.pedidoActual = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }

    public ArrayList<Pizza> getFavoritas() {
        return favoritas;
    }

    public void setFavoritas(ArrayList<Pizza> favoritas) {
        this.favoritas = favoritas;
    }

    public ArrayList<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void setHistorialPedidos(ArrayList<Pedido> historialPedidos) {
        this.historialPedidos = historialPedidos;
    }

    public void anadirFavorita(Pizza p){
        this.favoritas.add(p);
    }

    public void anadirPedido(Pedido p){
        this.historialPedidos.add(p);
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    public void setPedidoActual(Pedido pedidoActual) {
        this.pedidoActual = pedidoActual;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.correo);
        dest.writeString(this.constraseña);
        dest.writeTypedList(this.favoritas);
        dest.writeList(this.historialPedidos);
    }

    public void readFromParcel(Parcel source) {
        this.nombre = source.readString();
        this.correo = source.readString();
        this.constraseña = source.readString();
        this.favoritas = source.createTypedArrayList(Pizza.CREATOR);
        this.historialPedidos = new ArrayList<Pedido>();
        source.readList(this.historialPedidos, Pedido.class.getClassLoader());
    }

    protected Cliente(Parcel in) {
        this.nombre = in.readString();
        this.correo = in.readString();
        this.constraseña = in.readString();
        this.favoritas = in.createTypedArrayList(Pizza.CREATOR);
        this.historialPedidos = new ArrayList<Pedido>();
        in.readList(this.historialPedidos, Pedido.class.getClassLoader());
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel source) {
            return new Cliente(source);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };
}
