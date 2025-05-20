package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class AdminController {
    private Banco bancoAsociado;

    public AdminController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    //Metodo para que el Administrador pueda iniciar sesion.
    //Sebas, no hay necesidad de que el controller imprima algo,
    //eso lo hace el viewcontroller.
    public Usuario AdmininiciarSesion(String id, String password) {
        return bancoAsociado.validarCredenciales(id, password);
    }

    //Metodos relacionados a la gestion de cajeros
    public boolean registrarCajero(Usuario nuevoCajero) throws Exception {
        return bancoAsociado.registrarUsuario(nuevoCajero);
    }

    public boolean eliminarCajero(Usuario cajero) {
        return bancoAsociado.eliminarUsuario(cajero.getId());
    }

    public boolean actualizarCajero(Usuario cajero) {
        return bancoAsociado.actualizarUsuario(cajero);
    }
}