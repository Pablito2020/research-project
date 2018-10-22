package com.ordinador.pablo.accesdirecte;

import android.os.Build;
import android.os.Bundle;

import android.view.View; // Classe necessària per a interactuar amb els objectes de la interfície gràfica
import android.content.Intent; // Classe necessària per a el métode reinicia
import android.content.SharedPreferences; // Classe necessària per a guardar els nombres
import android.widget.Button; // Classe necessària per a la programació del botó
import android.widget.Spinner; // Classe necessària per a la programació del Spinner
import android.widget.AdapterView; // Classe necessària per a la vista de el Array del Spinner
import android.widget.ArrayAdapter; // Classe necessària per a la llista de el Spinner
import android.widget.Toast; // Classe necessària per als missatges Toast
import android.support.annotation.RequiresApi; // Classe necessària per a nombrar la API d'Android necessària per a x funció

public class configuracio extends Activitat_Principal {

    public void guardadadesrosa(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 1);
        editor.apply();
        Toast.makeText(this,R.string.rosaaplicat, Toast.LENGTH_LONG).show();
    }
    public void guardadadesblau(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 2);
        editor.apply();
        Toast.makeText(this,R.string.blauaplicat, Toast.LENGTH_LONG).show();
    }
    public void guardadadesgris(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 3);
        editor.apply();
        Toast.makeText(this,R.string.grisaplicat, Toast.LENGTH_LONG).show();
    }
    public void guardadescyan(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 4);
        editor.apply();
        Toast.makeText(this,R.string.cyanaplicat, Toast.LENGTH_LONG).show();
    }
    public void guardadesverd(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 5);
        editor.apply();
        Toast.makeText(this,R.string.verdaplicat, Toast.LENGTH_LONG).show();
    }
    public void guardadestaronja(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 6);
        editor.apply();
        Toast.makeText(this,R.string.taronjaaplicat, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargadades();
        super.onCreate(savedInstanceState);
        setTitle(R.string.configuracio);
        setContentView(R.layout.configuracio);

        // Definim el spinner color
        Spinner color;
        color = findViewById(R.id.spinercolor);

        // Botó per a anar a les aplicacions predeterminades
        Button aplicacionspredeterminades;
        aplicacionspredeterminades = findViewById(R.id.button);

        // Configurem el spinner, la Array (llista que apareixerà i que es farà en cada cas)
        // https://developer.android.com/guide/topics/ui/controls/spinner?hl=es-419
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(adapter);
        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;

                    case 1:
                        guardadadesrosa();
                        reinicia();
                        break;

                    case 2:
                        guardadadesblau();
                        reinicia();
                        break;

                    case 3:
                        guardadadesgris();
                        reinicia();
                        break;

                    case 4:
                        guardadescyan();
                        reinicia();
                         break;

                    case 5:
                        guardadesverd();
                        reinicia();
                        break;

                    case 6:
                        guardadestaronja();
                        reinicia();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Es configura el botó aplicacionspredeterminades
        aplicacionspredeterminades.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N) // Afegit per Android Studio, demana la API de Android N per a funcionar.
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.provider.Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS);
                startActivity(i);
            }
        });
    }

    // Métode necessari per a reiniciar la Activity
    public void reinicia(){
        Intent i = new Intent (this, configuracio.class);
        startActivity(i);
    }
}