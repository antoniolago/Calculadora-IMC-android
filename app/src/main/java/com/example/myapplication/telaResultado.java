package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class telaResultado extends AppCompatActivity {
    TextView txtResultado;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_calculo);
        txtResultado = findViewById(R.id.txtResultado);
        btnVoltar = findViewById(R.id.btnVoltar);
        Intent intent = getIntent();
        String imc = intent.getStringExtra("imc");
        System.out.println(imc);
        txtResultado.setText(imc);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                onBackPressed();
            }
        });
    }

}
