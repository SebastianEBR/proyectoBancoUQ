package org.uniquindio.edu.co.poo.proyectofinalbanco.model;

public enum TipoCuenta{
    // constantes (opciones)
    C_AHORRO(0),
    C_CORRIENTE(1),
    C_EMPRESARIAL(2);

    private int valor;

    TipoCuenta(int valor){
        this.valor = valor;
    }

    public int getValor(){return valor;}
}