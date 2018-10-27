package com.ordinador.pablo.calculadora;
import android.os.Bundle;

import android.view.View; // Classe necessària per a programar els components de la interfície d'usuari
import android.view.Menu; // Classe Necessària per a eliminar el Menú
import android.widget.Button; // Classe Necessària per a programar els botons (Licència i Codi)

import android.content.Intent; // Necessari per a executar noves activities
import android.net.Uri; // Necessària per a cargar links


public class menuopcions extends ActivitatPrincipal{

    public boolean onCreateOptionsMenu(Menu menuconf) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulayout);

        Button botogithub;
        botogithub = findViewById(R.id.botogithub);
        Button botognu;
        botognu = findViewById(R.id.botognu);

        botogithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pagweb = Uri.parse("https://github.com/Pablito2020/Treball-de-Recerca");
                Intent githubweb = new Intent(Intent.ACTION_VIEW, pagweb);
                startActivity(githubweb);
            }
        });

        botognu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pagweb = Uri.parse("https://raw.githubusercontent.com/Pablito2020/Treball-de-Recerca/master/LICENSE");
                Intent gnu = new Intent(Intent.ACTION_VIEW, pagweb);
                startActivity(gnu);
            }
        });
    }

    // Com la Activity MenuOpcions es una ampliació de la Activity Principal, tot el programat a l'Activity Principal s'aplica a menuopcions.
    // Per tant, s'ha de tornar a programar el botó enrere per a que no mostri el métode mostraalerta, sinò que finalitzi la activitat menuopcions.
    public void onBackPressed(){
        finish();
    }
}