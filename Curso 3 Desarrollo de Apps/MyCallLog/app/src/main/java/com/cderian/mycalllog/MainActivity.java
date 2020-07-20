package com.cderian.mycalllog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_SOLICITUD = 1;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
    }

    public void mostrarLlamadas (View view) {
        if (checarStatusPermiso()) {
            consultarContentProviderLlamadas();
        } else {
            solicitarPermiso();
        }
    }

    public void solicitarPermiso () {
        boolean solicitarReadCallLog = ActivityCompat.shouldShowRequestPermissionRationale(
                activity, Manifest.permission.READ_CALL_LOG);
        boolean solicitarWriteCallLog = ActivityCompat.shouldShowRequestPermissionRationale(
                activity, Manifest.permission.WRITE_CALL_LOG);

        if (solicitarReadCallLog && solicitarWriteCallLog) {
            Toast.makeText(MainActivity.this, "Los permisos fueron ortogados", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(
                    activity,
                    new String[]
                    {Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG},
                    CODIGO_SOLICITUD);
        }
    }

    public boolean checarStatusPermiso () {
        boolean permisoReadCallLog = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED;

        boolean permisoWriteCallLog = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_CALL_LOG) == PackageManager.PERMISSION_GRANTED;

        return permisoReadCallLog && permisoWriteCallLog;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CODIGO_SOLICITUD:
                if (checarStatusPermiso()) {
                    Toast.makeText(MainActivity.this, "Ya están activos los permisos", Toast.LENGTH_SHORT).show();
                    consultarContentProviderLlamadas();
                } else {
                    Toast.makeText(MainActivity.this, "No se activaron los permisos", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public void consultarContentProviderLlamadas () {
        TextView tvLlamadas = findViewById(R.id.tvLlamadas);
        tvLlamadas.setText("");

        Uri direccionUriLlamadas = CallLog.Calls.CONTENT_URI;

        //Numero, fecha, tipo de llamada, duracion
        String[] campos = {
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.TYPE,
                CallLog.Calls.DURATION
        };

        ContentResolver contentResolver = getContentResolver();
        Cursor registros = contentResolver.query(direccionUriLlamadas, campos,
                null, null,
                CallLog.Calls.DATE + " DESC");

        while (registros.moveToNext()) {
            //Obtenemos los datos a partir del índice de la columna
            String numero   = registros.getString(registros.getColumnIndex(campos[0]));
            Long fecha      = registros.getLong(registros.getColumnIndex(campos[1]));
            int tipo        = registros.getInt(registros.getColumnIndex(campos[2]));
            String duracion = registros.getString(registros.getColumnIndex(campos[3]));

            String tipoLlamada = "";

            //Validación tipo de llamada
            switch (tipo) {
                case CallLog.Calls.INCOMING_TYPE:
                    tipoLlamada = getResources().getString(R.string.llamada_entrada);
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    tipoLlamada = getResources().getString(R.string.llamada_perdida);
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    tipoLlamada = getResources().getString(R.string.llamada_salida);
                    break;
                default:
                    tipoLlamada = getResources().getString(R.string.llamada_desconocida);
                    break;
            }

            String detalle = getResources().getString(R.string.etiqueta_numero) + " " + numero
                    + "\n" + getResources().getString(R.string.etiqueta_fecha) + " "
                    + DateFormat.format("dd/mm/yy k:mm", fecha)
                    + "\n" + getResources().getString(R.string.etiqueta_tipo) + " " + tipoLlamada
                    + "\n" + getResources().getString(R.string.etiqueta_duracion) + " " + duracion + "s."
                    + "\n\n";

            tvLlamadas.append(detalle);
        }

    }
}