package com.ordinador.pablo.accesdirecte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent; // Classe necessària per a executar tasques
import android.net.Uri; // Classe necessària per obrir la galeria
import android.content.SharedPreferences; // Classe necessària per a guardar els paràmetres del canvi de color,
import android.view.Menu; // Classe necessària per a dir que hi ha un menú
import android.view.MenuInflater; // Classe necessària per a dir quin es l'arxiu xml del menú.
import android.view.MenuItem; // Classe necessària per a programar la funció dels diferents ítems del xml menú
import android.widget.Button; // Classe necessària per als botons
import android.provider.MediaStore; // Classe necessària per a executar la app de càmera.
import android.view.View; // Classe necessària per a els elements d'interfície d'usuari
import android.widget.Toast; // Classe necessària per a executar missatges tipus Toast.
import android.widget.ToggleButton; // Classe Necessària per a controlar els botons tipus toggle
import android.widget.CompoundButton; // Classe necessària per a controlar un botó amb dos estats (encés o no encés) com per exemple el Toggle Button
import android.content.Context; // Classe necessària per a saber el contexte de la app
import android.net.wifi.WifiManager; // Classe necessària per a controlar el wifi de el SmartPhone
import android.net.ConnectivityManager; // Classe que respon a consultes sobre l'estat de la connectivitat de xarxa
import android.net.NetworkInfo; // Classe que describeix l'estat de una interfície de xarxa

public class Activitat_Principal extends AppCompatActivity {

    // Métode per obrir la Activity Informació de la app
    public void info(){
        Intent i = new Intent(this, info.class);
        startActivity(i);
    }

    // Métode per a obrir la Activity Opcions de la app
    public void conf(){
        Intent conf = new Intent(this,configuracio.class);
        startActivity(conf);
    }

    // Métode per a mostrar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Métode per a programar el Menú
    @Override
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

        ToggleButton toggle = findViewById(R.id.togglewifi);
        ConnectivityManager conectat = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert conectat != null;
        NetworkInfo wifi = conectat.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifi.isConnected()){
            toggle.setChecked(true);
        }

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
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    assert wifi != null;
                    wifi.setWifiEnabled(true);
                }
                else{
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    assert wifi != null;
                    wifi.setWifiEnabled(false);
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
