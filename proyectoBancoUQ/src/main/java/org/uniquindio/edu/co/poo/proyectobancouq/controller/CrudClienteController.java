package org.uniquindio.edu.co.poo.proyectobancouq.controller;


import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cliente;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;

import java.util.Optional;

public class CrudClienteController {
    private final Banco banco;  // ✅ Mantén solo el atributo Banco

    public CrudClienteController(Banco banco) {
        this.banco = banco;
    }

    // Registrar Cliente con cuenta bancaria
    public boolean registrarCliente(Cliente cliente, CuentaBancaria cuenta) {
        try {
            return banco.registrarCliente(cliente, cuenta);
        } catch (Exception e) {
            System.out.println("❌ Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    // Actualizar Cliente
    public boolean actualizarCliente(Cliente cliente) {
        return banco.actualizarCliente(cliente);
    }

    // Eliminar Cliente y sus cuentas bancarias
    public boolean eliminarCliente(String id) {
        return banco.eliminarCliente(id);
    }

    // Buscar Cliente
    public Optional<Cliente> buscarCliente(String id) {
        return banco.buscarCliente(id);
    }

    // Registrar Cuenta para Cliente
    public boolean registrarCuenta(CuentaBancaria cuenta) {
        try {
            return banco.registrarCuenta(cuenta);
        } catch (Exception e) {
            System.out.println("❌ Error al registrar cuenta bancaria: " + e.getMessage());
            return false;
        }
    }

    // Eliminar Cuenta Bancaria
    public boolean eliminarCuenta(String numeroCuenta) {
        return banco.eliminarCuenta(numeroCuenta);
    }

    // Buscar Cuenta Bancaria
    public Optional<CuentaBancaria> buscarCuenta(String numeroCuenta) {
        return banco.buscarCuenta(numeroCuenta);
    }
}