package com.example.cadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadprodutos.BDHelper.SafrasBd;
import com.example.cadprodutos.BDHelper.UsuarioBd;
import com.example.cadprodutos.model.Safra;
import com.example.cadprodutos.model.Usuario;
import com.example.cadprodutos.ui.login.LoginActivity;

public class UserRegister extends AppCompatActivity {
    EditText nome, email, senha, conf_senha;
    Button btn_register, btn_cancel;
    Usuario usuario;
    UsuarioBd bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        usuario = new Usuario();
        bdHelper = new UsuarioBd(UserRegister.this); //Instância do banco de dados

        nome = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        conf_senha = (EditText) findViewById(R.id.conf_senha);

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserRegister.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(nome.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());

                bdHelper.salvarUsuario(usuario);
                bdHelper.close();

                Intent intent = new Intent(UserRegister.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
