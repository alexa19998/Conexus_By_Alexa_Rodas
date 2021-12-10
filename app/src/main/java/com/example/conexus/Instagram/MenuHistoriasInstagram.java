package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.R;

public class MenuHistoriasInstagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_historias_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase UtilidadHistoriasInstagram
    public void EmpezarUtilidadHistoriasInstagram(View v){

        Intent i =new Intent(this, UtilidadHistoriasInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase EmpezarComponentesBasicosInstagram
    public void EmpezarComponentesBasicosInstagram(View v){

        Intent i =new Intent(this, ComponentesHistoriasInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase EmpezarCreacionHistoriasInstagram
    public void EmpezarCreacionHistoriasInstagram(View v){

        Intent i =new Intent(this, CreacionHistoriasInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase DiferenciadorHistoriasInstagram
    public void EmpezarDiferenciadorHistoriasInstagram(View v){

        Intent i =new Intent(this, DiferenciadorHistoriasInstagram.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase PrimeraPantallaInstagram
    public void EmpezarPrimeraPantallaInstagram2(View v){

        Intent i =new Intent(this, PrimeraPantallaInstagram.class);
        startActivity(i);
    }

}