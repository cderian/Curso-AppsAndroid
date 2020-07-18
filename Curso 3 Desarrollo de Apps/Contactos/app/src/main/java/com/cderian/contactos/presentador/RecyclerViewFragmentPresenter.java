package com.cderian.contactos.presentador;

import android.content.Context;

import com.cderian.contactos.database.ConstructorContactos;
import com.cderian.contactos.pojo.Contacto;
import com.cderian.contactos.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;

    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(
            IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBDD();
    }

    @Override
    public void obtenerContactosBDD() {
        constructorContactos = new ConstructorContactos(this.context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptador(
                iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
