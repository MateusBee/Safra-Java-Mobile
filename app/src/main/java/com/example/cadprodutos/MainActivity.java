package com.example.cadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.cadprodutos.BDHelper.SafrasBd;
import com.example.cadprodutos.model.Safra;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    SafrasBd bdHelper;
    ArrayList<Safra> listview_Safras;
    Safra safra;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = (Button) findViewById(R.id.btn_Cadastrar);
        btnCadastrar.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FormularioProdutos.class);
                startActivity(intent);
            }
        });

        lista = (ListView)  findViewById(R.id.listview_Safras);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Safra safraEscolhida = (Safra) adapter.getItemAtPosition(position);

                Intent i = new Intent(MainActivity.this, FormularioProdutos.class);
                i.putExtra("safra-escolhida", safraEscolhida);
                startActivity(i);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                safra = (Safra) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar esta Safra");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bdHelper = new SafrasBd(MainActivity.this);
                bdHelper.deletarSafra(safra);
                bdHelper.close();
                carregarSafra();

                return true;
            }
        });
    }

    protected void onResume() {
        super.onResume();
        carregarSafra();
    }

    public void carregarSafra() {
        bdHelper = new SafrasBd(MainActivity.this);
        listview_Safras = bdHelper.getLista();
        bdHelper.close();

        if(listview_Safras != null) {
            adapter = new ArrayAdapter<Safra>(MainActivity.this, android.R.layout.simple_list_item_1, listview_Safras);
            lista.setAdapter(adapter);
        }
//        finish();
    }
}
