package com.example.conexus.Facebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.conexus.Instagram.ComponentesHistoriasInstagram;
import com.example.conexus.Instagram.CreacionHistoriasInstagram;
import com.example.conexus.Instagram.DiferenciadorHistoriasInstagram;
import com.example.conexus.Instagram.PrimeraPantallaInstagram;
import com.example.conexus.Instagram.UtilidadHistoriasInstagram;
import com.example.conexus.R;

public class MenuHistoriasFacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_historias_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase UtilidadHistoriasFacebook
    public void EmpezarUtilidadHistoriasFacebook(View v){

        Intent i =new Intent(this, UtilidadHistoriasFacebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase ComponentesHistoriasFacebook
    public void EmpezarComponentesBasicosFacebook(View v){

        Intent i =new Intent(this, ComponentesHistoriasFacebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase CreacionHistoriasFacebook
    public void EmpezarCreacionHistoriasFacebook(View v){

        Intent i =new Intent(this, CreacionHistoriasFacebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase DiferenciadorHistoriasFacebook
    public void EmpezarDiferenciadorHistoriasFacebook(View v){

        Intent i =new Intent(this, DiferenciadorHistoriasFacebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity de la clase MenuAprenderFacebook
    public void EmpezarMenuAprenderFacebook(View v){

        Intent i =new Intent(this, MenuAprenderFacebook.class);
        startActivity(i);
    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase Primera PantallaFacebook
    public void EmpezarPrimeraPantallaFacebook2(View v){

        Intent i =new Intent(this, PrimeraPantallaFacebook.class);
        startActivity(i);
    }
}