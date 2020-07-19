package com.cderian.contactos.database;

import android.content.ContentValues;
import android.content.Context;

import com.cderian.contactos.R;
import com.cderian.contactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos () {
        BaseDatos database = new BaseDatos(context);
        ArrayList<Contacto> contactos = database.obtenerTodosContactos();

        if (contactos.size() <= 0) {
            insertarDatosContacto(database);
            return database.obtenerTodosContactos();
        } else {
            return contactos;
        }
    }

    public void insertarDatosContacto (BaseDatos database) {
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

    public void darLike (Contacto contacto) {
        BaseDatos database = new BaseDatos(this.context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.TABLA_LIKES_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstanteBDD.TABLA_LIKES_NUMERO, LIKE);
        database.insertarLike(contentValues);
    }

    public int obtenerLikes (Contacto contacto) {
        BaseDatos database = new BaseDatos(this.context);
        return database.obtenerLikes(contacto);
    }
}
