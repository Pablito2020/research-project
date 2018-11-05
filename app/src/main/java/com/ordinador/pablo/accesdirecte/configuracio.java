package com.ordinador.pablo.accesdirecte;

import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.View; // Classe necessària per a interactuar amb els objectes de la interfície gràfica
import android.content.Intent; // Classe necessària per a el métode reinicia
import android.content.SharedPreferences; // Classe necessària per a guardar els nombres
import android.widget.Button; // Classe necessària per a la programació del botó
import android.widget.Spinner; // Classe necessària per a la programació del Spinner
import android.widget.AdapterView; // Classe necessària per a la vista de el Array del Spinner
import android.widget.ArrayAdapter; // Classe necessària per a la llista de el Spinner
import android.widget.Toast; // Classe necessària per als missatges Toast

// Classes Importades per la llibrería: com.anjlab.android.iab.v3:library:1.0.44
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class configuracio extends Activitat_Principal implements BillingProcessor.IBillingHandler {

    BillingProcessor bp;

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

    // Métode per a no mostrar el menú
    public boolean onCreateOptionsMenu(Menu menu) { return false; }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargadades();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracio);

        // Definim la clau per a el pagament dintre de la app
        bp = new BillingProcessor(this, null, this);

        // Definim el spinner color
        Spinner color;
        color = findViewById(R.id.spinercolor);

        // Botó per a anar a les aplicacions predeterminades
        Button aplicacionspredeterminades;
        aplicacionspredeterminades = findViewById(R.id.button);

        Button adds;
        adds = findViewById(R.id.adds);

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
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    Intent i = new Intent(android.provider.Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS);
                    startActivity(i);
                } else {
                    APIno();
                }
            }
        });

        if (noanuncis){
            adds.setEnabled(false);
        }

        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playstore()){
                    bp.purchase(configuracio.this,"android.premium.comprat");
                } else {
                    finish();
                }
            }
        });
    }

    // Métode necessari per a reiniciar la Activity
    public void reinicia(){
        Intent i = new Intent (this, configuracio.class);
        startActivity(i);
    }
    public void APIno(){
        Toast.makeText(this,R.string.APInoN,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(COMPRA,true);
        editor.apply();
        Toast.makeText(this,"Versió Completa Comprada!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPurchaseHistoryRestored() {
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(COMPRA,false);
        editor.apply();
    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
    }

    @Override
    public void onBillingInitialized() {
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(COMPRA,false);
        editor.apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public boolean playstore(){
        boolean playstore = BillingProcessor.isIabServiceAvailable(this);
        boolean si = true;
        if (!playstore){
            si = false;
        }
        return(si);
    }

    @Override
    public void onDestroy(){
        if(bp != null){
            bp.release();
        }
        super.onDestroy();
    }
}