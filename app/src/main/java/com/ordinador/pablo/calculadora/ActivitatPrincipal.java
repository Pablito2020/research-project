package com.ordinador.pablo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatDelegate; // Classe Mode Nocturn
import android.content.Intent; // Classe necessària per a canviar de Activity
import android.widget.Button; // Classe necessària per als botons
import android.view.View; // Classe necessària per a mostrar el xml de l'activity
import android.widget.CompoundButton; // Classe necessària per al switch obscur
import android.widget.Switch; // Classe necessària per a el switch
import android.widget.TextView; // Classe necessària per la textview nombres
import android.content.Context; // Classe necessària per a agafar el contexte per als missatges Toast
import android.widget.Toast; // Classe necessària per als missatges Toast

import android.view.Menu; // Classe necessària per mostrar el Menu
import android.view.MenuItem; // Classe necessària per a mostrar els ítems del Menú.

import android.content.DialogInterface; // Classe necessària per a el Dialog abans de sortir de la app
import android.support.v7.app.AlertDialog; //Classe necessària per a el Dialog abans de sortir de la app

public class ActivitatPrincipal extends AppCompatActivity {

    // Métode per a iniciar el menuopcions.class (menuopcions.java)
    public void activityopcions(View view){
        Intent i = new Intent(this, menuopcions.class);
        startActivity(i);
    }

    // Métode per a iniciar la classe activitat principal (necessari per al switch Mode Obscur)
    public void activityprincipal(){
        Intent i = new Intent(getApplicationContext(),ActivitatPrincipal.class);
        startActivity(i);
        finish();
    }

    // Métode per a mostrar el menú
    public boolean onCreateOptionsMenu(Menu menuconf) {
        getMenuInflater().inflate(R.menu.menu, menuconf);
        return true;
    }

    // Métode per a dir que es fa si es pren determinat apartat del menú
    public boolean onOptionsItemSelected (MenuItem opciomenu) {
        int id=opciomenu.getItemId();
        if (id==R.id.about){
            activityopcions(null); // No es pot mostrar cap objecte view ( cap widget,etc.) per tant, li donem un parametre null (no tenim res)
        }
        return super.onOptionsItemSelected(opciomenu);
    }

    // Variables necessàries per a la calculadora
    double anterior = 0;
    double actual = 0;
    double numfinal = 0;
    String signe = "";

    // Métode double Calcula
    public double calcula(Double anterior, Double actual, String signe){
        switch (signe){
            case ("+"):
                numfinal = anterior + actual;
                break;
            case ("-"):
                numfinal = anterior - actual;
                break;
            case ("*"):
                numfinal = anterior * actual;
                break;
            case ("/"):
                numfinal = anterior / actual;
                break;
        }
        return(numfinal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }else{
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat_principal);

        // Declaració del SwitchObscur i la seva funció.
        Switch switchobscur;
        switchobscur = findViewById(R.id.darkswitch);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            switchobscur.setChecked(true);
        }
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
        Button nombre0 = findViewById(R.id.nombre0);                       // Botó 0
        Button nombre1 = findViewById(R.id.nombre1);                       // Botó 1
        Button nombre2 = findViewById(R.id.nombre2);                       // Botó 2
        Button nombre3 = findViewById(R.id.nombre3);                       // Botó 3
        Button nombre4 = findViewById(R.id.nombre4);                       // Botó 4
        Button nombre5 = findViewById(R.id.nombre5);                       // Botó 5
        Button nombre6 = findViewById(R.id.nombre6);                       // Botó 6
        Button nombre7 = findViewById(R.id.nombre7);                       // Botó 7
        Button nombre8 = findViewById(R.id.nombre8);                       // Botó 8
        Button nombre9 = findViewById(R.id.nombre9);                       // Botó9
        Button botoigual = findViewById(R.id.botoigual);                   // Botó igual
        Button botodivisio = findViewById(R.id.botodivisio);               // Botó divisió
        Button botosuma = findViewById(R.id.botosuma);                     // Botó suma
        Button botoresta = findViewById(R.id.botoresta);                   // Botó resta
        Button botompultiplicacio = findViewById(R.id.botomultiplicacio);  // Botó multiplicació
        Button borra = findViewById(R.id.borra);                           // Botó de Borrar;
        Button punt = findViewById(R.id.punt);                             // Botó de punt/coma
        Button pi = findViewById(R.id.pi);                                 // Botó de Pi
        Button doblezero = findViewById(R.id.nombre00);                    // Botó doble zero
        final TextView operand = findViewById(R.id.operand);               // Caixa de Text on apareixeràn els nombres

