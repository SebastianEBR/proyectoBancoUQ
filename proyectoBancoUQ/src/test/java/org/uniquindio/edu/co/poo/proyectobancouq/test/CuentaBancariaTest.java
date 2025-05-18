package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cliente;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;

class CuentaBancariaTest {

    // Subclase concreta para instanciar `CuentaBancaria`, ya que es abstracta
    static class CuentaBancariaDummy extends CuentaBancaria {
        public CuentaBancariaDummy(String numeroCuenta, double saldo, Cliente cliente) {
            super(numeroCuenta, saldo, cliente);
        }
    }

    @Test
    void testCreacionCuentaBancaria() {
        Cliente cliente = new Cliente("1234", "Juan Pérez", "juan@example.com", "clave123");
        CuentaBancaria cuenta = new CuentaBancariaDummy("987654321", 5000.0, cliente);

        assertEquals("987654321", cuenta.getNumeroCuenta());
        assertEquals(5000.0, cuenta.getSaldo());
        assertEquals(cliente, cuenta.getCliente());
    }

    @Test
    void testModificacionDatosCuenta() {
        Cliente cliente = new Cliente("5678", "Ana Gómez", "ana@example.com", "pass456");
        CuentaBancaria cuenta = new CuentaBancariaDummy("1122334455", 10000.0, cliente);

        cuenta.setSaldo(15000.0);
        cuenta.setNumeroCuenta("5566778899");

        assertEquals(15000.0, cuenta.getSaldo());
        assertEquals("5566778899", cuenta.getNumeroCuenta());
    }

    @Test
    void testToString() {
        Cliente cliente = new Cliente("9999", "Carlos López", "carlos@example.com", "abc789");
        CuentaBancaria cuenta = new CuentaBancariaDummy("1234567890", 7500.0, cliente);

        String esperado = "CuentaBancaria: " +
                "\n numero de cuenta: 1234567890" +
                "\n saldo: 7500.0" +
                "\n cliente: " + cliente; // Esto depende del `toString()` de Cliente

        assertEquals(esperado, cuenta.toString());
    }
}
