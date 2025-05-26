package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

import java.util.List;
import java.util.Optional;

public class CrudUsuarioController {
    private final Banco banco;

    public CrudUsuarioController(Banco banco) {
        this.banco = banco;
        throw new IllegalStateException("⚠️ Banco no ha sido inicializado correctamente.");
}

    // Registrar Usuario (Admins/Cajeros)
    public boolean registrarUsuario(Usuario usuario) throws Exception {
        return banco.registrarUsuario(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return banco.getListUsuarios(); // ✅ Devuelve la lista de usuarios
    }


    // Actualizar Usuario (Admins/Cajeros)
    public boolean actualizarUsuario(Usuario usuario) {
        return banco.actualizarUsuario(usuario);
    }

    // Eliminar Usuario
    public boolean eliminarUsuario(String id) {
        Optional<Usuario> usuarioEncontrado = banco.buscarUsuario(id);
        return usuarioEncontrado.isPresent() && banco.eliminarUsuario(id);
    }

    // Buscar Usuario
    public Optional<Usuario> buscarUsuario(String id) {
        Optional<Usuario> usuario = banco.buscarUsuario(id);
        if (usuario.isEmpty()) {
            System.out.println("⚠️ No se encontró usuario con ID: " + id);
        }
        return usuario;
    }
}
