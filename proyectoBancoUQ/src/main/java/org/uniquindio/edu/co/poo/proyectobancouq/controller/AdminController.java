package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;

import java.util.Optional;

public class AdminController {
    private final Banco banco;

    public AdminController(Banco banco) {
        if (banco == null) {
            throw new IllegalArgumentException("Banco no puede ser null");
        }
        this.banco = banco;
        System.out.println("AdminController iniciado");
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

    public Usuario iniciarSesionCajero(String idUnico, String password) {
        Optional<Usuario> usuarioOpt = banco.buscarUsuario(idUnico);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            System.out.println("🔍 Usuario encontrado al iniciar sesión: " + usuario);
            System.out.println("📌 Tipo de usuario recuperado: " + usuario.getClass().getSimpleName());

            if (usuario instanceof Cajero && usuario.getPassword().equals(password)) {
                System.out.println("✅ Usuario autenticado correctamente.");
                return usuario;
            } else {
                System.out.println("❌ Error: Contraseña incorrecta o el usuario no es un cajero.");
            }
        } else {
            System.out.println("❌ Error: Usuario no encontrado.");
        }

        return null;
    }


}