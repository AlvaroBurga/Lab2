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
        //PRIMERO
        super.onCreate(savedInstanceState);


        final Intent intent = getIntent();
        final String carrera = intent.getStringExtra("carrera");
        /*
        Button button = findViewById(R.id.regSesion);
        Button button1 = findViewById(R.id.add2do);
        button.setBackgroundColor(0xFF009688);
        button1.setBackgroundColor(0xFF009688);
        */
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

        //SEGUNDO
        this.setContentView(R.layout.activity_tareas_pendientes);
        final String nombre = intent.getStringExtra("nombre");
        TextView textView = findViewById(R.id.BienvenidoNombre);
        textView.setText("Bienvenido "+ nombre);

        ImageView mascota = findViewById(R.id.mascota);


        if(carrera.equalsIgnoreCase("Telecomunicaciones"))
        {
            mascota.setImageResource(R.drawable.telito);
        }
        else if(carrera.equalsIgnoreCase("Electronica"))
        {
            mascota.setImageResource(R.drawable.electro);
        }
        else
        {
            mascota.setImageResource(R.drawable.benderv3);
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
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

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