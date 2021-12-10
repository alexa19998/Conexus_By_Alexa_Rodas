package com.example.conexus.Instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conexus.R;
import com.example.conexus.Visualizador;

public class PantallaComponentesHistoriasInstagram extends AppCompatActivity {
    //Crear un final con la cantidad de pantallas que necesitamos
    static final int NVISUALIZACIONES = 7;
    //Crear un array con la clase que contiene los atributos, y pasarle el final con la cantidad de visualizaciones
    private Visualizador[] visualizaciones = new Visualizador[NVISUALIZACIONES];
    //contador de las visualizaciones
    private int visualizacionEnCurso = 0;

    //creacion de las variables
    ImageView imageView;
    TextView titulo;
    TextView enunciado;
    Button siguiente;
    Button reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_componentes_historias_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView=(ImageView)findViewById(R.id.imageView38);
        titulo = findViewById(R.id.titulo6);
        enunciado = findViewById(R.id.tvEnunciado8);
        siguiente = findViewById(R.id.btnSiguiente8);
        reiniciar = findViewById(R.id.buttonReiniciar8);
        enunciado.setMovementMethod(new ScrollingMovementMethod());

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

        //Crea dos objetos y asigna el respectivo titulo , enunciado, imagen y lo muestra
        Visualizador pantallaActual = visualizaciones[visualizacionEnCurso];
        imageView.setImageResource(pantallaActual.getImagen());
        Visualizador preguntaActual = visualizaciones[visualizacionEnCurso];
        titulo.setText(preguntaActual.getTitulo());
        enunciado.setText(preguntaActual.getEnunciado());
    }

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase HistoriasInstagram
    public void reiniciarApp() {
        Intent intent = new Intent(this, MenuHistoriasInstagram.class);
        startActivity(intent);
    }

    //Metodo el cual carga los atributos que contiene el objeto Visualizador, con el total que creamos en el final
    public void cargarVisualizaciones() {

        visualizaciones[0] = new Visualizador(R.drawable.pantallauno, "¿En qué zona puedes acceder para subir una historia?", "Puedes acceder de dos maneras, dándole click a la foto de tu perfil de la barra de historias o deslizando la pantalla para la izquierda.");
        visualizaciones[1] = new Visualizador(R.drawable.filtrosabajo, "¿En qué zona se encuentran los filtros?", "Hay dos formas de poner filtros, una es en la barra que sale abajo para ponerlos antes de hacer la historia o dos, después de hacer la historia deslizas a la derecha hasta que te guste el resultado.");
        visualizaciones[2] = new Visualizador(R.drawable.textohistorias, "¿Cómo se puede agregar texto?", "Después de hacer la historia, das click en cualquier sitio y escribes algo, escoges el color, fuente y tamaño, luego lo pones donde quieras.");
        visualizaciones[3] = new Visualizador(R.drawable.stickers, "¿Qué más opciones hay?", "Hay infinidad de cosas, una de ellas la puedes ver después de hacer la historia, en la parte de arriba le das a el sticker, y te saldrán opciones como poner música, enlaces, gif entre otras.");
        visualizaciones[4] = new Visualizador(R.drawable.adicionales, "¿Qué puedo hacer con las herramientas laterales?", "Entre otras cosas, puedes hacer boomerangs (videos cortos), collages (conjuntos de varias fotos), felicitaciones de cumpleaños etc.");
        visualizaciones[5] = new Visualizador(R.drawable.subirhistoria, "¿Cómo puedo subir mi historia?", "Cuando la historia este de tu agrado y te guste, es tan fácil como darle click al botón de tu historia, y ya estaría.");
        visualizaciones[6] = new Visualizador(R.drawable.visualizacioneshistorias, "¿Cómo puedo saber quién vio mi historia?", "Después de subirla, a medida que las personas la vean, si te pones sobre tu historia y deslizas hacia arriba puedes ver quien la vio, también desde ahí podrás borrar también la historia.");

    }


    public void Siguiente(View v) {

        // Cuando se pasa a la siguienye pregunta, se valida la respuesta de la pregunta actual
        // Pasa a la siguiente pregunta
        visualizacionEnCurso++;
        if (visualizacionEnCurso< NVISUALIZACIONES) {
            //reinicia los radio button a vacios
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
        pantallaFinal.setTitle("Final Componentes Historias Instagram");
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado este aparatado");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //activa el de menu historias
        reiniciar.setEnabled(true);


    }
}