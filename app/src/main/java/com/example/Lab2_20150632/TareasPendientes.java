package com.example.Lab2_20150632;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
                startActivity(intent1);
            }
        });
        add2do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TareasPendientes.this, AgregarTareaActivity.class);
                intent2.putExtra("carrera", carrera);
                int requestcode =1;
                startActivityForResult(intent2,requestcode);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK)
        {
            String tarea = data.getStringExtra("tarea");
            CheckBox elemento = new CheckBox(this);
            elemento.setGravity(Gravity.CENTER_VERTICAL);
            elemento.setText(tarea);
            Toast toast = Toast.makeText(getApplicationContext(),"El tecto es: "+ elemento.getText(),Toast.LENGTH_SHORT);
            LinearLayout layout = findViewById(R.id.lista);
            layout.addView(elemento);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
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

        for (int i=1; i< lista.getChildCount();i++)
        {
            CheckBox cb =(CheckBox) lista.getChildAt(i);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckBox cb =  (CheckBox) view;
                    if (cb.isChecked())
                    {
                        LinearLayout lista = findViewById(R.id.lista);
                        lista.removeView(cb);
                    }
                }
            });
            if(cb.isChecked())
            {
                lista.removeView(cb);
            }
        }

    }
}