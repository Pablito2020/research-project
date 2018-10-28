package com.ordinador.pablo.accesdirecte;

import android.os.Bundle;

import android.content.Intent; // Classe necessària per a iniciar Activitats o Accions
import android.support.design.widget.FloatingActionButton; // Classe necessària per a programar el botó flotant
import android.view.Menu; // Classe necessària en aquest cas per a NO mostrar el menú
import android.view.View; // Classe necessària per a programar tots els objectes de la interfície d'usuari.

public class info extends Activitat_Principal {

    // Métode per a no mostrar el menú
    public boolean onCreateOptionsMenu(Menu menu) { return false; }

    // Métode per a iniciar un Intent que mostri el menú compartir.
    // https://developer.android.com/guide/components/intents-filters?hl=es-419
    public void share(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String titol = getResources().getString(R.string.titol);
        String cos = getResources().getString(R.string.cos);
        String comparteixamb = getResources().getString(R.string.comparteixamb); // Si s'utilitza String title = R.string.comparteixamb; falla, ja que retorna int
        i.putExtra(Intent.EXTRA_SUBJECT, titol);
        i.putExtra(Intent.EXTRA_TEXT, cos);
        startActivity(Intent.createChooser(i, comparteixamb));
    }

    // Métode principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        // Floating Action Button
        // https://developer.android.com/guide/topics/ui/floating-action-button
        final FloatingActionButton compartir;
        compartir = findViewById(R.id.botoflotant);

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

    }
}
