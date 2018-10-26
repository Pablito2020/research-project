package com.ordinador.pablo.accesdirecte;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View; // Classe necessària per a els elements d'interfície d'usuari

import android.content.Intent; // Classe necessària per a executar tasques
import android.content.Context; // Classe necessària per a saber el contexte de la app

import android.net.Uri; // Classe necessària per obrir la galeria
import android.content.SharedPreferences; // Classe necessària per a guardar els paràmetres del canvi de color,

import android.view.Menu; // Classe necessària per a dir que hi ha un menú
import android.view.MenuInflater; // Classe necessària per a dir quin es l'arxiu xml del menú.
import android.view.MenuItem; // Classe necessària per a programar la funció dels diferents ítems del xml menú

import android.widget.Button; // Classe necessària per als botons
import android.widget.ToggleButton; // Classe Necessària per a controlar els botons tipus toggle
import android.widget.CompoundButton; // Classe necessària per a controlar un botó amb dos estats (encés o no encés) com per exemple el Toggle Button

import android.net.wifi.WifiManager; // Classe necessària per a controlar el wifi de el SmartPhone
import android.net.ConnectivityManager; // Classe que respon a consultes sobre l'estat de la connectivitat de xarxa
import android.net.NetworkInfo; // Classe que describeix l'estat de una interfície de xarxa
import android.net.Network; // Classe necessària per al control de la xarxa

import android.provider.MediaStore; // Classe necessària per a executar la app de càmera.

import android.widget.Toast; // Classe necessària per a executar missatges tipus Toast.

import android.provider.Settings; // Classe necessària per a redireccionar a la aplicació configuració.
import android.os.Build; // Classe necessària per a mirar la API del dispositiu



public class Activitat_Principal extends AppCompatActivity {

    // Métode per obrir la Activity Informació de la app
    public void info(){
        Intent i = new Intent(this, info.class);
        startActivity(i);
    }

    // Métode per obrir la Activity Opcions de la app
    public void conf(){
        Intent conf = new Intent(this,configuracio.class);
        startActivity(conf);
    }

    // Métode per a fer check de la API de Android Actual ( necessari per a móbils que no tenen la API 28 (Android P))
    public void api(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Intent i = new Intent(Settings.ACTION_DATA_USAGE_SETTINGS);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Your Android Version doesn't support that feature",Toast.LENGTH_LONG).show();
        }
    }

    // Flashlight
    private String mCameraId;

    // Métode per a mostrar el menú
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Métode per a programar el Menú
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.config:
                conf();
                return true;
            case R.id.info:
                info();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Métode per a executar la cámara
    public void camera(){
       Intent i = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
            this.startActivity(i);
    }

    // Métode per a executar la galería
    public void galeria(){
        Intent i = new Intent (Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
        startActivity(i);
    }

    // Métode per executar la llanterna
    public void llanterna(){
        Toast.makeText(this, "doesn't work for now", Toast.LENGTH_SHORT).show();
    }

    // Métode per executar el teléfon
    public void marcador(){
        Intent i = new Intent(Intent.ACTION_DIAL);
        startActivity(i);
    }

    // Métode per executar la app contactes
    public void contactes(){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        startActivity(i);
    }

    // Métode per a executar la app Whatsapp
    public void whatsapp(){
        Intent i = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        if (i != null){
            startActivity(i);
        }
        else {
            Toast.makeText(this,"whatsapp isn't installed in your device", Toast.LENGTH_SHORT).show();
        }
    }

    // Strings per al canvi de color
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public int nombre = 0;

    // Métode per al canvi de color
    public void cargadades(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        nombre = sharedPreferences.getInt(TEXT,0);
    }

    // Métode principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargadades(); // Carga el métode SharedPreferences
        if (nombre == 1){
            setTheme(R.style.AppTheme);
        }
        if (nombre == 2){
            setTheme(R.style.TemaBlau);
        }
        if (nombre == 3){
            setTheme(R.style.TemaGris);
        }
        if (nombre == 4){
            setTheme(R.style.TemaCyan);
        }
        if (nombre == 5){
            setTheme(R.style.TemaVerd);
        }
        if (nombre == 6){
            setTheme(R.style.TemaTaronja);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitat__principal);

        // Botons
        Button camera;
        camera = findViewById(R.id.botocamera);

        Button galeria;
        galeria = findViewById(R.id.botogaleria);

        Button llanterna;
        llanterna = findViewById(R.id.botollanterna);

        Button trucar;
        trucar = findViewById(R.id.bototrucar);

        Button contactes;
        contactes = findViewById(R.id.botocontactes);

        Button whatsapp;
        whatsapp = findViewById(R.id.botowhatsapp);

        Button datos;
        datos = findViewById(R.id.btdatos);

        ToggleButton wifitoggle;
        wifitoggle = findViewById(R.id.togglewifi);

        ToggleButton llanternatoggle;
        llanternatoggle = findViewById(R.id.togglellanterna);


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera();
            }
        });
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galeria();
            }
        });
        llanterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llanterna();
            }
        });
        trucar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcador();
            }
        });
        contactes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactes();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsapp();
            }
        });


        // Mira si el dispositiu està ja conectat a la xarxa i el tipus de conexió en que es troba
        final ConnectivityManager connexio = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        for (Network network : connexio.getAllNetworks()) {
            NetworkInfo networkInfo = connexio.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                wifitoggle.setChecked(true);
            }
        }
        // Configura el toggle wifi
        wifitoggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                }
                else{
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });

        // Configura el botó de Dades Mòbils (Redirecciona a configuració/dades movils), únicament disponible per a la API de Android 28 (Android P)
        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api();
            }
        });

        // Flashlight
         final CameraManager mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
         try {
             mCameraId = mCameraManager.getCameraIdList()[0];
         }
         catch (CameraAccessException e){
             e.printStackTrace();
         }

        // Configura la llanterna
        llanternatoggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    try {
                        mCameraManager.setTorchMode(mCameraId, true);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
                else{

                }
            }
        });

    }

    // Métode per al botó enrere, activa el métode principal
    public void onBackPressed(){
        principal();
    }

    // Métode principal ( Inicia la Activitat Principal)
    public void principal(){
        Intent i = new Intent(this,Activitat_Principal.class);
        startActivity(i);
    }

}