package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    Intent it;
    String jogador;
    TextView nomeInserido, pergunta;
    Button proximo;
    Button[] opcao;
    int posicao, pontos;
    ArrayList<Quiz> questionario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        it = getIntent();
        nomeInserido = findViewById(R.id.id_nome_inserido);
        jogador = it.getExtras().getString("nomeDoJogador");
        jogador = nomeInserido.getText()+ jogador +"!";
        nomeInserido.setText(jogador);
        opcao = new Button[4];
        opcao[0] = findViewById(R.id.id_btn_r1);
        opcao[1] = findViewById(R.id.id_btn_r2);
        opcao[2] = findViewById(R.id.id_btn_r3);
        opcao[3] = findViewById(R.id.id_btn_r4);
        proximo = findViewById(R.id.id_btn_proximo);
        pergunta = findViewById(R.id.id_txt_pergunta);
        questionario = new ArrayList<>();
        pontos = 0;
        posicao = 0;
        inicializarQuestionario();
        configurarQuestao(posicao);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posicao < questionario.size() - 1){
                    posicao++;
                    configurarQuestao(posicao);
                    controlarBotao(true);
                }else{
                    String resultado;
                    resultado = "Seu saldo foi de "+ Integer.toString(pontos) +" questões acertadas.";
                    Toast.makeText(QuizActivity.this,resultado,Toast.LENGTH_LONG).show();
                }
            }
        });

        opcao[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcao[0].getText().equals(questionario.get(posicao).getResposta())){
                    pontos++;
                    Toast.makeText(QuizActivity.this,"Parabéns, você acertou!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(QuizActivity.this,"Tente mais uma vez!",Toast.LENGTH_LONG).show();
                }
                controlarBotao(false);
            }
        });

        opcao[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcao[1].getText().equals(questionario.get(posicao).getResposta())){
                    pontos++;
                    Toast.makeText(QuizActivity.this,"Parabéns, você acertou!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(QuizActivity.this,"Tente mais uma vez!",Toast.LENGTH_LONG).show();
                }
                controlarBotao(false);
            }
        });

        opcao[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcao[2].getText().equals(questionario.get(posicao).getResposta())){
                    pontos++;
                    Toast.makeText(QuizActivity.this,"Parabéns, você acertou!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(QuizActivity.this,"Tente mais uma vez!",Toast.LENGTH_LONG).show();
                }
                controlarBotao(false);
            }
        });

        opcao[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDoToast;
                if(opcao[3].getText().equals(questionario.get(posicao).getResposta())){
                    pontos++;
                    textoDoToast = "Parabéns, você acertou!";
                }else{
                    textoDoToast = "Tente mais uma vez!";
                }
                Toast.makeText(QuizActivity.this,textoDoToast,Toast.LENGTH_LONG).show();
                controlarBotao(false);
            }
        });
    }

    private void configurarQuestao(int posicao) {
        pergunta.setText(questionario.get(posicao).getPergunta());
        opcao[0].setText(questionario.get(posicao).getOpcao1());
        opcao[1].setText(questionario.get(posicao).getOpcao2());
        opcao[2].setText(questionario.get(posicao).getOpcao3());
        opcao[3].setText(questionario.get(posicao).getOpcao4());
    }

    private void inicializarQuestionario() {
        questionario.add(new Quiz("2+2 ?", "2", "3", "4", "5", "4"));
        questionario.add(new Quiz("3+3 ?", "5", "4", "6", "7", "6"));
        questionario.add(new Quiz("3! ?", "6", "3", "12", "21", "6"));
        questionario.add(new Quiz("3 + 3 * 5 ?", "18", "30", "12", "21", "18"));
        questionario.add(new Quiz("(3 + 3) * 5 ?", "15", "30", "23", "21", "30"));
        questionario.add(new Quiz("Em dezembro de 2001, no ápice da crise econômica, o governo argentino confiscou os depósitos bancários e limitou os saques mensais por conta a:",
                "1.000 pesos argentinos", "1.500 pesos argentinos",
                "2.000 pesos argentinos", "2.500 pesos argentinos", "1.000 pesos argentinos"));
        questionario.add(new Quiz("Qual destes candidatos não concorreu às eleições presidenciais na França em 2017?",
                "François Fillon", "Jean-Luc Mélenchon",
                "Alain Pohe", "Marine Le Pen", "Alain Pohe"));
        questionario.add(new Quiz("Na novela \"Avenida Brasil\", Genésio, primeiro marido de Carminha, vende a casa e sai do banco com uma mala cheia de:",
                "Notas falsas", "Papel picado",
                "Dinheiro", "Jornal", "Papel picado"));
        questionario.add(new Quiz("Qual é o nome do dirigente comunista chinês que comandou as reformas pró-capitalismo na China e que morreu aos 92 anos, em 1997?",
                "Jiang Zemin", "Deng Xiaoping",
                "Liu Shaoqi", "Li Xiannian", "Deng Xiaoping"));
    }
    private void controlarBotao(boolean valor){
        for(int i = 0; i < opcao.length; i++){
            opcao[i].setEnabled(valor);
        }
    }
}