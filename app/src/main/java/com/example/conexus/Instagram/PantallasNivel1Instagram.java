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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conexus.R;
import com.example.conexus.Visualizador;

public class PantallasNivel1Instagram extends AppCompatActivity {
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
        setContentView(R.layout.activity_pantallas_nivel1_instagram);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView=(ImageView)findViewById(R.id.imageView19);
        titulo = findViewById(R.id.titulo);
        enunciado = findViewById(R.id.tvEnunciado);
        siguiente = findViewById(R.id.btnSiguiente);
        reiniciar = findViewById(R.id.buttonReiniciar);
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

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase MenuAprenderInstagram
    public void reiniciarApp() {
        Intent intent = new Intent(this, MenuAprenderInstagram.class);
        startActivity(intent);
    }

    //Metodo el cual carga los atributos que contiene el objeto Visualizador, con el total que creamos en el final
    public void cargarVisualizaciones() {

        visualizaciones[0] = new Visualizador(R.drawable.personapensando,"??Qu?? es?", "Es una red social y una aplicaci??n m??vil al mismo tiempo, que permite a sus usuarios subir im??genes y v??deos con m??ltiples efectos fotogr??ficos como filtros, marcos, colores retro, etc., para posteriormente compartir esas im??genes en la misma plataforma o en otras redes sociales.\n" +
                "Esta aplicaci??n o red, es actualmente una de las que mayor crecimiento tiene en el mundo.\n");
        visualizaciones[1] = new Visualizador(R.drawable.usuarios, "??Cu??ntos Usuarios tiene Instagram?","Esta red social cuenta con m??s de 1000 millones de usuarios.");
        visualizaciones[2] = new Visualizador(R.drawable.sirve,"??Para que sirve?","sirve para compartir im??genes y v??deos, aplicando filtros y consiguiendo de esta manera que una foto hecha con el m??vil se convierta en una imagen profesional.\n" +
                "El procedimiento es muy sencillo.");
        visualizaciones[3] = new Visualizador(R.drawable.procedimiento,"??C??mo es el procedimiento?","El usuario toma una foto o graba un v??deo desde su m??vil, le aplica un filtro o retoque fotogr??fico y la comparte con su comunidad, pudiendo elegir si lo hace temporalmente o fija en su muro.\n" +
                "Tambi??n es posible compartir esa imagen en otras redes sociales y adem??s publicar en las famosas historias, de las cuales ya hablaremos en otro apartado de la aplicaci??n.");
        visualizaciones[4] = new Visualizador( R.drawable.porqueutilizar,"??Por qu?? utilizar instagram?","Ya las grandes marcas, en el a??o 2015 que tuvo un gran crecimiento, vieron un gran potencial a esta red social ya que era una gran oportunidad de comunicarse con esta creciente comunidad de usuarios.\n" +
                "Instagram es la red social l??der en casi todos los sectores. Siendo un referente de inspiraci??n, creatividad e informaci??n visual.");
        visualizaciones[5] = new Visualizador(R.drawable.checklist, "Ventajas de Instagram","*No tiene coste. \n" +
                "*Es ilimitada.\n" +
                "*Gran visibilidad de tus contenidos.\n" +
                "*Gesti??n de comunidades y fidelizaci??n de usuarios. \n" +
                "*Red social de fotograf??a muy completa. \n" +
                "*Es un medio de comunicaci??n perfeccionado.\n" +
                "*Ayuda y fomenta al artista.\n" +
                "*Es muy creativa y formativa.\n" +
                "*Los contenidos se clasifican y difunden por m??ltiples par??metros\n");
        visualizaciones[6] = new Visualizador( R.drawable.avion,"Mensajes de instagram","Los mensajes de Instagram son conocidos como dm (direct message) son los m??s utilizados entre los j??venes (mucho m??s que Whatsapp) y nos permiten hablar con otros usuarios, adem??s de poder compartir fotos y v??deos.");

    }

    public void Siguiente(View v) {

        // Cuando se pasa a la siguienye pregunta, se valida la respuesta de la pregunta actual
        // Pasa a la siguiente pregunta
        visualizacionEnCurso++;
        if (visualizacionEnCurso< NVISUALIZACIONES) {
            //reinicia los radio button a vacios.
            mostrarEnunciadoEnCurso();
        } else {
            // Si se llega al final del test, se desactiva el bot??n siguiente
            siguiente.setEnabled(false);
            mostrarFinal();
        }



    }

    public void mostrarFinal() {

        // Muestra un mensaje con el final de la seccion
        AlertDialog.Builder pantallaFinal = new AlertDialog.Builder(this);
        pantallaFinal.setTitle("Final Nivel 1");
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado el Nivel 1 de Instagram");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        reiniciar.setEnabled(true);


    }





}