package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class CajeroController {
    private Banco bancoAsociado;

    public CajeroController(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    //Metodo para que el cajero pueda iniciar sesion.
    //    //Sebas, no hay necesidad de que el controller imprima algo,
    //    // eso lo hace el viewcontroller.
    public Usuario CajeroIniciarSesion(String id, String password) {
        return bancoAsociado.validarCredenciales(id, password);
    }

    //Metodos relacionados a la gestion de clientes
    public boolean agregarCliente(Usuario nuevoCliente) throws Exception {
        return bancoAsociado.registrarUsuario(nuevoCliente);
    }

    public boolean eliminarCliente(Usuario cliente) {
        return bancoAsociado.eliminarUsuario(cliente.getId());
    }

    public boolean actualizarCliente(Usuario cliente) {
        return bancoAsociado.actualizarUsuario(cliente);
    }
}