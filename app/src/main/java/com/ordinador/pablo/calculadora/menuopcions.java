package com.ordinador.pablo.calculadora;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import android.view.Menu; // Classe Necessària per a eliminar el Menú
import android.view.View; // Classe necessària per a cargar
import android.widget.Button; // Classe Necessària per a programar els botons (Licència i Codi)
import android.content.Intent; // Necessari per a executar la activity navegador per a cargar els links de la llicència i el codi
import android.net.Uri; // Necessària per a cargar links

public class menuopcions extends ActivitatPrincipal{

    public boolean onCreateOptionsMenu(Menu menuconf) { // Retornem un valor fals al menú, per tant, no es mostra en pantalla
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){ // Si el mode nocturn està activat a la altra activity, fica'l també aquí.
            setTheme(R.style.DarkTheme);
        }
        else { // Si el mode nocturn NO està activat a l'altra Activity, no fiquis el tema obscur
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setTitle(R.string.about); // Canvia el títol per el String "Sobre la app"
        setContentView(R.layout.menulayout); // Mostra el layout menulayout.xml

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

    public void onBackPressed(){ // Métode per a no mostrar el misatge d'alerta quan es clica el botó enrere, sinò que s'acaba l'activity i per tant, es retorna a la activityprincipal.
        finish();
    }
}