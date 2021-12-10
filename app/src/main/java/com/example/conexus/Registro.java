package com.example.conexus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    String Title="Registro de Usuarios";
    EditText Etusurname,EtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        this.setTitle(Title);
        //emparejamos las variables
        Etusurname = (EditText) findViewById(R.id.RegUser);
        EtPass=(EditText) findViewById(R.id.RegPass);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    //Metodo Para registrar los datos del usuario
    public void RegistrarDataUser(View v){
        //creamos un objeto de la clase BaseDatos
        BaseDatos admin=new BaseDatos(this,"ingles",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String UserName=Etusurname.getText().toString();
        String PassUser=EtPass.getText().toString();

        ContentValues values = new ContentValues();
        //capturamos los valores
        values.put("username",UserName);
        values.put("clave_user",PassUser);
        //llamamos al insert damos el nombre de la base de datos y los valores
        db.insert("userstable",null,values);
        //cerramos la base de datos
        db.close();
        //Lanzamos una notificacion toast
        Toast ToastMens= Toast.makeText(this,"Usuario registrado",Toast.LENGTH_SHORT);
        //mostramos el toast
        ToastMens.show();
        //lanzamos la actividad
        Intent intent=new Intent(this, InicioSesion.class);
        //iniciamos la actividad
        startActivity(intent);
    }
}