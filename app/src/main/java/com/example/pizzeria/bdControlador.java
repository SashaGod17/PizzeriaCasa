package com.example.pizzeria;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class bdControlador {

    private bd dbHelper;
    private SQLiteDatabase db;

    public bdControlador(Context context) {
        dbHelper = new bd(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Cursor obtenerPizzas() {
        return db.query("pizza", null, null, null, null, null, null);
    }

    public long addPizza(String nombre, double precio, String ingredientes, String tamaño) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("precio", precio);
        values.put("ingredientes", ingredientes);
        values.put("tamaño", tamaño);

        return db.insert("pizza", null, values);
    }
}
