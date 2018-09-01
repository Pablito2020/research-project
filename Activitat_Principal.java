/*
Aplicació creada per Pablo Fraile Alonso
Tota l'aplicació està sobre la llicència gnu, en cas de que cap usuari vulgui
utilitzar el codi de l'aplicació, té que respectar la llicència.
 */

package com.ordinador.pablo.calculadora;

// Imports directes d'Android Studio
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Importa les classes necessàries per a poder fer funcionar la calculadora:
import android.view.View;

// Importa la classe per a els botons de la calculadora
import android.widget.Button;

// Importa la classe per a que el usuari pugui afegir o modificar text
import android.widget.EditText;

// Importa la elecció de Botons ( Multiplicar, dividir, sumar o restar)
import android.widget.RadioButton;
import android.widget.RadioGroup;

// Importa la classe per a mostrar text al usuari
import android.widget.TextView;


// Activitat Principal ( MainActivity)
public class Activitat_Principal extends AppCompatActivity {
    private TextView result;
    private EditText input1;
    private EditText input2;
    private Button Equals;
    private RadioGroup radioOpGroup;
    private RadioButton btndisplay;
    double num1;
    double num2;
    double op;

    @Override
    // Línees afegides automàticament per Android Studio, mostren la Avtivity_Principal al usuari.
    // Aquesta Activity Principal estarà modificada per a la calculadora, però de moment, sol hi haurà una, la ja afegida per Android Studio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat__principal);


        input1=(EditText)findViewById(R.id.editText2);
        input2=(EditText)findViewById(R.id.editText3);
        Equals=(Button)findViewById(R.id.equals);
        radioOpGroup=(RadioGroup)findViewById(R.id.radioGroup);
        result=(TextView)findViewById(R.id.res);
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == Equals) {
                    num1=Double.parseDouble(input1.getText().toString());
                    num2=Double.parseDouble(input2.getText().toString());
                    int selected=radioOpGroup.getCheckedRadioButtonId();
                    btndisplay=(RadioButton)findViewById(selected);
                    if(btndisplay.getText().toString().equals("Plus"))
                        op=num1+num2;
                    else if(btndisplay.getText().toString().equals("Minus"))
                        op=num1-num2;
                    else if(btndisplay.getText().toString().equals("Multiply"))
                        op=num1*num2;
                    else if(btndisplay.getText().toString().equals("Divide"))
                        op=num1/num2;
                    result.setText(Double.toString(op));
                    }

                }
            });
    }
    }

