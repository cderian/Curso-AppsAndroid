package com.cderian.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;
    TextInputLayout inTxtNombre, inTxtTelefono, inTxtEmail, inTxtDescripcion;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializando los InputText
        inTxtNombre = findViewById(R.id.inTxtNombre);
        inTxtTelefono = findViewById(R.id.inTxtTelefono);
        inTxtEmail = findViewById(R.id.inTxtEmail);
        inTxtDescripcion = findViewById(R.id.inTxtDescripcion);

        //Inicializando DatePicker
        datePicker = findViewById(R.id.datePicker);

        //Inicializando el botón de Siguiente
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Datos de ingreso de datos
                String input_nombre, input_fecha, input_telefono, input_email, input_descripcion;

                //Capturando datos ingresados por el usuario
                input_nombre = inTxtNombre.getEditText().getText().toString();
                input_fecha = String.valueOf(datePicker.getDayOfMonth()) + "/" +
                        String.valueOf(datePicker.getMonth()) + "/" +
                        String.valueOf(datePicker.getYear());
                input_telefono = inTxtTelefono.getEditText().getText().toString();
                input_email = inTxtEmail.getEditText().getText().toString();
                input_descripcion = inTxtDescripcion.getEditText().getText().toString();

                //Validando Datos
                if (input_nombre.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, getResources().getString(R.string.nombre_nulo), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    inTxtNombre.setBoxStrokeColor(Color.RED);
                } else if (input_telefono.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, getResources().getString(R.string.telefono_nulo), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    inTxtTelefono.setBoxStrokeColor(Color.RED);
                } else if (input_telefono.length() > 10 || input_telefono.length() < 10) {
                    Snackbar snackbar = Snackbar.make(v, getResources().getString(R.string.telefono_invalido), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    inTxtTelefono.setBoxStrokeColor(Color.RED);
                } else if (!validarEmail(input_email)) {
                    Snackbar snackbar = Snackbar.make(v, getResources().getString(R.string.email_invalido), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    inTxtEmail.setBoxStrokeColor(Color.RED);
                } else {
                    //Enviando datos del usuario
                    Intent intent = new Intent(MainActivity.this, EnvioDatos.class);
                    intent.putExtra(getResources().getString(R.string.pnombre), input_nombre);
                    intent.putExtra(getResources().getString(R.string.pfechanac), input_fecha);
                    intent.putExtra(getResources().getString(R.string.ptelefono), input_telefono);
                    intent.putExtra(getResources().getString(R.string.pemail), input_email);
                    intent.putExtra(getResources().getString(R.string.pdesc), input_descripcion);
                    startActivity(intent);
                }
            }
        });
    }

    public final static boolean validarEmail(CharSequence email) {
        if (email == null) {
            return false;
        }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}