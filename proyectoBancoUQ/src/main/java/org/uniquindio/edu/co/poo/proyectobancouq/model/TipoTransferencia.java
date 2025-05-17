package org.uniquindio.edu.co.poo.proyectofinalbanco.model;

public enum TipoTransferencia {

    DEPOSITO(0),
    RETIRO(1),
    TRANSFERENCIA(3);

    private final int valor;

    TipoTransferencia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
