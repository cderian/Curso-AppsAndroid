package com.cderian.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
         */
        listaContactos = findViewById(R.id.rvContactos);

        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(glm);

        inicializarContactos();
        inicializarAdaptador();

        /*ArrayList<String> nombresContactos = new ArrayList<String>();
        for (Contacto contacto : contactos) {
            nombresContactos.add(contacto.getNombre());
        }*/

        /*
        ListView lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
            }
        });*/
    }

    public void inicializarContactos () {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Pau Santillan", "5577886655", "pausantillan@gmail.com", R.drawable.derecho_icon));
        contactos.add(new Contacto("Ivan Martinez", "5523876321", "ivmtz@gmail.com", R.drawable.football_icon));
        contactos.add(new Contacto("César Delgado", "5534518655", "chelito@gmail.com", R.drawable.soccer_icon));
    }

    public void inicializarAdaptador () {
        ContactoAdapter adaptador = new ContactoAdapter(contactos, MainActivity.this);
        listaContactos.setAdapter(adaptador);
    }
}