package org.uniquindio.edu.co.poo.proyectobancouq.controller;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;

public class CajeroController {
    private final Banco banco;

    public CajeroController(Banco banco) {
        this.banco = banco;
    }

    // Método de autenticación con validación de nombre, ID único y contraseña
    public Usuario iniciarSesion(String nombre, String idUnico, String password) {
        Usuario usuario = banco.buscarUsuario(idUnico).orElse(null);

        if (usuario != null && usuario.getNombre().equals(nombre)
                && usuario.getId().equals(idUnico)
                && usuario.getPassword().equals(password)) {
            return usuario;
        }

        return null;
    }

    // Métodos de gestión de clientes
    public boolean agregarCliente(Usuario nuevoCliente) throws Exception {
        return banco.registrarUsuario(nuevoCliente);
    }

    public boolean actualizarCliente(Usuario cliente) {
        return banco.actualizarUsuario(cliente);
    }

    public boolean eliminarCliente(String idCliente) {
        return banco.eliminarUsuario(idCliente);
    }

    // Métodos relacionados a cuentas bancarias
    public boolean registrarCuentaCliente(String idCliente, String numeroCuenta, double saldoInicial, String tipoCuenta) throws Exception {
        Usuario cliente = banco.buscarUsuario(idCliente).orElse(null);

        if (cliente == null) {
            throw new Exception("❌ Cliente no encontrado.");
        }

        CuentaBancaria nuevaCuenta;

        switch (tipoCuenta.toLowerCase()) {
            case "corriente":
                nuevaCuenta = new CuentaCorriente(numeroCuenta, saldoInicial);
                break;
            case "ahorros":
                nuevaCuenta = new CuentaAhorros(numeroCuenta, saldoInicial);
                break;
            case "empresarial":
                nuevaCuenta = new CuentaEmpresarial(numeroCuenta, saldoInicial);
                break;
            default:
                throw new Exception("❌ Tipo de cuenta inválido.");
        }

        return banco.registrarCuenta(nuevaCuenta);
    }

    public String verInfoCuenta(String numeroCuenta) {
        return banco.verInfoCuenta(numeroCuenta);
    }

    public boolean eliminarCuentaCliente(String numeroCuenta) {
        return banco.eliminarCuenta(numeroCuenta);
    }
}