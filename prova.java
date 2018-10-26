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

    // Variables
    // int resultatint = 0; // Variable necessària per al resultat (enters)
    // double multiplica= 0; // Variable necessària per al nombre pi
    // double resultat = 0; // Variable necessària per al resultat (decimal)
    // boolean coma = false; // Variable necessària per a la funció de coma
    // String primernombre = ""; // Variable necessària per a guardar el primer nombre escollit per l'usuari
    // String signe = ""; // Variable necessària per a guardar el signe escollit
    // String resultatstring = "";

    // Métodes
    public void activityopcions(View view){ // Métode per a iniciar la classe " sobre la aplicació"
        Intent i = new Intent(this, menuopcions.class);
        startActivity(i);
    }
    public void activityprincipal(){  // Métode per a iniciar la classe activitat principal (necessari per al switch Mode Obscur)
        Intent i = new Intent(getApplicationContext(),ActivitatPrincipal.class);
        startActivity(i);
        finish();
    }
    public boolean onCreateOptionsMenu(Menu menuconf) {  // Métode per a mostrar el menú
        getMenuInflater().inflate(R.menu.menu, menuconf);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem opciomenu) { // Métode per a dir que es fa si es pren determinat apartat del menú
        int id=opciomenu.getItemId();
        if (id==R.id.about){
            activityopcions(null); // No es pot mostrar cap objecte view ( cap widget,etc.) per tant, li donem un parametre null (no tenim res)
        }
        return super.onOptionsItemSelected(opciomenu); // Per si el usuari no clique cap botons, es retorna a la opció menu
    }

double result = 0;
public double calcula(Double anterior, Double actual, String signe){

if (negatiu) actual = actual * -1;  
  switch(signe){
    case ("+"):
    result = anterior + actual;
    break;
    case ("-"):
    result = anterior - actual;
    break;
    case ("/"):
    result = anterior / actual;
    break;
    case ("x"):
    result = anterior * actual;
    break;
  }
  return(result);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Métode incial, inclòs per Android Studio.

        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat_principal);
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

        //String x = operand.getText.toString;
        Double anterior = 0;
        Double despres = 0;
        Double final = 0;
        Boolean negatiu = false;

        // Dona nom als botons i al switch mitjançant la ID
        Button nombre0 = findViewById(R.id.nombre0);                       // 0
        Button nombre1 = findViewById(R.id.nombre1);                       // 1
        Button nombre2 = findViewById(R.id.nombre2);                       // 2
        Button nombre3 = findViewById(R.id.nombre3);                       // 3
        Button nombre4 = findViewById(R.id.nombre4);                       // 4
        Button nombre5 = findViewById(R.id.nombre5);                       // 5
        Button nombre6 = findViewById(R.id.nombre6);                       // 6
        Button nombre7 = findViewById(R.id.nombre7);                       // 7
        Button nombre8 = findViewById(R.id.nombre8);                       // 8
        Button nombre9 = findViewById(R.id.nombre9);                       // 9
        Button botoigual = findViewById(R.id.botoigual);                   // Botó igual
        Button botodivisio = findViewById(R.id.botodivisio);               // Botó divisió
        Button botosuma = findViewById(R.id.botosuma);                     // Botó suma
        Button botoresta = findViewById(R.id.botoresta);                   // Botó resta
        Button botompultiplicacio = findViewById(R.id.botomultiplicacio);  // Botó multiplicació
        Button borra = findViewById(R.id.borra);                           // Botó de Borrar;
        Button punt = findViewById(R.id.punt);                             // Botó de punt/coma
        Button pi = findViewById(R.id.pi);                                 // Botó de Pi
        Button doblezero = findViewById(R.id.nombre00);                    // Botó doble zero
        final TextView operand = findViewById(R.id.operand);               // Text on apareixeràn els nombres

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
                coma = true; // El nombre pi conté comes. Si no es canvia el boolean coma, la aplicació falla.
                String input = operand.getText().toString();
                if (!input.equals("")){
                    multiplica = Double.parseDouble(input) * numpi;
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
                coma = true;
            }
        });

        botosuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              // if (signe.equals("+")){
              //   String actualString = operand.getText;
              //    actual = Double.parseDouble(anteriorString);
              //    final = anterior + actual;
              //    String finalstring = String.valueOf(final);
              //    operand.setText(finalstring);
              // }
calcula(anterior,actual,signe);
signe = "+";               
            }
        });

        botoresta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nombretext = operand.getText().toString(); // Agafa el text que hi ha a la textView i donali la variable string nombretext (únicament per a botoresta)
if (anterior==0){
  negatiu = true;
}
else{
  calcula();
}
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

        botodivisio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    primernombre = operand.getText().toString();
                    operand.setText("");
                    signe = ("/");
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
                /*if (signe.equals("+")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) + Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                        primernombre="";
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) + Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                        primernombre="";
                    }
                }
                if (signe.equals("-")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) - Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                        primernombre="";
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) - Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                        primernombre="";
                    }
                }
                if (signe.equals("*")){
                    if (coma){
                        resultat = Double.parseDouble(primernombre) * Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        operand.setText(resultatstring);
                        primernombre="";
                    }
                    else {
                        resultatint = Integer.parseInt(primernombre) * Integer.parseInt(operand.getText().toString());
                        resultatstring = String.valueOf(resultatint);
                        operand.setText(resultatstring);
                        primernombre="";
                    }
                }
                if (signe.equals("/")){
                    resultat = Double.parseDouble(primernombre) / Double.parseDouble(operand.getText().toString());
                    resultatstring = String.valueOf(resultat);
                    operand.setText(resultatstring);
                    primernombre="";
                }*/
               restultat.setText(String.valueOf(calcula(anterior, atual, operand)));
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
                signe = ("");
                primernombre = ("");
                coma = false;
                return true ;
            }
        });
    }

    // Métodes per a el misatge d'alerta quan es pren el botó enrere.
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
