package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

import java.util.List;
import java.util.Optional;

public class CrudUsuarioController {
    private final Banco banco;

    public CrudUsuarioController(Banco banco) {
        this.banco = banco;
    }

    // Registrar Usuario (Admins/Cajeros)
    public boolean registrarUsuario(Usuario usuario) {
        try {
            return banco.registrarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("❌ Error al registrar usuario: " + e.getMessage());
            return false;
        }
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
        return banco.eliminarUsuario(id);
    }

    // Buscar Usuario
    public Optional<Usuario> buscarUsuario(String id) {
        return banco.buscarUsuario(id);
    }
}
