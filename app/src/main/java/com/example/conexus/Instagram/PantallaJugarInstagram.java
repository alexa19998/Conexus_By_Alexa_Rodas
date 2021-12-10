package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conexus.Pregunta;
import com.example.conexus.R;

public class PantallaJugarInstagram extends AppCompatActivity {

    //Crear un final con la cantidad de pantallas que necesitamos
    static final int NPREGUNTAS = 7;
    //Crear un array con la clase que contiene los atributos, y pasarle el final con la cantidad de preguntas
    private Pregunta[] preguntas = new Pregunta[NPREGUNTAS];
    //contador de las visualizaciones
    private int preguntaEnCurso = 0;

    //creacion de las variables y contadires de las respuestas correctas y incorrectas
    ImageView imageView;
    TextView pregunta;
    RadioButton res1, res2, res3;
    Button siguiente;
    Button reiniciar;
    int resBuenas = 0;
    int resMalas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_jugar_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView = (ImageView) findViewById(R.id.imageView26);
        pregunta = findViewById(R.id.tvEnunciado3);
        res1 = findViewById(R.id.rb1);
        res2 = findViewById(R.id.rb2);
        res3 = findViewById(R.id.rb3);
        siguiente = findViewById(R.id.btnSiguiente3);
        reiniciar = findViewById(R.id.buttonReiniciar3);

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
        cargarPreguntas();
        mostrarPreguntaEnCurso();
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase PrimeraPantallaInstagram
    public void reiniciarApp() {
        Intent intent = new Intent(this, PrimeraPantallaInstagram.class);
        startActivity(intent);
    }

    //Metodo el cual carga los atributos que contiene el objeto Pregunta, con el total que creamos en el final
    public void cargarPreguntas() {

        preguntas[0] = new Pregunta(R.drawable.subirpublicacion, "¿Para subir una publicacion que icono escogerías?", "A el + encerrado un cuadrado", "A el corazon de la esquina superior derecha", "A la casa de la esquina inferior izquierda", 1);
        preguntas[1] = new Pregunta(R.drawable.porqueutilizar, "¿Instagram es de pago?", "Si", "No", "Parcialmente", 2);
        preguntas[2] = new Pregunta(R.drawable.usuarios, "¿Que usuarios predominan?", "Personas de la tercera edad", "Niños", "Adolescentes", 3);
        preguntas[3] = new Pregunta(R.drawable.comentarios, "¿Para escribir un comentario en una apliacion, que icono escogerías?", "A el avioncito de la esquina superior derecha", "A el bocadillo que hay debajo de las publicaciones", "A el corazon de la esquina superior derecha", 2);
        preguntas[4] = new Pregunta(R.drawable.mensajes, "¿Para mandar un mensaje que icono escogerías?", "A la casa de la esquina inferior izquierda", "A el corazon de la esquina superior derecha", "A el avioncito de la esquina superior derecha", 3);
        preguntas[5] = new Pregunta(R.drawable.personapensando, "¿Qué es instagram?", "Es una red social y una aplicación móvil al mismo tiempo, que permite a sus usuarios subir imágenes y vídeos con múltiples efectos fotográficos como filtros.", "Es una aplicación de cocina con múltiples herramientas y recetas", "Es una red social de animales, donde creas perfil a tu mascota y interactuas con otras mascotas.", 1);
        preguntas[6] = new Pregunta(R.drawable.guardado, "¿Para guardar una publicación en la zona de guardado, a que icono le darías?","Una especie de etiqueta que esta en la esquina inferior derecha de las publicaciones", "A el corazon de la esquina superior derecha", "A la casa de la esquina inferior izquierda", 1);
    }


    public void validarRespuesta() {


        // Obtiene la respuesta seleccionada por el usuario
        int resSelect;

        if (res1.isChecked()) {
            resSelect = 1;
        } else if (res2.isChecked()) {
            resSelect = 2;
        } else if (res3.isChecked()) {
            resSelect = 3;
        } else {
            // El usuario no seleccionó ninguna respuesta
            resSelect = 0;
        }

        // Registra las respuestas correctas, incorrectas y sin contestar
        if (preguntas[preguntaEnCurso].getCorrecta() == resSelect) {
            resBuenas++;
            Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
        } else {
            if (preguntas[preguntaEnCurso].getCorrecta() != resSelect) {
                resMalas++;
                Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();

            }
        }


        // Pasa a la siguiente pregunta
        preguntaEnCurso++;
        if (preguntaEnCurso < NPREGUNTAS) {
            //reinicia los radio button a vacios.
            res1.setChecked(false);
            res2.setChecked(false);
            res3.setChecked(false);
            mostrarPreguntaEnCurso();
        } else {
            // Si se llega al final del test, se desactiva el botón siguiente
            siguiente.setEnabled(false);
            mostrarResultado();

        }
    }


    public void mostrarPreguntaEnCurso() {

        // Muestra la pregunta actual

        Pregunta preguntaActual = preguntas[preguntaEnCurso];


        imageView.setImageResource(preguntaActual.getImagen());
        pregunta.setText(preguntaActual.getEnunciado());
        res1.setText(preguntaActual.getRespuesta()[0]);
        res2.setText(preguntaActual.getRespuesta()[1]);
        res3.setText(preguntaActual.getRespuesta()[2]);

    }


    public void Siguiente(View v) {

        // Cuando se pasa a la siguienye pregunta, se valida la respuesta de la pregunta actual
        validarRespuesta();

    }


    public void mostrarResultado() {

        // Muestra el número de respuestas correctas al finalizar el test

        Toast resultado;
        String mensaje = "Respuestas correctas: " + resBuenas + "/" + NPREGUNTAS;
        resultado = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
        resultado.show();

        AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(this);
        pantallaFinal.setTitle("Conteo Final");
        pantallaFinal.setMessage("Respuestas correctas: " + resBuenas + "/" + NPREGUNTAS + "\nRespuestas incorrectas: " + resMalas + "/" + NPREGUNTAS);
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //activa el de menu historias
        reiniciar.setEnabled(true);


    }



}