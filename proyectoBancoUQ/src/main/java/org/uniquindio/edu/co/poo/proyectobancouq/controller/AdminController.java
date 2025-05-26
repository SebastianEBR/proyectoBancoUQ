package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class AdminController {
    private final Banco banco;

    public AdminController(Banco banco) {
        this.banco = banco;
    }

    // Método de autenticación del administrador con validación de nombre, ID único y contraseña
    public Usuario iniciarSesionAdmin(String nombre, String idUnico, String password) {
        Usuario usuario = banco.buscarUsuario(idUnico).orElse(null);

        if (usuario != null && usuario.getNombre().equals(nombre)
                && usuario.getId().equals(idUnico)
                && usuario.getPassword().equals(password)) {
            return usuario;
        }

        return null;
    }
}