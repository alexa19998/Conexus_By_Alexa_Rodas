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

import com.example.conexus.Instagram.MenuHistoriasInstagram;
import com.example.conexus.R;
import com.example.conexus.Visualizador;

public class PantallaComponentesHistoriasFacebook extends AppCompatActivity {
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
        setContentView(R.layout.activity_pantalla_componentes_historias_facebook);

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView=(ImageView)findViewById(R.id.imageView36);
        titulo = findViewById(R.id.titulo5);
        enunciado = findViewById(R.id.tvEnunciado7);
        siguiente = findViewById(R.id.btnSiguiente7);
        reiniciar = findViewById(R.id.buttonReiniciar7);
        enunciado.setMovementMethod(new ScrollingMovementMethod());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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

        visualizaciones[0] = new Visualizador(R.drawable.barrahistoriaface, "¿En qué zona puedes acceder para subir una historia?", "Dándole click a la foto de tu perfil de la barra de historias.");
        visualizaciones[1] = new Visualizador(R.drawable.filtrosfacess, "¿En qué zona se encuentran los filtros?", "Hay dos formas de poner filtros, una es en la barra que sale abajo para ponerlos antes de hacer la historia o dos, después de hacer la historia le das a el botón de efectos y escoges hasta que te guste el resultado.");
        visualizaciones[2] = new Visualizador(R.drawable.textoface, "¿Cómo se puede agregar texto?", "Después de hacer la historia, das click en el botón texto y escribes algo, escoges el color y tamaño, luego lo pones donde quieras.");
        visualizaciones[3] = new Visualizador(R.drawable.adicionalface, "¿Qué más opciones hay?", "Hay infinidad de cosas, una de ellas la puedes ver después de hacer la historia, o antes tienes varias opciones como hacer historias solo de texto etc.");
        visualizaciones[4] = new Visualizador(R.drawable.barralateralface, "¿Qué puedo hacer con las herramientas laterales?", "Entre otras cosas puedes agregar stickers, texto, dibujar, agregar efectos... etc.");
        visualizaciones[5] = new Visualizador(R.drawable.compartirface, "¿Cómo puedo subir mi historia?", "Cuando la historia este de tu agrado y te guste, es tan fácil como darle click al botón de compartir, y ya estaría.");
        visualizaciones[6] = new Visualizador(R.drawable.visualizacionesface, "¿Cómo puedo saber quién vio mi historia?", "Después de subirla, a medida que las personas la vean, si te pones sobre tu historia y deslizas hacia arriba puedes ver quien la vio, también desde ahí podrás borrar también la historia.");

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
        pantallaFinal.setTitle("Final Componentes Historias Facebook");
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado este aparatado");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //activa el de menu historias
        reiniciar.setEnabled(true);


    }
}