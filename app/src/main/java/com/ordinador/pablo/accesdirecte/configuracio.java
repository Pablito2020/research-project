package com.ordinador.pablo.accesdirecte;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class configuracio extends Activitat_Principal {

    public void guardadadesrosa(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 1);
        editor.apply();
    }
    public void guardadadesblau(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 2);
        editor.apply();
    }
    public void guardadadesgris(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 3);
        editor.apply();
    }
    public void guardadescyan(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 4);
        editor.apply();
    }
    public void guardadesverd(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 5);
        editor.apply();
    }
    public void guardadestaronja(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, 6);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargadades();
        if (text == 1){
            setTheme(R.style.AppTheme);
        }
        if (text == 2){
            setTheme(R.style.TemaBlau);
        }
        if (text == 3){
            setTheme(R.style.TemaGris);
        }
        if (text == 4){
            setTheme(R.style.TemaCyan);
        }
        if (text == 5){
            setTheme(R.style.TemaVerd);
        }
        if (text == 6){
            setTheme(R.style.TemaTaronja);
        }
        super.onCreate(savedInstanceState);
        setTitle(R.string.configuracio);
        setContentView(R.layout.configuracio);

        Button botoblau;
        botoblau = findViewById(R.id.btblau);
        Button botorosa;
        botorosa = findViewById(R.id.btrosa);
        Button botogris;
        botogris = findViewById(R.id.btgris);
        Button botocyan;
        botocyan = findViewById(R.id.btcyan);
        Button botoverd;
        botoverd = findViewById(R.id.btverd);
        Button bototaronja;
        bototaronja=findViewById(R.id.bttaronja);

        botorosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadadesrosa();
                reinicia();
            }
        });
        botoblau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadadesblau();
                reinicia();
            }
        });
        botogris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadadesgris();
                reinicia();
            }
        });
        botocyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadescyan();
                reinicia();
            }
        });
        botoverd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadesverd();
                reinicia();
            }
        });
        bototaronja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadestaronja();
                reinicia();
            }
        });

    }

    // Métode necessari per a reiniciar la Activity
    public void reinicia(){
        Intent i = new Intent (this, configuracio.class);
        startActivity(i);
    }
}