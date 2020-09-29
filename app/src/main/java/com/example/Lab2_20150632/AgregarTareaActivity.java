package com.example.Lab2_20150632;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

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

        ArrayList<String> lista = intent.getStringArrayListExtra("lista");

        Button agregar = findViewById(R.id.button2);
        agregar.setTag(lista);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                EditText tarea = findViewById(R.id.nuevaTarea);
                String aux=tarea.getText().toString();
                if(aux.isEmpty())
                {
                    tarea.setError("No puede estar vacio");
                }
                else
                {
                    ArrayList<String> lista = (ArrayList<String>) view.getTag();
                    boolean repetido = false;
                    for (String i:lista)
                    {
                        if (i.equals(aux)) repetido=true;
                    }
                    if(repetido)
                    {
                        tarea.setError("ya existe esa tarea");
                    }
                    else
                    {
                        intent.putExtra("tarea", aux);
                        setResult(RESULT_OK, intent);
                        finish();
                    }


                }

            }
        });



    }
}