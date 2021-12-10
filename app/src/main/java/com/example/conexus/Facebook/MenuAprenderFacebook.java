package com.example.conexus.Facebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.Instagram.Nivel1Instagram;
import com.example.conexus.Instagram.Nivel2Instagram;
import com.example.conexus.Instagram.PrimeraPantallaInstagram;
import com.example.conexus.R;

public class MenuAprenderFacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aprender_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase Nivel1Facebook
    public void EmpezarNivel1Facebook(View v){

        Intent i =new Intent(this, Nivel1Facebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase Nivel2Facebook
    public void EmpezarNivel2Facebook(View v){

        Intent i =new Intent(this, Nivel2Facebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase PrimeraPantallaFacebook
        public void EmpezarAtrasFacebook(View v){

        Intent i =new Intent(this, PrimeraPantallaFacebook.class);
        startActivity(i);
    }
}