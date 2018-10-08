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

    String primernombre = ""; // Variable necessària per a guardar el primer nombre escollit per l'usuari
    String signe = ""; // Variable necessària per a guardar el signe escollit
    String resultatstring = "";
    double multiplica= 0; // Variable necessària per al nombre pi
    double resultat = 0; // Variable necessària per al resultat (decimal)
    int resultatint = 0; // Variable necessària per al resultat (enters)
    boolean coma = false; // Variable necessària per a la funció de coma

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
        switchobscur = findViewById(R.id.darkswitch);
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
                String nombretext = operand.getText().toString(); // Agafa el text que hi ha a la textView i donali la variable string nombretext (únicament per a botoresta)
                if (!primernombre.equals("") && !nombretext.equals("") && !signe.equals("")){
                    String input = "";
                    if (signe.equals("+")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) + Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) + Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("-")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) - Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) - Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("*")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) * Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) * Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("/")){
                        resultat = Double.parseDouble(primernombre) / Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        primernombre = resultatstring;
                        operand.setText(input);
                    }
                }
                else {
                    primernombre = operand.getText().toString();
                    operand.setText("");
                    signe = ("+");
                }
            }
        });

        botoresta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nombretext = operand.getText().toString(); // Agafa el text que hi ha a la textView i donali la variable string nombretext (únicament per a botoresta)
                if (!primernombre.equals("") && !signe.equals("") && !nombretext.equals("")){ // Nombre negatiu al primer nombre, al iniciar. Exemple " -6 + 3 "
                    String input = operand.getText().toString();
                    input = input + "-";
                    operand.setText(input);
                }
                if (!primernombre.equals("") && !nombretext.equals("") && !signe.equals("")){ // Nombre negatiu al segon nombre . Exemple : "6 + (-6)"
                    String input = operand.getText().toString();
                    input = input + "-";
                    operand.setText(input);
                }
                if (!primernombre.equals("") && !nombretext.equals("") && !signe.equals("")){
                    String input = "";
                    if (signe.equals("+")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) + Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) + Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("-")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) - Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) - Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("*")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) * Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) * Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("/")){
                        resultat = Double.parseDouble(primernombre) / Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        primernombre = resultatstring;
                        operand.setText(input);
                    }
                }
                else { // Resta normal, cap nombre negatiu
                    primernombre = operand.getText().toString();
                    operand.setText("");
                    signe = ("-");
                }
            }
        });

        botompultiplicacio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nombretext = operand.getText().toString(); // Agafa el text que hi ha a la textView i donali la variable string nombretext (únicament per a botoresta)
                if (!primernombre.equals("") && !nombretext.equals("") && !signe.equals("")){
                    String input = "";
                    if (signe.equals("+")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) + Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) + Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("-")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) - Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) - Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("*")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) * Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) * Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("/")){
                        resultat = Double.parseDouble(primernombre) / Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        primernombre = resultatstring;
                        operand.setText(input);
                    }
                }
                else {
                    primernombre = operand.getText().toString();
                    operand.setText("");
                    signe = ("*");
                }
            }
        });

        botodivisio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nombretext = operand.getText().toString(); // Agafa el text que hi ha a la textView i donali la variable string nombretext (únicament per a botoresta)
                if (!primernombre.equals("") && !nombretext.equals("") && !signe.equals("")){
                    String input = "";
                    if (signe.equals("+")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) + Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) + Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("-")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) - Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) - Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("*")){
                        if (coma){
                            resultat = Double.parseDouble(primernombre) * Double.parseDouble(operand.getText().toString());
                            resultatstring = String.valueOf(resultat);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                        else {
                            resultatint = Integer.parseInt(primernombre) * Integer.parseInt(operand.getText().toString());
                            resultatstring = String.valueOf(resultatint);
                            primernombre = resultatstring;
                            operand.setText(input);
                        }
                    }
                    if (signe.equals("/")){
                        resultat = Double.parseDouble(primernombre) / Double.parseDouble(operand.getText().toString());
                        resultatstring = String.valueOf(resultat);
                        primernombre = resultatstring;
                        operand.setText(input);
                    }
                }
                else {
                    primernombre = operand.getText().toString();
                    operand.setText("");
                    signe = ("/");
                }
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
                if (signe.equals("+")){
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
                }
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
        builder.create().show(); // Crea el missatge i mostra'l
    }
}