package com.example.cadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadprodutos.BDHelper.SafrasBd;
import com.example.cadprodutos.model.Safra;

public class FormularioProdutos extends AppCompatActivity {
    EditText editText_variedade, editText_hectares, editText_plantio, editText_sacasSemente, editText_valorSacaSemente, editText_sacasFert, editText_valorSacaFert;
    Button btn_Poliform;
    Safra editarSafra, safra; // crio uma variável produto para ter acesso aos get e set
    SafrasBd bdHelper; //Instância do banco de dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produtos);

        safra = new Safra();
        bdHelper = new SafrasBd(FormularioProdutos.this); //Instância do banco de dados

        Intent intent = getIntent();
        editarSafra = (Safra) intent.getSerializableExtra("safra-escolhida");

        editText_variedade = (EditText) findViewById(R.id.editText_variedade);
        editText_hectares = (EditText) findViewById(R.id.editText_hectares);
        editText_plantio = (EditText) findViewById(R.id.editText_plantio);
        editText_sacasSemente = (EditText) findViewById(R.id.editText_sacasSemente);
        editText_valorSacaSemente = (EditText) findViewById(R.id.editText_valorSacaSemente);
        editText_sacasFert = (EditText) findViewById(R.id.editText_sacasFert);
        editText_valorSacaFert = (EditText) findViewById(R.id.editText_valorSacaFert);

        btn_Poliform = (Button) findViewById(R.id.btn_Poliform);

//        Altera o nome do botão de cadastro de safra para Modificar caso esteja editando uma safra
        if(editarSafra != null){
            btn_Poliform.setText("Modificar");

            editText_variedade.setText(editarSafra.getVariedade());
            editText_hectares.setText(editarSafra.getHec_plant());
            editText_plantio.setText(editarSafra.getData_plant());
            editText_sacasSemente.setText(editarSafra.getQuant_sacas_semente()+"");
            editText_valorSacaSemente.setText(editarSafra.getValor_saca_semente());
            editText_sacasFert.setText(editarSafra.getQuant_sacas_fertilizante()+"");
            editText_valorSacaFert.setText(editarSafra.getValor_saca_fertilizante());

            safra.setId(editarSafra.getId());

        } else {
            btn_Poliform.setText("Cadastrar");
        }

        btn_Poliform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safra.setVariedade(editText_variedade.getText().toString());
                safra.setHec_plant(editText_hectares.getText().toString());
                safra.setData_plant(editText_plantio.getText().toString());
                safra.setQuant_sacas_semente(Integer.parseInt(editText_sacasSemente.getText().toString()));
                safra.setValor_saca_semente(editText_valorSacaSemente.getText().toString());
                safra.setQuant_sacas_fertilizante(Integer.parseInt(editText_valorSacaFert.getText().toString()));
                safra.setValor_saca_fertilizante(editText_valorSacaFert.getText().toString());

                if(btn_Poliform.getText().toString().equals("Cadastrar")) { //Se o calor do texto do botão for Cadastrar os valores são enviados para a função salvarSafra caso contrário alterarSafra
                    bdHelper.salvarSafra(safra);
                    bdHelper.close();
                } else {
                    bdHelper.alterarSafra(safra);
                    bdHelper.close();
                }
            }
        });
    }
}
