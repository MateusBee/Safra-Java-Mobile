package com.example.cadprodutos.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cadprodutos.model.Safra;

import java.util.ArrayList;

public class SafrasBd extends SQLiteOpenHelper {

    private static final String DATABASE = "bdsafras";
    private static final int VERSION = 1;

    public SafrasBd(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String safra = "CREATE TABLE safras(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "variedade TEXT NOT NULL," +
                "hec_plant TEXT NOT NULL," +
                "data_plant TEXT NOT NULL," +
                "quant_sacas_semente INTEGER NOT NULL," +
                "valor_saca_semente TEXT NOT NULL," +
                "quant_sacas_fertilizante INTEGER NOT NULL," +
                "valor_saca_fertilizante TEXT NOT NULL);";
        db.execSQL(safra);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String safra = "DROP TABLE IF EXISTS safras";
        db.execSQL(safra);
    }

    public void salvarSafra(Safra safra) {
        ContentValues values = new ContentValues();

        values.put("variedade", safra.getVariedade());
        values.put("hec_plant", safra.getHec_plant());
        values.put("data_plant", safra.getData_plant());
        values.put("quant_sacas_semente", safra.getQuant_sacas_semente());
        values.put("valor_saca_semente", safra.getValor_saca_semente());
        values.put("quant_sacas_fertilizante", safra.getQuant_sacas_fertilizante());
        values.put("valor_saca_fertilizante", safra.getValor_saca_fertilizante());

        getWritableDatabase().insert("safras", null, values);
    }

    public void alterarSafra(Safra safra) {
        ContentValues values = new ContentValues();

        values.put("variedade", safra.getVariedade());
        values.put("hec_plant", safra.getHec_plant());
        values.put("data_plant", safra.getData_plant());
        values.put("quant_sacas_semente", safra.getQuant_sacas_semente());
        values.put("valor_saca_semente", safra.getValor_saca_semente());
        values.put("quant_sacas_fertilizante", safra.getQuant_sacas_fertilizante());
        values.put("valor_saca_fertilizante", safra.getValor_saca_fertilizante());

        String [] args = {safra.getId().toString()};
        getWritableDatabase().update("safras", values, "id=?", args);
    }

    public void deletarSafra(Safra safra) {
        String [] args = {safra.getId().toString()};
        getWritableDatabase().delete("safras","id=?", args);
    }

    // Busca as safras e retorna um arrayList de safras
    public ArrayList<Safra> getLista() {
        String [] colomns = {"id", "variedade", "hec_plant", "data_plant", "quant_sacas_semente", "valor_saca_semente", "quant_sacas_fertilizante", "valor_saca_fertilizante"};
        Cursor cursor = getWritableDatabase().query("safras", colomns, null,null,null,null,null,null);

        ArrayList<Safra> safras = new ArrayList<Safra>();

        while (cursor.moveToNext()) {
            Safra safra = new Safra();

            safra.setId(cursor.getLong(0));
            safra.setVariedade(cursor.getString(1));
            safra.setHec_plant(cursor.getString(2));
            safra.setData_plant(cursor.getString(3));
            safra.setQuant_sacas_semente(cursor.getInt(4));
            safra.setValor_saca_semente(cursor.getString(5));
            safra.setQuant_sacas_fertilizante(cursor.getInt(6));
            safra.setValor_saca_fertilizante(cursor.getString(7));

            safras.add(safra);

        }
        return  safras;
    }
}
