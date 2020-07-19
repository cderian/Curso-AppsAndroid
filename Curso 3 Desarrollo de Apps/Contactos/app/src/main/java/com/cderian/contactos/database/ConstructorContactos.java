package com.cderian.contactos.database;

import android.content.ContentValues;
import android.content.Context;

import com.cderian.contactos.R;
import com.cderian.contactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos () {
        BaseDatos database = new BaseDatos(context);
        insertarDatos(database);
        return database.obtenerTodosContactos();
    }

    public void insertarDatos (BaseDatos database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_NOMBRE, "Pau Santillán");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_TELEFONO, "5577886655");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_EMAIL, "pausantillan@gmail.com");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_FOTO, R.drawable.ic_derecho);
        database.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_NOMBRE, "Mireya Martínez");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_TELEFONO, "5510101111");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_EMAIL, "mirem@gmail.com");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_FOTO, R.drawable.ic_libros);
        database.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_NOMBRE, "Mauro Estrada");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_TELEFONO, "5555107788");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_EMAIL, "mauroes@gmail.com");
        contentValues.put(ConstanteBDD.TABLA_CONTACTO_FOTO, R.drawable.ic_soccer);
        database.insertarContacto(contentValues);
    }
}
