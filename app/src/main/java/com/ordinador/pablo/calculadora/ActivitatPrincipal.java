/*
Aplicació: Calculadora
Autor: Pablo Fraile Alonso
Llicència: GNU License 3.0
Android API: 
*/

package com.ordinador.pablo.calculadora;
// Classes API directament importades per Android Studio
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*
Importació de packages:
Packages necessàris perl funcionament de la calculadora:
1) android.widget.Button ------------ Necessari per a indicar i nombrar els botons escrits en el layout
2) android.view.view ---------------- Necessari per a localitzar els botons i poder renombral's.
3) android.widget.TextView ---------- Necessari per a poder llegir el textview dels nombres
4) android.widget.Toast ------------- Necessari per a enviar missatges flotants per la pantalla a l'usuari
*/
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


// Activitat Principal ( Vista per el usuari)
public class ActivitatPrincipal extends AppCompatActivity {

    // Métode afegit ja per Android Studio per a mostrar el que surt per pantalla, en aquest cas, la pantalla principal és anomenada activity_activitat_principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat_principal);
        // Dona nom als botons mitjançant la ID
        //Button nombre0 = findViewById(R.id.nombre0);
        Button nombre1 = findViewById(R.id.nombre1);
        Button nombre2 = findViewById(R.id.nombre2);
        Button nombre3 = findViewById(R.id.nombre3);
        Button nombre4 = findViewById(R.id.nombre4);
        Button nombre5 = findViewById(R.id.nombre5);
        Button nombre6 = findViewById(R.id.nombre6);
        Button nombre7 = findViewById(R.id.nombre7);
        Button nombre8 = findViewById(R.id.nombre8);
        Button nombre9 = findViewById(R.id.nombre9);

        // Botons de Funcions matemàtiques
        Button botoigual = findViewById(R.id.botoigual);
        Button botodivisio = findViewById(R.id.botodivisio);
        Button botosuma = findViewById(R.id.botosuma);
        Button botoresta = findViewById(R.id.botoresta);

        // Botons de Borrar
        Button borratot = findViewById(R.id.borratot);
        Button borraun = findViewById(R.id.borraunnum);

        // TextView on aniràn els nombres
        final TextView operand = (TextView) findViewById(R.id.operand);

        /*
        Objectiu del métode: Administrar la funció de cada botó.
        Funcionament: Fes que la "textview" definida anteriorment en el arxiu xml de la activityprincipal, s'utilitzi per a guardar els nombres.
        Una vegada es pren el botó d'un nombre determinat,aquest llegeix el que es troba en el textview i li suma el seu nombre corresponent.

        Exemple:
        A el textview ja hi trobem que hi ha un 5 i nosaltres prenem el botó 1, per tant el programa asignarà un 1 després del 5, per tant
        el resultat final quedarà 51.
        */
        nombre1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              String input = operand.getText().toString();
              input = input + "1";
             operand.setText(input);
        }
        });

        nombre2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
             String input = operand.getText().toString();
             input = input + "2";
             operand.setText(input);
            }
        });

        nombre3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "3";
                operand.setText(input);
            }
        });

        nombre4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "4";
                operand.setText(input);
            }
        });

        nombre5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "5";
                operand.setText(input);
            }
        });

        nombre6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "6";
                operand.setText(input);
            }
        });

        nombre7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "7";
                operand.setText(input);
            }
        });

        nombre8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "8";
                operand.setText(input);
            }
        });

        nombre9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "9";
                operand.setText(input);
            }
        });

        borratot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = "";
                operand.setText(input);
            }
        });

        botodivisio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = "";
                operand.setText(input);
            }
        });


    }
}