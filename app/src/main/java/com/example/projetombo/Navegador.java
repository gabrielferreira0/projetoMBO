package com.example.projetombo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Navegador extends AppCompatActivity {

    private EditText URL;
    private Button btPesquisar;
    private WebView resultURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        btPesquisar = (Button) findViewById(R.id.btPesquisar);
        URL = (EditText) findViewById(R.id.URL);
        resultURL = (WebView) findViewById(R.id.resultURL);
        resultURL.getSettings().setJavaScriptEnabled(true);
        resultURL.setWebViewClient(new WebViewClient());

        btPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = URL.getText().toString();
                resultURL.loadUrl(txt);
            }
        });

    }
}