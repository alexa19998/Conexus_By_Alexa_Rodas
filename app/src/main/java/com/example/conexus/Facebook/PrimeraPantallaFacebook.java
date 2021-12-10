package com.example.conexus.Facebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.Instagram.MenuHistoriasInstagram;
import com.example.conexus.Instagram.PrimeraPantallaInstagram;
import com.example.conexus.Instagram.TestInstagram;
import com.example.conexus.MenuPrincipal;
import com.example.conexus.R;

public class PrimeraPantallaFacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase MenuAprenderFacebook
    public void MenuAprenderFacebook(View v){

        Intent i =new Intent(this, MenuAprenderFacebook.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase TestFacebook
    public void JugarFacebook(View v){

        Intent i =new Intent(this, TestFacebook.class);
        startActivity(i);
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase MenuHistoriasFacebook
    public void MenuHistoriasFacebook(View v){

        Intent i =new Intent(this, MenuHistoriasFacebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase MenuPrincipal
    public void MenuPrincipalFacebook(View v){

        Intent i =new Intent(this, MenuPrincipal.class);
        startActivity(i);
    }
}