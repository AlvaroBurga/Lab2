package com.example.Lab2_20150632;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        Button agregar = findViewById(R.id.button2);
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
                    intent.putExtra("tarea", aux);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });



    }
}