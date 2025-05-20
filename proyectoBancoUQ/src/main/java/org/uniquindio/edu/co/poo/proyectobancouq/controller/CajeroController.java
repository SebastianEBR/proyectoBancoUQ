package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class CajeroController {
    private Banco bancoAsociado;

    public CajeroController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    void agregarCliente(Usuario nuevoCliente) throws Exception {
        bancoAsociado.registrarUsuario(nuevoCliente);
    }

    void eliminarCajero(Usuario cliente) {
        bancoAsociado.eliminarUsuario(cliente.getId());
    }

    void actualizarCajero(Usuario cliente) {
        bancoAsociado.actualizarUsuario(cliente);
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
