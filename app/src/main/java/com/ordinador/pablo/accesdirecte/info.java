package com.ordinador.pablo.accesdirecte;

import android.os.Bundle;

import android.content.Intent; // Classe necessària per a iniciar Activitats o Accions
import android.support.design.widget.FloatingActionButton; // Classe necessària per a programar el botó flotant
import android.view.Menu; // Classe necessària en aquest cas per a NO mostrar el menú
import android.view.View; // Classe necessària per a programar tots els objectes de la interfície d'usuari.
import android.widget.Button;
import android.net.Uri;

public class info extends Activitat_Principal {

    // Métode per a no mostrar el menú
    public boolean onCreateOptionsMenu(Menu menu) { return false; }

    // Métode per a iniciar un Intent que mostri el menú compartir.
    // https://developer.android.com/guide/components/intents-filters?hl=es-419
    public void share(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        String titol = getString(R.string.titol);
        String cos = getString(R.string.cos);
        String comparteixamb = getString(R.string.comparteixamb);

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
        FloatingActionButton compartir;
        compartir = findViewById(R.id.botoflotant);

        Button github;
        github = findViewById(R.id.botogithub);

        Button llicencia;
        llicencia = findViewById(R.id.botognu);


        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pagweb = Uri.parse("https://github.com/Pablito2020/Treball-de-Recerca");
                Intent githubweb = new Intent(Intent.ACTION_VIEW, pagweb);
                startActivity(githubweb);
            }
        });

        llicencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pagweb = Uri.parse("https://raw.githubusercontent.com/Pablito2020/Treball-de-Recerca/master/LICENSE");
                Intent gnu = new Intent(Intent.ACTION_VIEW, pagweb);
                startActivity(gnu);
            }
        });

    }
}
