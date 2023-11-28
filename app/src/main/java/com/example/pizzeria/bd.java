package com.example.pizzeria;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bd extends SQLiteOpenHelper{

    private static final String nombre = "pizzeria";
    private static final int version = 1;

    private static final String CrearTablaCliente =
            "CREATE TABLE Cliente (" +
                    "    id_cliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "    nombre TEXT NOT NULL," +
                    "    correo TEXT NOT NULL," +
                    "    contraseña TEXT NOT NULL," +
                    "    id_pedido_actual INTEGER ," +
                    "    FOREIGN KEY (id_pedido_actual) REFERENCES Pedido(id_pedido)"+
                    "    );";


    private static final String CrearTablaPizza =
            "CREATE TABLE Pizza (" +
                    "id_pizza INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT NOT NULL," +
                    "precio DECIMAL(4,2)  ," +
                    "ingredientes TEXT NOT NULL  ," +
                    "tamaño VARCHAR(50) ," +
                    "imagen BLOB" +
                    ");";

    private static final String CrearTablaFavoritas =
            "CREATE TABLE Pizzas_Favoritas (" +
                    "id_pizza_favorita INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "id_pizza INTEGER," +
                    "id_cliente INTEGER," +
                    "FOREIGN KEY (id_pizza) REFERENCES Pizza (id_pizza)," +
                    "FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente)" +
                    ");";

    private static final String CrearTablaPedido =
            "CREATE TABLE Pedido (" +
                    "id_pedido INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "precio_final DOUBLE(4,2)," +
                    "id_cliente INTEGER NOT NULL," +
                    "fecha_pedido DATE NOT NULL, " +
                    "FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente)" +
                    ");";


    private static final String CrearTablaPedidoPizza =
            "CREATE TABLE Pedido_Pizza (" +
                    "id_pedido_pizza INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "id_pizza INTEGER," +
                    "id_pedido INTEGER," +
                    "FOREIGN KEY (id_pizza) REFERENCES Pizza (id_pizza)," +
                    "FOREIGN KEY (id_pedido) REFERENCES Pedido (id_pedido)" +
                    ");";


    public bd(Context context) {
        super(context, nombre, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CrearTablaPizza);
        db.execSQL(CrearTablaPedido);
        db.execSQL(CrearTablaCliente);
        db.execSQL(CrearTablaFavoritas);
        db.execSQL(CrearTablaPedidoPizza);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
