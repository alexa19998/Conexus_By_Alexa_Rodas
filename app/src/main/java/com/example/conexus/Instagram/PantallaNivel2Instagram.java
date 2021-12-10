package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.conexus.Facebook.MenuAprenderFacebook;
import com.example.conexus.Facebook.UtilidadHistoriasFacebook;
import com.example.conexus.R;

public class PantallaNivel2Instagram extends AppCompatActivity {

    //creacion de las variables
    ImageButton buttonMensajes;
    ImageButton buttonHistorias;
    ImageButton buttonOpciones;
    ImageButton buttonPublicacion;
    ImageButton buttonInteraccionesPublicacion;
    ImageButton buttonCaption;
    ImageButton buttonMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_nivel2_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        buttonMensajes = findViewById(R.id.imageButtonMensajes);
        buttonHistorias = findViewById(R.id.imageButtonHistorias);
        buttonOpciones = findViewById(R.id.imageButtonopciones);
        buttonPublicacion = findViewById(R.id.imageButtonpublicacion);
        buttonInteraccionesPublicacion = findViewById(R.id.imageButtoninteraccionespublicacion);
        buttonCaption = findViewById(R.id.imageButtonCaption);
        buttonMenuPrincipal = findViewById(R.id.imageButtonMenuPrincipal);

        //Le asignamos al boton mensajes un dialogo, para que salga la explicacion para cuando le des
        buttonMensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Barra Principal");
                pantallaFinal.setMessage("Aqui esta situado el titulo de la aplicacion. \nSi le das al avioncito de papel, te lleva a tus mensajes.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton historias un dialogo, para que salga la explicacion para cuando le des
        buttonHistorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Barra Historias");
                pantallaFinal.setMessage("Este es el visor de historias. \nAqui puedes visualizar las historias de las personas que sigues y si le das a tu foto, puedes ver tus historias subidas, o subir una nueva.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton opciones un dialogo, para que salga la explicacion para cuando le des
        buttonOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Opciones de Publicación");
                pantallaFinal.setMessage("Aqui estan situadas las opciones de la publicacion. \nDependiendo de si es tuya o de otra persona la publicacion, puedes hacer unas cosas u otras, entre ellas, denunciar, ocultar, si es de otra persona, y eliminar, archivar, si es tuya.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton publicacion un dialogo, para que salga la explicacion para cuando le des
        buttonPublicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Publicación");
                pantallaFinal.setMessage("Aqui visualizas la foto. \nTanto si es tuya o si es de alguien mas, si das click al nombre, te llevara a su perfil.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton interacciones un dialogo, para que salga la explicacion para cuando le des
        buttonInteraccionesPublicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Barra de Interacciones");
                pantallaFinal.setMessage("Es una barra situada debajo de las publicaciones. \nAqui si le das al:\n*Corazón: Das like a la publicación.\n*Bocadillo: Te deja escribir comentarios.\n*Avioncito de papel: Puedes enviar la publicacion como mensaje a alguien más.\n*Etiqueta:Puedes guardar la publicación para verla despues, o simplemente para guardarla.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton caption un dialogo, para que salga la explicacion para cuando le des
        buttonCaption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Caption de publicación");
                pantallaFinal.setMessage("Aqui esta el caption de la publicación, es una frase o escrito que puedes poner relativo a la imagen, tambien puedes ver las personas que le dieron like, y su numero, y más abajo puedes ver los comentarios.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

        //Le asignamos al boton Menu principal un dialogo, para que salga la explicacion para cuando le des
        buttonMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(PantallaNivel2Instagram.this);
                pantallaFinal.setTitle("Barra Menu Principal");
                pantallaFinal.setMessage("Este es el menu principal. \nAqui si le das a:\n*La casa: Te lleva al home de la aplicación.\n*La lupa:Te enseña sugerencias de cuentas basadas en tus gustos, o te deja buscar personas o cosas especificas.\n*Simbolo '+': Es para escoger una imagen o video para publicar.\n*El corazón: Aqui estan reflejadas tus notificaciones, cometarios, likes etc.\n*Icono o foto: Aqui vas a tu perfil y visualizas todo tu contenido.");
                pantallaFinal.setPositiveButton("OK", null);
                pantallaFinal.create();
                pantallaFinal.show();
            }
        });

    }
    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase Menu Aprender Instagram
    public void EmpezarMenuAprenderInstagram(View v){

        Intent i =new Intent(this, MenuAprenderInstagram.class);
        startActivity(i);
    }
}