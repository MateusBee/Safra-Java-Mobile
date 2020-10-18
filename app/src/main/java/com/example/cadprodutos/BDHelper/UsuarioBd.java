package com.example.cadprodutos.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cadprodutos.model.Usuario;

public class UsuarioBd extends SQLiteOpenHelper {

    private static final String DATABASE = "bdusuario";
    private static final int VERSION = 1;

    public UsuarioBd(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String usuario = "CREATE TABLE usuarios(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nome TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "senha TEXT NOT NULL);";
        db.execSQL(usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String usuario = "DROP TABLE IF EXISTS usuarios";
        db.execSQL(usuario);
    }

    public void salvarUsuario(Usuario usuario) {
        ContentValues values = new ContentValues();

        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());

        getWritableDatabase().insert("usuarios", null, values);
    }
}
