package com.example.pizzeria;

import java.util.ArrayList;

public class DAOClientes {
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();

    private static DAOClientes dao =null;


    private DAOClientes() {
       this.lista.add(new Cliente("usuario1", "usuario1@gmail.com", "1234"));
        this.lista.add(new Cliente("usuario2", "usuario2@gmail.com", "1234"));
        this.lista.add(new Cliente("usuario3", "usuario3@gmail.com", "1234"));
        this.lista.add(new Cliente("usuario4", "usuario4@gmail.com", "1234"));
    }
    public static DAOClientes getInstance() {
        if (dao == null) {
            dao = new DAOClientes();
        }
        return dao;
    }
    public ArrayList<Cliente> getLista(){
        return this.lista;
    }

    public void anadirCliente(Cliente cliente){
        this.lista.add(cliente);
    }

    public Cliente buscarCliente(String nombre) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getNombre().equalsIgnoreCase(nombre)) return this.lista.get(i);
        }
        return null;
    }
}
