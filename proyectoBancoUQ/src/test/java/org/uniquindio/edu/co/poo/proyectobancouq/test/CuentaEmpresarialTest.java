package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaEmpresarial;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaEmpresarialTest {
    private CuentaEmpresarial cuentaEmpresarial;

    @BeforeEach
    void setUp() {
        cuentaEmpresarial = new CuentaEmpresarial("789456", 25000.0);
    }

    @Test
    void testConstructorCuentaEmpresarial() {
        assertEquals("789456", cuentaEmpresarial.getNumeroCuenta(), "❌ Número de cuenta incorrecto.");
        assertEquals(25000.0, cuentaEmpresarial.getSaldo(), "❌ Saldo incorrecto.");
    }

    @Test
    void testHerenciaCuentaBancaria() {
        assertTrue(cuentaEmpresarial instanceof CuentaBancaria, "❌ `CuentaEmpresarial` no hereda correctamente de `CuentaBancaria`.");
    }

    @Test
    void testModificarSaldo() {
        cuentaEmpresarial.setSaldo(30000.0);
        assertEquals(30000.0, cuentaEmpresarial.getSaldo(), "❌ El saldo no se actualizó correctamente.");
    }
}
