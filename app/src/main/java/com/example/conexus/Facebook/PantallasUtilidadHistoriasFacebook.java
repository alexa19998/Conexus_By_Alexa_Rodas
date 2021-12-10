package com.example.conexus.Facebook;

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

public class PantallasUtilidadHistoriasFacebook extends AppCompatActivity {

    //Crear un final con la cantidad de pantallas que necesitamos
    static final int NVISUALIZACIONES = 5;
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
        setContentView(R.layout.activity_pantallas_utilidad_historias_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView=(ImageView)findViewById(R.id.imageView32);
        titulo = findViewById(R.id.titulo4);
        enunciado = findViewById(R.id.tvEnunciado6);
        siguiente = findViewById(R.id.btnSiguiente6);
        reiniciar = findViewById(R.id.buttonReiniciar6);
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

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase HistoriasFacebook
    public void reiniciarApp() {
        Intent intent = new Intent(this, MenuHistoriasFacebook.class);
        startActivity(intent);
    }

    //Metodo el cual carga los atributos que contiene el objeto Visualizador, con el total que creamos en el final
    public void cargarVisualizaciones() {

        visualizaciones[0] = new Visualizador(R.drawable.historiasface, "¿Que són?", "Las historias de Facebook te permiten compartir fotos y videos con tus amigos y seguidores que solo estarán disponibles para el público que elijas durante 24 horas.");
        visualizaciones[1] = new Visualizador(R.drawable.archivohistorias, "¿Que pasa cuando se cumple el plazo?", "Después de este plazo, puedes conservar las historias en el archivo de historias. Solo tú tienes acceso a este archivo.");
        visualizaciones[2] = new Visualizador(R.drawable.gruposface, "¿Se puede compartir?", "Puedes compartir contenido en una historia desde Facebook o Messenger. También puedes compartir historias de grupos, eventos o páginas.");
        visualizaciones[3] = new Visualizador(R.drawable.filtrosface, "¿Tiene otras opciones?", "Puedes poner filtros texto música.. etc.");
        visualizaciones[4] = new Visualizador(R.drawable.barraface, "¿Donde se ven las historias?", "Las historias de las personas a las que se sigue aparecen en una barra arriba de su muro o cronología.");
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
        pantallaFinal.setTitle("Final Utilidad Historias Facebook");
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado este apartado");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //activa el de menu historias
        reiniciar.setEnabled(true);


    }
}