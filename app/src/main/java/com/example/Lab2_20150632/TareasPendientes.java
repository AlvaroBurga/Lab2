package com.example.Lab2_20150632;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TareasPendientes extends AppCompatActivity {

    int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas_pendientes);

        ImageView mascota = findViewById(R.id.mascota);

        final Intent intent = getIntent();
        final String carrera = intent.getStringExtra("carrera");


        if(carrera.equalsIgnoreCase("Telecomunicaciones"))
        {
            mascota.setImageResource(R.drawable.telito);
            this.setTheme(R.style.Telecom);

        }
        else if(carrera.equalsIgnoreCase("Electronica"))
        {
            mascota.setImageResource(R.drawable.electro);
            this.setTheme(R.style.Electronica);
        }
        else
        {
            mascota.setImageResource(R.drawable.benderv3);
            this.setTheme(R.style.Mecatronica);
        }

        LinearLayout lista = findViewById(R.id.lista);
        TextView noHay = findViewById(R.id.NoHay);
        if (lista.getChildCount()==1)
        {
            noHay.setVisibility(View.VISIBLE);
        }
        else
        {
            noHay.setVisibility(View.GONE);


        }



        mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;
                if(cont==5)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Ha desbloqueado la opción obscura",Toast.LENGTH_SHORT);
                    //poner el estilo dark
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });

        Button regSesion = findViewById(R.id.regSesion);
        Button add2do = findViewById(R.id.add2do);

        regSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(TareasPendientes.this, MainActivity.class);
                intent.putExtra("carrera", carrera);
                startActivity(intent1);
            }
        });
        add2do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TareasPendientes.this, MainActivity.class);
                startActivity(intent2);
            }
        });


    }
}