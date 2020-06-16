package com.cderian.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Pau Santillan", "5577886655", "pausantillan@gmail.com"));
        contactos.add(new Contacto("Ivonne Jimenez", "5523876321", "ivonny@gmail.com"));
        contactos.add(new Contacto("Mireya Martinez", "5533411053", "mirmtz@gmail.com"));
        contactos.add(new Contacto("Daniel Delfin", "5510124789", "ddelfin@gmail.com"));
        contactos.add(new Contacto("Zaira Hernandez", "5534518655", "zaihdz@gmail.com"));

        ArrayList<String> nombresContactos = new ArrayList<String>();
        for (Contacto contacto : contactos) {
            nombresContactos.add(contacto.getNombre());
        }

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
        });
    }
}