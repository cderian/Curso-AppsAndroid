package com.cderian.miscontactos.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cderian.miscontactos.MainActivity;
import com.cderian.miscontactos.R;
import com.cderian.miscontactos.adapter.ContactoAdapter;
import com.cderian.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView listaContactos;
    ArrayList<Contacto> contactos;

    @Nullable
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
        contactos.add(new Contacto("Pau Santillan", "5577886655", "pausantillan@gmail.com", R.drawable.derecho_icon));
        contactos.add(new Contacto("Ivan Martinez", "5523876321", "ivmtz@gmail.com", R.drawable.football_icon));
        contactos.add(new Contacto("César Delgado", "5534518655", "chelito@gmail.com", R.drawable.soccer_icon));
    }

    public void inicializarAdaptador () {
        ContactoAdapter adaptador = new ContactoAdapter(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }
}