        // Programació de totes les accions dels botons
        nombre0.setOnClickListener(new View.OnClickListener() { // Administració del nombre 0
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "0";
                operand.setText(input);
            }
        });
        nombre1.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 1
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "1";
                operand.setText(input);
            }
        });
        nombre2.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 2
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "2";
                operand.setText(input);
            }
        });
        nombre3.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 3
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "3";
                operand.setText(input);
            }
        });
        nombre4.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 4
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "4";
                operand.setText(input);
            }
        });
        nombre5.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 5
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "5";
                operand.setText(input);
            }
        });
        nombre6.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 6
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "6";
                operand.setText(input);
            }
        });
        nombre7.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 7
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "7";
                operand.setText(input);
            }
        });
        nombre8.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 8
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "8";
                operand.setText(input);
            }
        });
        nombre9.setOnClickListener(new View.OnClickListener(){ // Administració del nombre 9
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + "9";
                operand.setText(input);
            }
        });
        doblezero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Administració del botó doble zero (00)
                String input = operand.getText().toString();
                input = input + "00";
                operand.setText(input);
            }
        });
        pi.setOnClickListener(new View.OnClickListener() {  // Administració del nombre pi. Es comproba si hi ha un nombre radere, si és el cas, es multiplica per pi , sinò ni ha, s'afegeix el nombre pi
            @Override
            public void onClick(View v) {
                double numpi = Math.PI;
                String input = operand.getText().toString();
                if (!input.equals("")){
                    Double multiplica = Double.parseDouble(input) * numpi;
                    String multiplicacio = String.valueOf(multiplica);
                    operand.setText(multiplicacio);
                }
                else {
                    input = input + numpi;
                    operand.setText(input);
                }
            }
        });
        punt.setOnClickListener(new View.OnClickListener() { // Administració del botó coma
            @Override
            public void onClick(View v) {
                String input = operand.getText().toString();
                input = input + ".";
                operand.setText(input);
            }
        });

        botosuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if ( anterior == 0 && actual == 0){
                    anterior = Double.parseDouble((String)operand.getText());
                    operand.setText("");
                }else{
                    actual = Double.parseDouble((String)operand.getText());
                    anterior = calcula(anterior,actual,signe);
                    operand.setText("");
                }
                signe = "+";
            }
        });

        botoresta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = operand.getText().toString();
                if (text.equals("")){
                    operand.setText("-");
                }else if( anterior == 0 && actual == 0){
                    anterior = Double.parseDouble((String)operand.getText());
                    operand.setText("");
                    signe = "-";
                }else{
                    actual = Double.parseDouble((String)operand.getText());
                    anterior = calcula(anterior,actual,signe);
                    operand.setText("");
                    signe = "-";
                }
            }
        });

        botompultiplicacio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if ( anterior == 0 && actual == 0){
                    anterior = Double.parseDouble((String)operand.getText());
                    operand.setText("");
                }else{
                    actual = Double.parseDouble((String)operand.getText());
                    anterior = calcula(anterior,actual,signe);
                    operand.setText("");
                }
                signe = "*";
            }
        });

        botodivisio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if ( anterior == 0 && actual == 0){
                    anterior = Double.parseDouble((String)operand.getText());
                    operand.setText("");
                }else{
                    actual = Double.parseDouble((String)operand.getText());
                    anterior = calcula(anterior,actual,signe);
                    operand.setText("");
                }
                signe = "/";
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

        botoigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actual = Double.parseDouble((String)operand.getText());
                numfinal = calcula(anterior, actual, signe);
                operand.setText(String.valueOf(numfinal));

                // Es canvien les variables a zero, per tal de que l'usuari pugui fer operacions amb el resultat i no doni error.
                anterior = 0;
                numfinal = 0;
                actual = 0;
            }
        });

        // Programació de botons quan es prenen durant un periode llarg de temps.
        botoigual.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duracio = Toast.LENGTH_SHORT;
                Toast.makeText(context,R.string.igual, duracio).show();
                return true;
            }
        });
        botosuma.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duracio = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.suma, duracio).show();
                return true;
            }
        });
        botoresta.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duracio = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.resta, duracio).show();
                return true;
            }
        });
        botompultiplicacio.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duracio = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.multiplicacio, duracio).show();
                return true;
            }
        });
        botodivisio.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                int duracio = Toast.LENGTH_SHORT;
                Toast.makeText(context, R.string.divisio, duracio).show();
                return true;
            }
        });
        borra.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                operand.setText("");
                anterior = 0;
                actual = 0;
                numfinal = 0;
                signe = "";
                return true ;
            }
        });
    }

    public void onBackPressed(){ // Quan pren el botó enrere, executa el métode mostraalerta
        mostraalerta();
    }

    private void mostraalerta(){ // Utilitza la classe AlerDialogBuilder i DialogInterface
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
        builder.create().show(); // Crea el missatge i mostra'l
    }
}