package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;

public class ClienteController {
    private Banco bancoAsociado;

    public ClienteController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    // Metodo para que el cliente pueda iniciar sesion
    //Sebas, no hay necesidad de que el controller imprima algo,
    //eso lo hace el viewcontroller.
    public Usuario clienteIniciarSesion(String id, String password) {
        return bancoAsociado.validarCredenciales(id, password);
    }

    //Metodos relacionados a la gestion de cuentas
    public boolean registrarCuenta(CuentaBancaria newCuenta , Cliente cliente) throws Exception {
        return bancoAsociado.registrarCuenta(newCuenta, cliente);
    }


    public String verInfoCuenta(String numeroCuenta) {
        return bancoAsociado.verInfoCuenta(numeroCuenta);
    }

    //Metodos relacionados a las transacciones
    public boolean registrarTransaccion(Transaccion transaccion, String numeroCuenta, String... numeroCuenta2) throws Exception {
        return bancoAsociado.registrarTransaccion(transaccion, numeroCuenta, numeroCuenta2);
    }

    public boolean eliminarTransaccion(String numeroTransaccion) {
        return bancoAsociado.eliminarTransaccion(numeroTransaccion);
    }

    public String verInfoTransaccion(String numeroTransaccion) throws Exception {
        return bancoAsociado.verInfoTransaccion(numeroTransaccion);
    }
}