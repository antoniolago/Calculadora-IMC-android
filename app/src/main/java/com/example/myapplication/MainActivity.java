package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtNome;
    EditText edtAltura;
    Button btnComparar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = findViewById(R.id.edtNome);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnComparar = findViewById(R.id.btnComparar);
        btnComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtPeso.getText().toString().equals("") && !edtAltura.getText().toString().equals("") && !edtNome.getText().toString().equals("") && !edtPeso.getText().toString().contains(",") && !edtPeso.getText().toString().contains(",")) {
                    Double peso, altura, imc;
                    String nome;
                    String estado = "";
                    Usuario c = new Usuario(edtPeso.getText().toString(), edtAltura.getText().toString(), edtNome.getText().toString());
                    peso = c.peso;
                    altura = c.altura;
                    nome = c.nome;
                    imc = peso / (altura * altura);
                    if (imc < 18.5) {
                        estado = "abaixo do peso";
                    } else if (imc >= 18.5 && imc <= 24.9) {
                        estado = "com peso normal";
                    } else if (imc > 24.9 && imc <= 29.9) {
                        estado = "com sobrepeso, tenha uma rotina diária de exercícios!";
                    } else if (imc > 29.9) {
                        estado = "com obesidade, tome cuidado com a sua saúde, faça exercícios e procure acompanhamento médico.";
                    }
                    Intent intent = new Intent(getBaseContext(), telaResultado.class);
                    intent.putExtra("imc", nome + " seu imc é de " + String.format("%.2f", imc) + " ou seja, você está " + estado);
                    startActivity(intent);
                    }else {
                    Toast.makeText(MainActivity.this, "Preencha os campos corretamente!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }


}

