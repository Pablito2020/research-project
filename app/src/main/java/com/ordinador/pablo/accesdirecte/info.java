package com.ordinador.pablo.accesdirecte;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;

public class info extends Activitat_Principal {

    // Métode per a no mostrar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    // Métode principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.info);
        setContentView(R.layout.info);
    }
}
