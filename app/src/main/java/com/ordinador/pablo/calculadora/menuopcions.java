package com.ordinador.pablo.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class menuopcions extends ActivitatPrincipal{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Si el Mode Nocturn està habilitat, fes que el layout de el menu també tinqui el tema negre
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setTitle(R.string.about); // Canvia el títol per el String "Sobre la app"
        setContentView(R.layout.menulayout);

        // Configura els botons
        Button botogithub;
        botogithub = findViewById(R.id.botogithub);
        Button botognu;
        botognu = findViewById(R.id.botognu);

        botogithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/Pablito2020/Treball-de-Recerca"));
                startActivity(intent);
            }
        });

        botognu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://raw.githubusercontent.com/Pablito2020/Treball-de-Recerca/master/LICENSE"));
                startActivity(intent);
            }
        });
    }

    // Botó enrere NO mostra el missatge de sortida de la app, ja que sinò no es pot sortir del menulayout.xml
    @Override
    public void onBackPressed(){
        finish();
    }
}