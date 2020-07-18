package com.cderian.contactos.fragment;

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

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView listaContactos;
    ArrayList<Contacto> contactos;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaContactos = v.findViewById(R.id.rvContactos);
        LinearLayoutManager glm = new LinearLayoutManager(getActivity());
        listaContactos.setLayoutManager(glm);
        inicializarContactos();
        inicializarAdaptador();

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void inicializarContactos () {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Pau Santillan", "5577886655", "pausantillan@gmail.com", R.drawable.ic_derecho, 0));
        contactos.add(new Contacto("Ivan Martinez", "5523876321", "ivmtz@gmail.com", R.drawable.ic_quimica, 0));
        contactos.add(new Contacto("César Delgado", "5534518655", "chelito@gmail.com", R.drawable.ic_soccer, 0));
    }

    public void inicializarAdaptador () {
        ContactoAdapter adaptador = new ContactoAdapter(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }
}