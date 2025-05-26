package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;

public class ClienteController {
    private Banco bancoAsociado;

    public ClienteController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }


    public boolean registrarCuenta(CuentaBancaria newCuenta) throws Exception {
        return bancoAsociado.registrarCuenta(newCuenta);
    }


    public String verInfoCuenta(String numeroCuenta) {
        return bancoAsociado.verInfoCuenta(numeroCuenta); // ✅ Corrección
    }

    public boolean registrarTransaccion(Transaccion transaccion, String numeroCuenta, String... numeroCuenta2) throws Exception {
        return bancoAsociado.registrarTransaccion(transaccion, numeroCuenta, numeroCuenta2);
    }

    public String verInfoTransaccion(String numeroTransaccion) throws Exception {
        return bancoAsociado.verInfoTransaccion(numeroTransaccion);
    }
}