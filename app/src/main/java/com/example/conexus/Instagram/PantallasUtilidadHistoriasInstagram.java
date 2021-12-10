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

import com.example.conexus.Facebook.MenuHistoriasFacebook;
import com.example.conexus.R;
import com.example.conexus.Visualizador;

public class PantallasUtilidadHistoriasInstagram extends AppCompatActivity {
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
        setContentView(R.layout.activity_pantallas_utilidad_historias_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView=(ImageView)findViewById(R.id.imageView31);
        titulo = findViewById(R.id.titulo3);
        enunciado = findViewById(R.id.tvEnunciado5);
        siguiente = findViewById(R.id.btnSiguiente5);
        reiniciar = findViewById(R.id.buttonReiniciar5);
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

        visualizaciones[0] = new Visualizador(R.drawable.storiesdeinstagram, "¿Que són?", "\"Instagram Stories\" (o \"Historias\", como se le llama en español) permite a los usuarios compartir momentos y luego personalizarlos con texto, dibujos y emojis.");
        visualizaciones[1] = new Visualizador(R.drawable.reacciones, "¿Se pueden dar me gusta en las historias?", "o\tA diferencia de lo que ocurre con las publicaciones normales en Instagram, no se permiten \"me gusta\" ni comentarios. Si un amigo reacciona, la persona recibirá un mensaje directo.");
        visualizaciones[2] = new Visualizador(R.drawable.barrahistorias, "¿Donde se pueden ver?", "Las historias de las personas a las que se sigue aparecen en una barra arriba de su muro o cronología.");
        visualizaciones[3] = new Visualizador(R.drawable.veinticuatrohoras, "¿Por cuanto tiempo se pueden ver?", "Estas podrán verse durante 24 horas desde su publicación.");
        visualizaciones[4] = new Visualizador(R.drawable.filtros, "¿Se pueden personalizar?", "Puedes personalizarlas mucho, poner filtros, música, stickers, gif.. etc.");
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
        pantallaFinal.setTitle("Final Utilidad Historias Instagram");
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado este apartado");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //activa el de menu historias
        reiniciar.setEnabled(true);


    }
}