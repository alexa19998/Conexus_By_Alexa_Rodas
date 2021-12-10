package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.MenuPrincipal;
import com.example.conexus.R;

public class PrimeraPantallaInstagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase MenuAprenderInstagram
    public void MenuAprenderInstagram(View v){

        Intent i =new Intent(this, MenuAprenderInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase TestInstagram
    public void JugarInstagram(View v){

        Intent i =new Intent(this, TestInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase MenuHistoriasInstagram
    public void MenuHistoriasInstagram(View v){

        Intent i =new Intent(this, MenuHistoriasInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase MenuPrincipalInstagram
    public void MenuPrincipalInstagram(View v){

        Intent i =new Intent(this, MenuPrincipal.class);
        startActivity(i);
    }


}