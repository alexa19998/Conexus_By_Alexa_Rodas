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

import com.example.conexus.Instagram.PrimeraPantallaInstagram;
import com.example.conexus.R;
import com.example.conexus.Visualizador;

public class PantallasNivel1Facebook extends AppCompatActivity {
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
        setContentView(R.layout.activity_pantallas_nivel1_facebook);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Relacionamos las variables de la clase con los id correspondientes del activity
        imageView=(ImageView)findViewById(R.id.imageView21);
        titulo = findViewById(R.id.titulo2);
        enunciado = findViewById(R.id.tvEnunciado2);
        siguiente = findViewById(R.id.btnSiguiente2);
        reiniciar = findViewById(R.id.buttonReiniciar2);
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

    //Metodo para asignar a un boton por medio del onClick en el activity para abrir el activity anterior de la clase MenuAprenderFacebook
    public void reiniciarApp() {
        Intent intent = new Intent(this, MenuAprenderFacebook.class);
        startActivity(intent);
    }


    //Metodo el cual carga los atributos que contiene el objeto Visualizador, con el total que creamos en el final
    public void cargarVisualizaciones() {

        visualizaciones[0] = new Visualizador(R.drawable.personapensando,"??Qu?? es?", "Por medio de esta red, puedes encontrar personas conocidas, interactuar con ellas, participar en grupos que discuten temas de tu inter??s, compartir contenido (im??genes, texto, v??deo), enviar y recibir mensajes, hacer contactos, realizar b??squedas, hacer anuncios, etc.");
        visualizaciones[1] = new Visualizador(R.drawable.usuarios, "??Cu??ntos Usuarios tiene Instagram?","Facebook es la mayor de las redes sociales: cuenta con 2 billones de usuarios activos en todo el mundo y cumpli?? 14 a??os de existencia el 4 de febrero de 2018.");
        visualizaciones[2] = new Visualizador(R.drawable.modalidadfacebook,"??Qu?? modalidades tiene?","En ??l, es posible crear un perfil personal o una Fanpage, e interactuar con otras personas conectadas al sitio, a trav??s de intercambio de mensajes instant??neos, de la compartici??n de contenidos y de los famosos ???me gusta??? en las publicaciones de los usuarios.\n" +
                "Adem??s de realizar estas funciones, tambi??n permite participar en grupos de acuerdo con los intereses de las personas y necesidades dentro de la red social.");
        visualizaciones[3] = new Visualizador(R.drawable.checklist,"??Ventajas?","*Hacer nuevos amigos\n" +
                "*Interact??a con los contenidos de tu comunidad\n" +
                "*Puedes unirte a grupos tem??ticos");
        visualizaciones[4] = new Visualizador( R.drawable.funcionesextra,"Otras funcionalidades extra","Dentro de Facebook encontramos diversas funcionalidades diferentes a las principales que ya te he contado, como por ejemplo:\n" +
                "\n" +
                "*Juegos:donde no solo podr??s jugar solo, sino que podr??s interactuar con tus amigos.\n" +
                "*Eventos: podr??s estar al d??a de los eventos que se realizan cerca de tu ubicaci??n.\n" +
                "*Empleos: donde no s??lo puedes ver las ofertas, sino que tambi??n podr??s publicar las tuyas.\n" +
                "*Realizar pagos: ahora que existe un portal de ventas al m??s puro estilo ??Wallapop??.\n" +
                "*Recomendaciones: tambi??n podr??s solicitar recomendaciones de lugares, restaurantes, tiendas, hoteles.\n" +
                "*Grupos: existen grupos creados por los propios usuarios en los que se re??nen seg??n intereses.");
        visualizaciones[5] = new Visualizador(R.drawable.grupostelematicos, "??Qu?? tipos de grupos telem??ticos hay?","Existen 3 tipos de grupos:\n" +
                "*Grupos Abiertos/P??blicos: podemos incluirnos sin necesidad de que nos autoricen.\n" +
                "*Grupos Privados/Cerrados: podemos encontrarlos en el buscador, pero para formar parte de ??l debemos ser aceptados por alguno de los administradores.\n" +
                "*Grupos Secretos: estos no los encontrar??s en los buscadores, digamos que hay que ser un poco ???VIP??? para participar en ??l, ya que solo un administrador o miembro del grupo secreto puede invitarte a acceder a ??l y su contenido no podr?? ser compartido ni difundido en la plataforma.\n");
        visualizaciones[6] = new Visualizador( R.drawable.conclusion,"Conclusi??n","En resumen, Facebook se trata de una red social con la capacidad de unir a usuarios en una misma comunidad, d??ndole la facilidad de compartir experiencias, momentos y conversaciones, as?? como la oportunidad de poder contactar con una empresa.\n" +
                "Tambi??n puedes estar al d??a de sus novedades y, si t?? est??s en ella como empresa, poder dar a conocer tus productos y servicios.");

    }


    public void Siguiente(View v) {

        // Cuando se pasa a la siguienye pregunta, se valida la respuesta de la pregunta actual
        // Pasa a la siguiente pregunta
        visualizacionEnCurso++;
        if (visualizacionEnCurso< NVISUALIZACIONES) {
            //reinicia los radio button a vacios
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
        pantallaFinal.setMessage("Muy Bien!\nHas finalizado el Nivel 1 de Facebook");
        pantallaFinal.setPositiveButton("OK", null);
        pantallaFinal.create();
        pantallaFinal.show();

        //activa el de menu historias
        reiniciar.setEnabled(true);


    }





}