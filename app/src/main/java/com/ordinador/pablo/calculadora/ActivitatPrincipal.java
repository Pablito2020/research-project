/*
Nom de l'aplicació: Calculadora
Autor: Pablo Fraile Alonso
Llicència: GNU License 3.0
*/

package com.ordinador.pablo.calculadora;

// Classes API directament importades per Android Studio
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// Importa la classe Botons ( necesària per a indicar que tenim botons a la pantalla)
import android.widget.Button;
// Importa les classes View ( necessària per a indicar quins botons són quins i la seva funcionalitat)
import android.view.View;
import android.view.View.OnClickListener;
// Importa la classe Toast ( per indicar errors amb un missatge flotant al usuari)
import android.widget.Toast;


// Activitat Principal ( Vista per el usuari)
public class ActivitatPrincipal extends AppCompatActivity implements OnClickListener {

    // Métode afegit ja per Android Studio per a mostrar el que surt per pantalla, en aquest cas, la pantalla principal és anomenada activity_activitat_principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat_principal);
        // Dona nom als botons mitjançant la ID

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

        // Botons de Funcions matemàtiques
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
    }

    @Override
    public void onClick(View v) {
        // Crea les variables x (primer nombre), y (segon nombre), z (resultat)
        int x=0;
        int y=0;
        double z=0;

        // Administra la funcionalitat de cada botó. Amb el métode si es pren el botó x, fer y acció.
        if(v == findViewById(R.id.nombre1)){
            Toast.makeText(this, "Nombre 1", Toast.LENGTH_LONG).show();
        }
        
        //else if(v == findViewById(R.id.nombre0)){
        //  Toast.makeText(this, "Nombre 0", Toast.LENGTH_LONG).show();
        //}
        
        else if(v == findViewById(R.id.nombre2)){
            Toast.makeText(this, "Nombre 2", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre3)){
            Toast.makeText(this, "Nombre 3", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre4)){
            Toast.makeText(this, "Nombre 4", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre5)){
            Toast.makeText(this, "Nombre 5", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre6)){
            Toast.makeText(this, "Nombre 6", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre7)){
            Toast.makeText(this, "Nombre 7", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre8)){
            Toast.makeText(this, "Nombre 8", Toast.LENGTH_LONG).show();
        }
        
        else if(v == findViewById(R.id.nombre9)){
            Toast.makeText(this, "Nombre 9", Toast.LENGTH_LONG).show();
        }

        
        // Botons d'operacions matemàtiques
        if(v == findViewById(R.id.botodivisio)){
            boolean divisio = true;
        }

        if(v == findViewById(R.id.botomultiplicacio)){
            boolean multiplicacio = true;
        }

        if(v == findViewById(R.id.botoresta)){
            boolean resta = true;
        }

        if(v == findViewById(R.id.botosuma)){
            boolean suma = true;
        }

        
        // Botons de borrar
        else if(v == findViewById(R.id.borraunnum)){
        }
        
        else if(v == findViewById(R.id.borratot)){
            x = 0;
            y = 0;
            z = 0;       
        }

        // Botó de igual
         if(v == findViewById(R.id.botoigual)){
             if (multiplicacio==true){
             // Si la multiplicació = true mira si x!=0 i si y!=0 i fes x · y
             }
             else if (divisio==true){
             // Si la divisió = true mira si x!=0 i si y!=0 i fes x / y
             }
             else if (suma==true){
             // Si la suma = true mira si x!=0 i si y!=0 i fes x + y
             }
             else if (resta==true){
             // Si la resta = true mira si x!=0 i si y!=0 i fes x - y
             }
             else{
                  Toast.makeText(this, "Apreti alguan operació matemàtica", Toast.LENGTH_LONG).show();
             }
        }
    }
}
