package com.cderian.contactos.vista.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cderian.contactos.R;
import com.cderian.contactos.adapter.ContactoAdapter;
import com.cderian.contactos.pojo.Contacto;
import com.cderian.contactos.presentador.IRecyclerViewFragmentPresenter;
import com.cderian.contactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;
    ArrayList<Contacto> contactos;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        listaContactos = v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdapter adaptador = new ContactoAdapter(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}