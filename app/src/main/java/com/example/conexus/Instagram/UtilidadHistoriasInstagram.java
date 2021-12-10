package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.Facebook.PantallasNivel1Facebook;
import com.example.conexus.R;

public class UtilidadHistoriasInstagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilidad_historias_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase PantallasUtilidadHistoriasInstagram
    public void EmpezarPantallasUtilidadHistoriasInstagram(View v){

        Intent i =new Intent(this, PantallasUtilidadHistoriasInstagram.class);
        startActivity(i);
    }
}