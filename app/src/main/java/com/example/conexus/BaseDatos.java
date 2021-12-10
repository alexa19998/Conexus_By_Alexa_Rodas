package com.example.conexus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(@Nullable Context context, @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creacion de la tabla con 3 campos un integer que es auto incrementable y un texto que es el nombre del usuario y la contraseña que tambien es un texto
        db.execSQL("create table userstable(id_user integer  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "username text NOT NULL,clave_user text NOT NULL)");
        //Hacemos un insert para tener un valor insertado como predeterminado
        db.execSQL("insert into userstable(username,clave_user) values('admin','admin')");
    }


    //Este metodo ayuda a administrar la versiones de la base de datos creada
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Creacion de la tabla
        db.execSQL("create table userstable(id_user integer  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "username text NOT NULL,clave_user text NOT NULL)");
        db.execSQL("insert into userstable(username,clave_user) values('admin','admin')");
    }}

