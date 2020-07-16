package com.cderian.memoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardarPreferencia (View v) {
        SharedPreferences preferences =
                getSharedPreferences(getResources().getString(R.string.id_preferences), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        EditText editNombre = findViewById(R.id.editNombre);
        EditText editCorreo = findViewById(R.id.editCorreo);

        String nombre = editNombre.getText().toString();
        String correo = editCorreo.getText().toString();

        editor.putString(getResources().getString(R.string.nombre_preferences), nombre);
        editor.putString(getResources().getString(R.string.correo_preferences), correo);

        editor.commit();

        Toast.makeText(MainActivity.this, "Se ha creado la preferencia compartida",
                Toast.LENGTH_SHORT).show();

        editNombre.setText("");
        editCorreo.setText("");
    }

    public void mostrarPreferencia (View v) {
        SharedPreferences preferences =
                getSharedPreferences(getResources().getString(R.string.id_preferences), Context.MODE_PRIVATE);

        String nombre = preferences.getString(getResources().getString(R.string.nombre_preferences), "No existe esa variable");
        String correo = preferences.getString(getResources().getString(R.string.correo_preferences), "No existe esa variable");

        TextView textView = findViewById(R.id.textPreferenciaCompartida);
        String preferencia = "\n" + "Nombre: " + nombre + "\n" + "Correo: " + correo;
        textView.setText(preferencia);
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