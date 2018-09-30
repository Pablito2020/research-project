
package com.ordinador.pablo.calculadora;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Classe per al mode Nocturn
import android.support.v7.app.AppCompatDelegate;

// Classe necessària per a canviar d'activity
import android.content.Intent;

// Classes de Botons, Caixes de Text i Switch
import android.widget.Button;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

//Classes  necessàries per als missatges flotants
import android.content.Context;
import android.widget.Toast;

//Classes necessàries per al funcionament del menú de la app
import android.view.Menu;
import android.view.MenuItem;

// Classes necessàris per a l'avís abans de sortir de la app.
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class ActivitatPrincipal extends AppCompatActivity {

    // Variables necesàries per a la calculadora
    String primernombre = "";
    String signe = "";
    String resultatstring = "";
    double resultat = 0;
    int resultatint = 0;
    boolean coma = false;

    // Métodes per a inciar les activities de menú i la principal ( aquesta es únicament per a resetejar la activity quan s'habilita el mode nocturn
    public void activityopcions(View view){
        Intent i = new Intent(this, menuopcions.class);
        startActivity(i);
    }
    public void activityprincipal(){
        Intent i = new Intent(getApplicationContext(),ActivitatPrincipal.class);
        startActivity(i);
        finish();
    }

    // Métodes per a que es mostri el menú i la programació de cada apartat d'aquest
    @Override
    public boolean onCreateOptionsMenu(Menu menuconf) {
        getMenuInflater().inflate(R.menu.menu, menuconf);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem opciomenu) {
        int id=opciomenu.getItemId();
        if (id==R.id.about){
            activityopcions(null); // No es pot mostrar cap objecte view ( cap widget,etc.) per tant, li donem un parametre null (no tenim res)
        }
        return super.onOptionsItemSelected(opciomenu); // Per si el usuari no clique cap botons, es retorna a la opció menu
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Configuració del layout i el switch activador del mode nit.
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }
        // Afegit per Android Studio, carga el layout Activitat principal
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat_principal);
        // Botó Switch
        Switch switchobscur;
        switchobscur = (Switch)findViewById(R.id.darkswitch);
        // Si el mode nocturn ja està activat, dili que el switch ja està activat
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            switchobscur.setChecked(true);
        }
        // OnCheckedChangeListener
        switchobscur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    activityprincipal();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    activityprincipal();
                }
            }
        });

        // Configuració de la calculadora
        // Dona nom als botons i al switch mitjançant la ID
        Button nombre0 = findViewById(R.id.nombre0);
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
        Button botompultiplicacio = findViewById(R.id.botomultiplicacio);
        // Botons de Borrar
        Button borra = findViewById(R.id.borra);
        Button punt = findViewById(R.id.punt);
        // TextView on apareixeràn i es guardaràn els nombres
        final TextView operand = (TextView) findViewById(R.id.operand);


        // Administra la funció de cada botó.
        nombre0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "0";
                operand.setText(input);
            }
        });

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

        punt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + ".";
                operand.setText(input);
                coma = true;
            }
        });

        // Administració de Botons de Suma, Resta, Multiplicació, Divisió, igual i borrar.

        botosuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                primernombre = operand.getText().toString();
                operand.setText("");
                signe = ("+");
            }
        });
        botosuma.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duració = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.suma, duració).show();
                return true;
            }
        });

        botoresta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                primernombre = operand.getText().toString();
                operand.setText("");
                signe = ("-");
            }
        });
        botoresta.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duració = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.resta, duració).show();
                return true;
            }
        });

        botompultiplicacio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                primernombre = operand.getText().toString();
                operand.setText("");
                signe = ("*");
            }
        });
        botompultiplicacio.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duració = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.multiplicacio, duració).show();
                return true;
            }
        });

        botodivisio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                primernombre = operand.getText().toString();
                operand.setText("");
                signe = ("/");
            }
        });
        botodivisio.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duració = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.divisio, duració).show();
                return true;
            }
        });

        botoigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signe.equals("+")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) + Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) + Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                    }
                }
                if (signe.equals("-")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) - Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) - Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                    }
                }
                if (signe.equals("*")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) * Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) * Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                    }
                }
                if (signe.equals("/")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) / Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) / Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                    }
                }
            }
        });
        botoigual.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duració = Toast.LENGTH_SHORT;
                Toast.makeText(context,R.string.igual, duració).show();
                return true;
            }
        });

        borra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input.substring(0,operand.length()-1); // https://developer.android.com/reference/android/widget/TextView
                operand.setText(input);
            }
        });
        borra.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                operand.setText("");
                signe = ("");
                primernombre = ("");
                coma = false;
                return true ;
            }
        });

    }

    // Missatge de Alerta quan es pren el botó enrere en la pantalla.
    public void onBackPressed(){
        mostraalerta();
    }
    private void mostraalerta(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder .setCancelable(false);
        builder.setTitle(R.string.titolalerta);
        builder.setMessage(R.string.missatgealerta);

        builder.setPositiveButton(R.string.respostasi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton(R.string.respostano, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show(); // Crea el missatge
    }

}