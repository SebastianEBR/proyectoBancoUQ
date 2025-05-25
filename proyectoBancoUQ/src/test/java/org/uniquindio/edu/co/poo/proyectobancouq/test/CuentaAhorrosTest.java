package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaAhorros;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;


public class CuentaAhorrosTest {
    private CuentaAhorros cuentaAhorros;

    @BeforeEach
    void setUp() {
        cuentaAhorros = new CuentaAhorros("147", 5000.0);
    }

    @Test
    void testConstructorCuentaAhorros() {
        assertEquals("147", cuentaAhorros.getNumeroCuenta(), "Número de cuenta incorrecto.");
        assertEquals(5000.0, cuentaAhorros.getSaldo(), "Saldo incorrecto.");
    }

    @Test
    void testHerenciaCuentaBancaria() {
        assertTrue(cuentaAhorros instanceof CuentaBancaria, "`CuentaAhorros` no hereda correctamente de `CuentaBancaria`.");
    }

    @Test
    void testModificarSaldo() {
        cuentaAhorros.setSaldo(8000.0);
        assertEquals(8000.0, cuentaAhorros.getSaldo(), "El saldo no se actualizó correctamente.");
    }
}
