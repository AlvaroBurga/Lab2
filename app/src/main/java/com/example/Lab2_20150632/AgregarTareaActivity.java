package com.example.Lab2_20150632;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AgregarTareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();
        final String carrera = intent.getStringExtra("carrera");

        if(carrera.equalsIgnoreCase("Telecomunicaciones"))
        {
            setTheme(R.style.Telecom);
        }
        else if(carrera.equalsIgnoreCase("Electronica"))
        {
            setTheme(R.style.Electronica);
        }
        else if(carrera.equalsIgnoreCase("Mecatronica"))
        {
            setTheme(R.style.Mecatronica);
        }

        setContentView(R.layout.agregar_tarea);




    }
}