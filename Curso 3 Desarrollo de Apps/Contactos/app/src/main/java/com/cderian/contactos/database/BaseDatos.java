package com.cderian.contactos.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cderian.contactos.pojo.Contacto;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBDD.DATABASE_NAME, null, ConstanteBDD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "CREATE TABLE " + ConstanteBDD.TABLA_CONTACTO + " ("
                + ConstanteBDD.TABLA_CONTACTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBDD.TABLA_CONTACTO_NOMBRE + " TEXT,  "
                + ConstanteBDD.TABLA_CONTACTO_TELEFONO + " TEXT, "
                + ConstanteBDD.TABLA_CONTACTO_EMAIL + " TEXT, "
                + ConstanteBDD.TABLA_CONTACTO_FOTO + " INTEGER" + ")";

        String queryTablaLikes = "CREATE TABLE " + ConstanteBDD.TABLA_LIKES + " ("
                + ConstanteBDD.TABLA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBDD.TABLA_LIKES_ID_CONTACTO + " INTEGER, "
                + ConstanteBDD.TABLA_LIKES_NUMERO + " INTEGER, "
                + "FOREIGN KEY (" + ConstanteBDD.TABLA_CONTACTO_ID +") "
                + "REFERENCES " + ConstanteBDD.TABLA_CONTACTO
                + "(" + ConstanteBDD.TABLA_CONTACTO_ID + ")"
                + ")";

        database.execSQL(query);
        database.execSQL(queryTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS " + ConstanteBDD.TABLA_CONTACTO);
        database.execSQL("DROP TABLE IF EXISTS " + ConstanteBDD.TABLA_LIKES);
        onCreate(database);
    }

    public ArrayList<Contacto> obtenerTodosContactos () {
        ArrayList<Contacto> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstanteBDD.TABLA_CONTACTO;
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor registros = database.rawQuery(query, null);

        while (registros.moveToNext()) {
            Contacto contacto = new Contacto();
            contacto.setId(registros.getInt(0));
            contacto.setNombre(registros.getString(1));
            contacto.setTelefono(registros.getString(2));
            contacto.setEmail(registros.getString(3));
            contacto.setFoto(registros.getInt(4));

            contactos.add(contacto);
        }

        database.close();

        return contactos;
    }

    public void insertarContacto (ContentValues contentValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(ConstanteBDD.TABLA_CONTACTO, null, contentValues);
        database.close();
    }
}
