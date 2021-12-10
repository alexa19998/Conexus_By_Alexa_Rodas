package com.example.conexus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.Facebook.PrimeraPantallaFacebook;
import com.example.conexus.Instagram.PrimeraPantallaInstagram;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase PrimeraPantallaInstagram
    public void EmpezarPrimeraPantallaInstagram(View v){

        Intent i =new Intent(this, PrimeraPantallaInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase PrimeraPantallaFacebook
    public void EmpezarPrimeraPantallaFacebook(View v){

        Intent i =new Intent(this, PrimeraPantallaFacebook.class);
        startActivity(i);
    }
}