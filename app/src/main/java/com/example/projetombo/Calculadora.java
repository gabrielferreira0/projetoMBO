package com.example.projetombo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculadora extends AppCompatActivity  implements View.OnClickListener{

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito
            ,numetoNove,ponto,soma,subtracao,multipicacao,divisao,igual,botao_limpar;

    private TextView txtExpressao,txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        iniciarComponentes();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numetoNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multipicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1= string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);

                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado==(double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }
                    else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e) {

                }


            }
        });

    }

    private void iniciarComponentes() {
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numetoNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.somar);
        subtracao = findViewById(R.id.subtracao);
        multipicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.resultado);
        botao_limpar = findViewById(R.id.limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);

    }


    public void AcrescentarumaExpressao (String string, boolean limpar_dados){
        if (txtResultado.getText().equals("")) {
        txtExpressao.setText(" ");

        }

        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }

    @Override
    public void onClick(View view) {
     switch (view.getId()) {
         case R.id.numero_zero:
             AcrescentarumaExpressao("0",true);
             break;
             case R.id.numero_um:
             AcrescentarumaExpressao("1",true);
             break;
         case R.id.numero_dois:
             AcrescentarumaExpressao("2",true);
             break;
         case R.id.numero_tres:
             AcrescentarumaExpressao("3",true);
             break;
         case R.id.numero_quatro:
             AcrescentarumaExpressao("4",true);
             break;
         case R.id.numero_cinco:
             AcrescentarumaExpressao("5",true);
             break;
         case R.id.numero_seis:
             AcrescentarumaExpressao("6",true);
             break;
         case R.id.numero_sete:
             AcrescentarumaExpressao("7",true);
             break;
         case R.id.numero_oito:
             AcrescentarumaExpressao("8",true);
             break;
         case R.id.numero_nove:
             AcrescentarumaExpressao("9",true);
             break;
         case R.id.ponto:
             AcrescentarumaExpressao(".",true);
             break;
         case R.id.somar:
             AcrescentarumaExpressao("+",false);
             break;
         case R.id.subtracao:
             AcrescentarumaExpressao("-",false);
             break;
         case R.id.multiplicacao:
             AcrescentarumaExpressao("*",false);
             break;
         case R.id.divisao:
             AcrescentarumaExpressao("/",false);
             break;
     }
    }
}