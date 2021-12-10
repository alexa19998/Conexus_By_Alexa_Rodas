package com.example.conexus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {
    //creamos la variables locales que utlizaremos
    EditText et1,et2;
    //Cursor
    private Cursor fila;
    String Title = "Inicio de Sesión";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        this.setTitle(Title);
        //habilitamos para que se pueda visualizar el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //emparejamos las variables
        et1= (EditText) findViewById(R.id.User);
        et2= (EditText) findViewById(R.id.Pass);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    //metodo de inicio de sesion
    public void InicioSesion(View v){
        //Creamos un objeto de la clase BaseDatos e instanciamos el constructor y damos el nombre de la base de datos y la version
        BaseDatos admin = new BaseDatos(this,"ingles",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        //Creamos dos variables string (usuario y contraseña)y capturamos los datos ingresado por el usuario y lo convertimos a string
        String usuario=et1.getText().toString();
        String contrasena=et2.getText().toString();

        fila=db.rawQuery("select username,clave_user from userstable where username='"+
                usuario+"' and clave_user='"+contrasena+"'",null);

        //Realizamos un try catch para capturar los errores
        try {
            //Preguntamos si cursor tiene algun dato
            if(fila.moveToFirst()){
                //capturamos los valores del cursos y lo almacenamos en una variable
                String usua=fila.getString(0);
                String pass=fila.getString(1);
                //preguntamos si los datos ingresados son iguales
                if (usuario.equals(usua)&&contrasena.equals(pass)){
                    //si son iguales entonces inicia sesion
                    Intent ven=new Intent(this, MenuPrincipal.class);
                    //lanzamos la actividad
                    startActivity(ven);
                    //vaciamos los edittext
                    et1.setText("");
                    et2.setText("");
                }
            }
            else {
                Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);

                toast.show();
            }

        } catch (Exception e) {//capturamos los errores
            Toast toast=Toast.makeText(this,"Error" + e.getMessage(),Toast.LENGTH_LONG);

            toast.show();
        }
    }
    //metodo que nos envia a la ventana de registro
    public void RegistroData(View v){

        Intent rdata=new Intent(this, Registro.class);
        startActivity(rdata);
    }
}