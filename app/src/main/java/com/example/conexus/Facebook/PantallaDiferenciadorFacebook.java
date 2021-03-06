package com.example.conexus.Facebook;

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

import com.example.conexus.Instagram.PrimeraPantallaInstagram;
import com.example.conexus.Pregunta;
import com.example.conexus.R;

public class PantallaDiferenciadorFacebook extends AppCompatActivity {
    //Crear un final con la cantidad de pantallas que necesitamos
    static final int NPREGUNTAS = 5;
    //Crear un array con la clase que contiene los atributos, y pasarle el final con la cantidad de preguntas
    private Pregunta[] preguntas = new Pregunta[NPREGUNTAS];
    //contador de las visualizaciones
    private int preguntaEnCurso = 0;

    //creacion de las variables y creamos contador de preguntas correctas y incorrectas
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
        setContentView(R.layout.activity_pantalla_diferenciador_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView = (ImageView) findViewById(R.id.imageView46);
        pregunta = findViewById(R.id.tvEnunciado10);
        res1 = findViewById(R.id.rb1);
        res2 = findViewById(R.id.rb2);
        res3 = findViewById(R.id.rb3);
        siguiente = findViewById(R.id.btnSiguiente10);
        reiniciar = findViewById(R.id.buttonReiniciar10);

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

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase HistoriasFacebook
    public void reiniciarApp() {
        Intent intent = new Intent(this, MenuHistoriasFacebook.class);
        startActivity(intent);
    }

    //Metodo el cual carga los atributos que contiene el objeto Preguntas, con el total que creamos en el final
    public void cargarPreguntas() {

        preguntas[0] = new Pregunta(R.drawable.textoface, "??Si quieres poner texto en la historia como lo har??as?", "Dando click en cualquier sitio", "Despu??s de hacer la historia le das click al bot??n de texto", "No se puede poner texto", 2);
        preguntas[1] = new Pregunta(R.drawable.musicaface, "??C??mo pones m??sica?", "Despu??s de hacer la historia, en la parte de arriba le das a el sticker, y te saldr??n opciones como poner m??sica.", "Despu??s de hacer la historia hay una etiqueta que pone m??sica abajo.", "No se puede poner m??sica", 2);
        preguntas[2] = new Pregunta(R.drawable.gifface, "??C??mo poner gif???s?", "No se pueden poner gif", "Con una etiqueta que sale abajo despu??s de hacer la historia", "Deslizando desde abajo despu??s de hacer la historia entre otras muchas otras opciones sale", 3);
        preguntas[3] = new Pregunta(R.drawable.filtrosfinalesface, "??C??mo puedes puedes poner filtros despu??s de haber hecho la historia?", "Deslizando a la derecha hasta que me guste", "No se puede puede poner filtros despu??s de hecha la historia", "No tiene opci??n de filtros nunca", 1);
        preguntas[4] = new Pregunta(R.drawable.collageface, "??D??nde tienes la opci??n de hacer un collage?", "No se puede hacer collage???s en facebook", "Antes de hacer la historia en la barra lateral izquierda", "Solo se puede hacer despu??s de hacer la historia", 1);
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
            // El usuario no seleccion?? ninguna respuesta
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
            // Si se llega al final del test, se desactiva el bot??n siguiente
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

        // Muestra el n??mero de respuestas correctas al finalizar el test

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

        reiniciar.setEnabled(true);


    }

}