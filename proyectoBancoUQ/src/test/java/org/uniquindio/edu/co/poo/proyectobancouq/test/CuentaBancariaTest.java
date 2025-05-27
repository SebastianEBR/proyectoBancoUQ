package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cliente;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;

class CuentaBancariaTest {

    // Subclase concreta para instanciar `CuentaBancaria`, ya que es abstracta
    static class CuentaBancariaDummy extends CuentaBancaria {
        public CuentaBancariaDummy(String numeroCuenta, double saldo) {
            super(numeroCuenta, saldo);
        }
    }

    @Test
    void testCreacionCuentaBancaria() throws Exception {
        Banco banco = new Banco("UQ", " 121");
        Cliente cliente = new Cliente("1234", "Juan Pérez", "juan@example.com", "clave123");
        CuentaBancaria cuenta = new CuentaBancariaDummy("987654321", 5000.0);
        banco.registrarCliente(cliente, cuenta);
        assertEquals("987654321", cuenta.getNumeroCuenta());
        assertEquals(5000.0, cuenta.getSaldo());
        assertEquals(cliente, cuenta.getCliente());
    }

    @Test
    void testModificacionDatosCuenta() throws Exception {
        Banco banco = new Banco("UQ", " 121");
        Cliente cliente = new Cliente("5678", "Ana Gómez", "ana@example.com", "pass456");
        CuentaBancaria cuenta = new CuentaBancariaDummy("987654321", 5000.0);
        banco.registrarCliente(cliente, cuenta);

        cuenta.setSaldo(15000.0);
        cuenta.setNumeroCuenta("5566778899");

        assertEquals(15000.0, cuenta.getSaldo());
        assertEquals("5566778899", cuenta.getNumeroCuenta());
    }

    @Test
    void testToString() throws Exception {
        Banco banco = new Banco("UQ", " 121");
        Cliente cliente = new Cliente("9999", "Carlos López", "carlos@example.com", "abc789");
        CuentaBancaria cuenta = new CuentaBancariaDummy("1234567890", 7500.0);
        banco.registrarCliente(cliente, cuenta);

        String esperado = "CuentaBancaria: " +
                "\n numero de cuenta: 1234567890" +
                "\n saldo: 7500.0" +
                "\n cliente: Carlos López";

        assertEquals(esperado, cuenta.toString());
    }
}
