package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button botao;
    EditText jogador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = findViewById(R.id.id_botao);
        jogador = findViewById(R.id.id_input_nome);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Nome digitado: "+ jogador.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("nomeDoJogador", jogador.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}