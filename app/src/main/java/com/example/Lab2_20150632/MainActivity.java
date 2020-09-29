package com.example.Lab2_20150632;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void obtenerCampoEdit (View view){
        EditText nom = findViewById(R.id.nombre);
        String nombre = nom.getText().toString();

        EditText appellido = findViewById(R.id.apellido);
        String apellido2 = appellido.getText().toString();

        EditText cod = findViewById(R.id.codigo);
        String cod2 = cod.getText().toString();
        try{
            int cod3 = Integer.parseInt(cod2);
            if(cod3<20120000||cod3>20179999){
                cod.setError("Debe ingresar un Código válido");
            }
        }catch (NumberFormatException e){
            System.out.println("ERROR CON COD3");
        }

        EditText contra1 = findViewById(R.id.contra);
        String contra2 = contra1.getText().toString();

        EditText dni = findViewById(R.id.dni);
        String dni2 = dni.getText().toString();
        try{
            int dni3 = Integer.parseInt(dni2);
            if(dni3<9999999||dni3>99999999){
                dni.setError("Debe ingresar un DNI válido");
            }
        }catch (NumberFormatException e){
            System.out.println("ERROR CON COD3");
        }

        EditText espe = findViewById(R.id.espe);
        String espe2 = espe.getText().toString();

        reg:
        while(true){
            if(!contra2.equals("S3cr3t306")||nombre.isEmpty()||apellido2.isEmpty()||cod2.isEmpty()||contra2.isEmpty()||espe2.isEmpty()||dni2.isEmpty()) {

                if(nombre.isEmpty()) {
                    nom.setError("Debe ingresar un nombre");
                }
                if(cod2.isEmpty()){
                    cod.setError("Debe ingresar un Código");
                }
                if(apellido2.isEmpty()){
                    appellido.setError("Debe ingresar un apellido");
                }
                if(contra2.isEmpty()){
                    contra1.setError("Debe ingresar una contraseña");
                }
                if(espe2.isEmpty()){
                    espe.setError("Debe ingresar una Especialidad");
                }
                if(dni2.isEmpty()){
                    dni.setError("Debe ingresar un DNI");
                }
                if(!contra2.equals("S3cr3t306")){
                    contra1.setError("Debe ingresar la clave secreta");
                }
                break;
            }else{
                    Intent intent = new Intent(MainActivity.this,TareasPendientes.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellido", apellido2);
                    intent.putExtra("carrera", espe2);
                    intent.putExtra("codigo", cod2);
                    intent.putExtra("dni", dni2);
                    startActivity(intent);
                    Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();
                    break reg;
            }
        }



    }
}