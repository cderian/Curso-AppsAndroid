package com.cderian.memoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generarArchivo(View v) {
        try {
            EditText editNombre = findViewById(R.id.editNombre);
            String nombre = editNombre.getText().toString();

            FileOutputStream outputStream = null;
            outputStream = openFileOutput("MiArchivo.txt", Context.MODE_APPEND);
            outputStream.write(nombre.getBytes());
            outputStream.close();

            Toast.makeText(MainActivity.this, "El archivo ha sido creado", Toast.LENGTH_SHORT).show();
            editNombre.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(MainActivity.this, "Hubo un error en la escritura del archivo", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(MainActivity.this, "Hubo un error durante en la ejecución de la app", Toast.LENGTH_SHORT).show();
        }
    }
}