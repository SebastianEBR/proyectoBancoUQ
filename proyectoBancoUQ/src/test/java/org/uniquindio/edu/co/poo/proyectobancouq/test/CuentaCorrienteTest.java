package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaCorriente;

public class CuentaCorrienteTest {
    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    void setUp() {
        cuentaCorriente = new CuentaCorriente("456789", 10000.0);
    }

    @Test
    void testConstructorCuentaCorriente() {
        assertEquals("456789", cuentaCorriente.getNumeroCuenta(), "❌ Número de cuenta incorrecto.");
        assertEquals(10000.0, cuentaCorriente.getSaldo(), "❌ Saldo incorrecto.");
    }

    @Test
    void testHerenciaCuentaBancaria() {
        assertTrue(cuentaCorriente instanceof CuentaBancaria, "❌ `CuentaCorriente` no hereda correctamente de `CuentaBancaria`.");
    }

    @Test
    void testModificarSaldo() {
        cuentaCorriente.setSaldo(15000.0);
        assertEquals(15000.0, cuentaCorriente.getSaldo(), "❌ El saldo no se actualizó correctamente.");
    }
}
