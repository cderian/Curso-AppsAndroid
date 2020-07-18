package com.cderian.contactos.database;

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
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Pau Santillan", "5577886655", "pausantillan@gmail.com", R.drawable.ic_derecho, 0));
        contactos.add(new Contacto("Ivan Martinez", "5523876321", "ivmtz@gmail.com", R.drawable.ic_quimica, 0));
        contactos.add(new Contacto("César Delgado", "5534518655", "chelito@gmail.com", R.drawable.ic_soccer, 0));
        return contactos;
    }
}
