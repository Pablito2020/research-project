/*
Nom de l'aplicació: Calculadora
Autor: Pablo Fraile Alonso
Llicència: GNU License 3.0
 */

package com.ordinador.pablo.calculadora;

// Importa la classe de la API
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// Importa la classe Botons
import android.widget.Button;
// Importa la classe View ( necessària per a botons)
import android.view.View;
// Importa la classe Toast ( sol per veure si funciona)
import android.widget.Toast;


// Activitat Principal ( Vista per el usuari)
public class ActivitatPrincipal extends AppCompatActivity implements View.OnClickListener {

    // Métode afegit ja per Android Studio per a mostrar el que surt per pantalla, en aquest cas, la pantalla principal és anomenada activity_activitat_principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat_principal);

        // 1) Troba els botons mitjançant el id nombrat anteriorment.
        // 2) Fés compatible el botó amb la classe setOnClickListener, encarregada d'administrar que fa el botó

        // Botons de Funcions Matemàtiques
        Button botoigual = findViewById(R.id.botoigual);
        botoigual.setOnClickListener(this);
        Button botodivisio = findViewById(R.id.botodivisio);
        botodivisio.setOnClickListener(this);
        Button botosuma = findViewById(R.id.botosuma);
        botosuma.setOnClickListener(this);
        Button botoresta = findViewById(R.id.botoresta);
        botoresta.setOnClickListener(this);
        // Botons de Borrar
        Button borratot = findViewById(R.id.borratot);
        borratot.setOnClickListener(this);
        Button borraun = findViewById(R.id.borraunnum);
        borraun.setOnClickListener(this);
        // Botons que són nombres
        //Button nombre0 = findViewById(R.id.nombre0);
        // nombre0.setOnClickListener(this);
        Button nombre1 = findViewById(R.id.nombre1);
        nombre1.setOnClickListener(this);
        Button nombre2 = findViewById(R.id.nombre2);
        nombre2.setOnClickListener(this);
        Button nombre3 = findViewById(R.id.nombre3);
        nombre3.setOnClickListener(this);
        Button nombre4 = findViewById(R.id.nombre4);
        nombre4.setOnClickListener(this);
        Button nombre5 = findViewById(R.id.nombre5);
        nombre5.setOnClickListener(this);
        Button nombre6 = findViewById(R.id.nombre6);
        nombre6.setOnClickListener(this);
        Button nombre7 = findViewById(R.id.nombre7);
        nombre7.setOnClickListener(this);
        Button nombre8 = findViewById(R.id.nombre8);
        nombre8.setOnClickListener(this);
        Button nombre9 = findViewById(R.id.nombre9);
        nombre9.setOnClickListener(this);
    }


    // Métode per dir les accions que fa cada botó
    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            // Cas per als botons que no són nombres
            case R.id.botoigual:
                Toast.makeText(this, "El botó funcionaº", Toast.LENGTH_LONG).show();
                break;

            case R.id.botosuma:
                // codi aquí
                break;

            case R.id.botoresta:
                // codi aquí
                break;

            case R.id.botodivisio:
                // codi aquí
                break;

            case R.id.botomultiplicacio:
                // codi aquí
                break;


            case R.id.borratot:
                // codi aquí
                break;

            case R.id.borraunnum:
                // codi aquí
                break;

            default:
                break;
        }
    }
}