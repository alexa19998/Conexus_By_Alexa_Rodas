package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.R;

public class MenuAprenderInstagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aprender_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase Nivel1Instagram
    public void EmpezarNivel1Instagram(View v){

        Intent i =new Intent(this, Nivel1Instagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase Nivel2Instagram
    public void EmpezarNivel2Instagram(View v){

        Intent i =new Intent(this, Nivel2Instagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase PrimeraPantallaInstagram
    public void EmpezarAtras(View v){

        Intent i =new Intent(this, PrimeraPantallaInstagram.class);
        startActivity(i);
    }
}