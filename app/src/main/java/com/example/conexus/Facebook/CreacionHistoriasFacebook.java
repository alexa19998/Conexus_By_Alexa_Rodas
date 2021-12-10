package com.example.conexus.Facebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.Instagram.Pantalla1CreacionHistoriasInstagram;
import com.example.conexus.R;

public class CreacionHistoriasFacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_historias_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase Pantalla1CreacionHistoriasFacebook
    public void EmpezarPantallaCreacionHistoriasFacebook(View v){

        Intent i =new Intent(this, Pantalla1CreacionHistoriasFacebook.class);
        startActivity(i);
    }
}