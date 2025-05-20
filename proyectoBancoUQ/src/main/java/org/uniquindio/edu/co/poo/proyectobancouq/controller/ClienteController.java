package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class ClienteController {
    private Banco bancoAsociado;

    public ClienteController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    void verInfoCuenta(String numeroCuenta) {
        bancoAsociado.verInfoCuenta(numeroCuenta);
    }

    public void iniciarSesion(String id, String password) {
        Usuario usuario = bancoAsociado.validarCredenciales(id, password);
        if (usuario != null) {
            System.out.println("Bienvenido, " + usuario.getNombre());
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }
}
