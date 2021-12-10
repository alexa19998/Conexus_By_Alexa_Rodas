package com.example.conexus.Facebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conexus.Instagram.PrimeraPantallaInstagram;
import com.example.conexus.R;
import com.example.conexus.Visualizador;

public class Pantalla1CreacionHistoriasFacebook extends AppCompatActivity {
    //Crear un final con la cantidad de pantallas que necesitamos
    static final int NVISUALIZACIONES = 4;
    //Crear un array con la clase que contiene los atributos, y pasarle el final con la cantidad de visualizaciones
    private Visualizador[] visualizaciones = new Visualizador[NVISUALIZACIONES];
    //contador de las visualizaciones
    private int visualizacionEnCurso = 0;

    //creacion de las variables
    Button btnCamara;
    ImageView imageViewFoto;
    ImageView imageView;
    TextView titulo;

    Button siguiente;
    Button reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1_creacion_historias_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        btnCamara = findViewById(R.id.buttonCamara2);
        imageViewFoto = findViewById(R.id.imageView51);
        imageView=(ImageView)findViewById(R.id.imageView52);
        titulo = findViewById(R.id.titulo8);
        siguiente = findViewById(R.id.btnSiguiente12);
        reiniciar = findViewById(R.id.buttonReiniciar12);


        //Le asignamos al boton camara que al darle click ejecute el metodo abrirCamara()
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirCamara();
            }
        });

        //Le asignamos al boton menu Historias, que llame al metodo reiniciarApp()
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarApp();
            }
        });

        //que al iniciar este modo, el boton menu de historias este desactivado
        reiniciar.setEnabled(false);
        //Llamar los metodos
        cargarVisualizaciones();
        mostrarEnunciadoEnCurso();
    }

    //Metodo mostrarEnunciadoEnCurso
    private void mostrarEnunciadoEnCurso() {

        //Crea dos objetos y asigna el respectivo titulo y enunciado y lo muestra
        Visualizador pantallaActual = visualizaciones[visualizacionEnCurso];
        imageView.setImageResource(pantallaActual.getImagen());
        Visualizador preguntaActual = visualizaciones[visualizacionEnCurso];
        titulo.setText(preguntaActual.getTitulo());
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase MenuHistorasFacebook
    public void reiniciarApp() {
        Intent intent = new Intent(this, MenuHistoriasFacebook.class);
        startActivity(intent);
    }


    //Metodo el cual carga los atributos que contiene el objeto Visualizador, con el total que creamos en el final
    public void cargarVisualizaciones() {

        visualizaciones[0] = new Visualizador(R.drawable.fotocieloface,"Foto del cielo, da igual la hora ");
        visualizaciones[1] = new Visualizador(R.drawable.fotoespejoface, "Tipica foto frente al espejo");
        visualizaciones[2] = new Visualizador(R.drawable.fotocomidaface,"Foto de comida, para dar envidia");
        visualizaciones[3] = new Visualizador(R.drawable.deporteface,"Foto actividad cotidiana(trabajo, deporte..)");
    }

    public void Siguiente(View v) {

        // Cuando se pasa a la siguienye pregunta, se valida la respuesta de la pregunta actual
        // Pasa a la siguiente pregunta
        visualizacionEnCurso++;
        if (visualizacionEnCurso< NVISUALIZACIONES) {
            //reinicia los radio button a vacios
            imageViewFoto.setImageResource(R.drawable.polaroidcamara);
            mostrarEnunciadoEnCurso();

        } else {
            // Si se llega al final del test, se desactiva el botón siguiente
            siguiente.setEnabled(false);
            mostrarFinal();
        }


    }

    public void mostrarFinal() {

        // Muestra un mensaje con el final de la seccion
        AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(this);
        pantallaFinal.setTitle("Final Creación Historias");
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado el Creador de Historias de Facebook");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //desactiva el boton de la camara y activa el de menu historias
        btnCamara.setEnabled(false);
        reiniciar.setEnabled(true);


    }

    //metodos para abrir la camara
    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){

            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imageViewFoto.setImageBitmap(imgBitmap);
        }
    }
}