package com.example.myapplication;

public class Usuario {

        Double peso, altura;
        String nome;

    public Usuario(String peso, String altura, String nome) {
        this.nome = nome;
        this.peso = Double.parseDouble(peso);
        this.altura = Double.parseDouble(altura);
    }
}
