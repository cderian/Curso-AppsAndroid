package com.cderian.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar;
    private Button avanzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);

        listaMascotas = findViewById(R.id.allPetsView);

        GridLayoutManager glm = new GridLayoutManager(this, 1);
        listaMascotas.setLayoutManager(glm);

        inicializarMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_favs:
                openFavPets();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openFavPets () {
        Intent intent= new Intent(MainActivity.this, RatedPatesActivity.class);
        startActivity(intent);
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1, "Toby", R.drawable.perro1));
        mascotas.add(new Mascota(2, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(3, "Max", R.drawable.perro3));
        mascotas.add(new Mascota(4, "Bones", R.drawable.perro4));
        mascotas.add(new Mascota(5, "Zeus", R.drawable.perro5));
        mascotas.add(new Mascota(6, "Besheen", R.drawable.perro6));
        mascotas.add(new Mascota(7, "Negro", R.drawable.perro7));
        mascotas.add(new Mascota(8, "Golfo", R.drawable.perro8));
        mascotas.add(new Mascota(9, "Rawi", R.drawable.perro9));
    }

    public void inicializarAdaptador() {
        PetAdapter petAdapter = new PetAdapter(mascotas, MainActivity.this);
        listaMascotas.setAdapter(petAdapter);
    }
}