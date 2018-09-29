/*
Aplicació: Calculadora
Autor: Pablo Fraile Alonso
Llicència: GNU License 3.0
Android SDK mínima per a l'aplicació: 22
Android SDK utilitzada: 28
*/

package com.ordinador.pablo.calculadora;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// Package per al mode Nocturn
import android.support.v7.app.AppCompatDelegate;
// Packages de Botons, Caixes de Text i Switch
import android.widget.Button;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
//Packages necessàris per al funcionament del menú de la app
import android.view.Menu;
import android.view.MenuItem;
// Packages necessàris per a l'avís abans de sortir de la app.
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;



public class ActivitatPrincipal extends AppCompatActivity {

    public void activityopcions(View view){
        Intent i = new Intent(this, menuopcions.class);
        startActivity(i);
    }
    public void activityprincipal(){
        Intent i = new Intent(getApplicationContext(),ActivitatPrincipal.class);
        startActivity(i);
        finish();
    }
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
        // Si el MODE_NIGHT_YES està habilitat, canvia el tema a el mode obscur, sinò, utilitza el tema programat de
        // fàbrica ( Aquestes linees de codi tenen que anar abans de que es cargui el layout.
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
        // TextView on aniràn els nombres
        final TextView operand = (TextView) findViewById(R.id.operand);


        // Administrarla funció de cada botó.
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

        borra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input.substring(0,operand.length()-1);
                operand.setText(input);
            }
        });
        borra.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                operand.setText("");
                return true ;
            }
        });

        botodivisio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String operacio = "/";
                String primernombre = operand.getText().toString();
                operand.setText("");

            }
        });
        botosuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String operacio = "+";
                String primernombre = operand.getText().toString();
                operand.setText("");

            }
        });
        botoresta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String operacio = "-";
                String primernombre = operand.getText().toString();
                operand.setText("");
            }
        });
        botompultiplicacio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String operacio = "*";
                String primernombre = operand.getText().toString();
                operand.setText("");
            }
        });
        botoigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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