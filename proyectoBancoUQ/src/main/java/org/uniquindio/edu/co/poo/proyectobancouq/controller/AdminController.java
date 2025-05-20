package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class AdminController {
    private Banco bancoAsociado;

    public AdminController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    void registrarCajero(Usuario nuevoCajero) throws Exception {
        bancoAsociado.registrarUsuario(nuevoCajero);
    }

    void eliminarCajero(Usuario cajero) {
        bancoAsociado.eliminarUsuario(cajero.getId());
    }

    void actualizarCajero(Usuario cajero) {
        bancoAsociado.actualizarUsuario(cajero);
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
