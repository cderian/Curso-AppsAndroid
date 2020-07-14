package com.cderian.activatebluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int SOLICITUD_PERMISO = 1;
    private static final int SOLICITUD_HABILITAR_BLUETOOTH = 0;
    private Context context;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        activity = this;
    }

    public void habilitarBluetooth(View v) {
        solicitarPermiso();
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Tu dispositivo no tiene Bluetooth", Toast.LENGTH_SHORT).show();
        }else if (!bluetoothAdapter.isEnabled()) {
            Intent habilitarBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(habilitarBluetooth, SOLICITUD_HABILITAR_BLUETOOTH);
        }
    }

    public boolean checarStatusPermiso() {
        int status = ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH);

        if (status == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void solicitarPermiso() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH)) {
            Toast.makeText(MainActivity.this,
                    "El permiso ya fue otorgado, si deseas desactivarlo puedes ir a los ajustes de la app",
                    Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[] {Manifest.permission.BLUETOOTH},
                    SOLICITUD_PERMISO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case SOLICITUD_PERMISO:
                if (checarStatusPermiso()) {
                    Toast.makeText(this, "Ya esta activo el permiso para Bluetooth", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    Toast.makeText(this, "No esta activo el permiso para Bluetooth", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }
}