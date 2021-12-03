package com.example.proyecto_base_2dauni.dataBase;


import android.content.Context;
//creamos sentencias
import android.database.sqlite.SQLiteDatabase;
//permite crear base de datos
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    //creamos constructor alt+enter sobre el nobre de la clase contructor de 4 parametros
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //creamos metodos oncreate y upgrade desde generate
    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos base de datos
        db.execSQL("CREATE TABLE clases(codigo int primary key, clase text, intensidad text)");
    }

    //modificar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
