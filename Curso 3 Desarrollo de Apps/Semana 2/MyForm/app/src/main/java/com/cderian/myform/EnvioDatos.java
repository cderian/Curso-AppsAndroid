package com.cderian.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EnvioDatos extends AppCompatActivity {

    TextView txtNombre, txtNacimiento, txtTelefono, txtEmail, txtDesc;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_datos);

        //Inicializando TextView
        txtNombre = findViewById(R.id.txtNombre);
        txtNacimiento = findViewById(R.id.txtNacimiento);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtDesc = findViewById(R.id.txtDesc);

        //Obteniendo datos ingresados por el usuario
        String nombre = getIntent().getStringExtra(getResources().getString(R.string.pnombre));
        String fecha = getIntent().getStringExtra(getResources().getString(R.string.pfechanac));
        String telefono = getIntent().getStringExtra(getResources().getString(R.string.ptelefono));
        String email = getIntent().getStringExtra(getResources().getString(R.string.pemail));
        String descripcion = getIntent().getStringExtra(getResources().getString(R.string.pdesc));

        //Mostrando los datos ingresados por el usuario
        txtNombre.setText(nombre);
        txtNacimiento.setText(fecha);
        txtTelefono.setText(telefono);
        txtEmail.setText(email);
        txtDesc.setText("Descripción: " + descripcion);

        //Inicializando botón de editar
        btnEditar = findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}