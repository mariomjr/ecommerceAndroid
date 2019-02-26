package br.ufg.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.ufg.ecommerce.controller.LoginController;
import br.ufg.ecommerce.entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view){
        TextView textViewEmail = findViewById(R.id.txtEmail);
        TextView textViewPass = findViewById(R.id.txtSenha);
        String email = String.valueOf(textViewEmail.getText());
        String pass = String.valueOf(textViewPass.getText());
        User user = new User();
        user.setEmail(email);
        user.setSenha(pass);

        LoginController controler = new LoginController(this);
        controler.start();
    }
}
