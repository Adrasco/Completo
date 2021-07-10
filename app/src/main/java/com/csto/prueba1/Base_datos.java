package com.csto.prueba1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Base_datos  extends SQLiteOpenHelper {

    public static String BaseDatos = "Base.db";
    public static int vercion = 1;

    public static String tabla_persona = "CREATE TABLE persona (" +
            "id_persona integer primary key autoincrement , " +
            "nom text , " +
            "pass text, " +
            "sexo integer , " +
            "comida text , " +
            "micro integer)";

    public  Base_datos(@Nullable Context context) {

        super(context, BaseDatos, null, vercion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tabla_persona);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS panorama");
        db.execSQL(tabla_persona);

    }

}
