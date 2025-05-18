package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;

public class ClienteController {
    private Banco bancoAsociado;

    public ClienteController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    void verInfoCuenta(String numeroCuenta) {
        bancoAsociado.verInfoCuenta(numeroCuenta);
    }
}
