package com.cderian.contactos.vista.fragment;

import com.cderian.contactos.adapter.ContactoAdapter;
import com.cderian.contactos.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical ();

    public ContactoAdapter crearAdaptador (ArrayList<Contacto> contactos);

    public void inicializarAdaptador (ContactoAdapter adaptador);
}
