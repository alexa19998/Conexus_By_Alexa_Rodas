package com.example.conexus.Facebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.conexus.Instagram.MenuAprenderInstagram;
import com.example.conexus.Instagram.PantallaNivel2Instagram;
import com.example.conexus.R;

public class PantallaNivel2Facebook extends AppCompatActivity {

    //creacion de las variables
    ImageButton buttonBuscar;
    ImageButton buttonNotificaciones;
    ImageButton buttonPensando;
    ImageButton buttonHistoriasFace;
    ImageButton buttonPublicacionFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_nivel2_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        buttonBuscar= findViewById(R.id.imageButtonbuscar);
        buttonNotificaciones = findViewById(R.id.imageButtonnotificaciones);
        buttonPensando = findViewById(R.id.imageButtonpensando);
        buttonHistoriasFace = findViewById(R.id.imageButtonhistoriaspantalla);
        buttonPublicacionFace = findViewById(R.id.imageButtonpublicacionface);

        //Le asignamos al boton buscar un dialogo, para que salga la explicacion para cuando le des
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Facebook.this);
                pantallaFinal.setTitle("Barra Principal");
                pantallaFinal.setMessage("Aqui esta situado el titulo de la aplicacion. \nSi le das a la lupa, puedes buscar paginas y personas, si le das al bocadillo, te llevara a la sección de mensajes de Facebook.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton notificaciones un dialogo, para que salga la explicacion para cuando le des
        buttonNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Facebook.this);
                pantallaFinal.setTitle("Barra de Notificaciones");
                pantallaFinal.setMessage("Aqui si le das a: \n*La casa: Te lleva al menu principal, el home. \n*Las siluetas:Te enseña las solicitudes de amistad que tienes. \n*La TV: Ves todas las personas que se encuentran en directo ahora mismo. \n*La tienda: Es una tienda de ropa y cosas, donde los usuarios ponen cosas en venta. \n*La campana: Tienes tus notificaciones, desde likes a comentarios etc. \n*Tres rayas: Tienes opciones de tu perfil.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton pensando un dialogo, para que salga la explicacion para cuando le des
        buttonPensando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Facebook.this);
                pantallaFinal.setTitle("Barra Post Perfil");
                pantallaFinal.setMessage("Aqui tienes varias opciones: \n*En que estas pensando: Puedes compartir una frase, o un texto en tu perfil. \n*En directo: Puedes iniciar un directo, para que lo vean o se unan tus amigos. \n*En foto: Puedes subir una foto, video o album de tu galeria a tu perfil. \n*En sala: Puedes invitar a todos los amigos que quieras a una videollamada grupal.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton Historias un dialogo, para que salga la explicacion para cuando le des
        buttonHistoriasFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Facebook.this);
                pantallaFinal.setTitle("Barra de Historias");
                pantallaFinal.setMessage("Este es el visor de historias. \nAqui puedes visualizar las historias de las personas que sigues y si le das a tu foto, puedes ver tus historias subidas, o subir una nueva.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton Publicaciones un dialogo, para que salga la explicacion para cuando le des
        buttonPublicacionFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Facebook.this);
                pantallaFinal.setTitle("Publicación");
                pantallaFinal.setMessage("Aqui esta situadas las publicaciones \nSi le das a los tres puntos puedes eliminarla si es tuya o denuncairla si es de otro, puedes poner un texto o famosamente llamado caption, y seguido aparecera lo que hayas puesto, sea una imagen o algo.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase Menu Aprender Facebook
    public void EmpezarMenuAprenderFacebook(View v){

        Intent i =new Intent(this, MenuAprenderFacebook.class);
        startActivity(i);
    }
}