package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.TipoCuenta;

import static org.junit.jupiter.api.Assertions.*;


class TipoCuentaTest {

    @Test
    void testValoresTipoCuenta() {
        // Verificar valores asignados a cada constante del enum
        assertEquals(0, TipoCuenta.C_AHORRO.getValor());
        assertEquals(1, TipoCuenta.C_CORRIENTE.getValor());
        assertEquals(2, TipoCuenta.C_EMPRESARIAL.getValor());
    }

    @Test
    void testEnumNombre() {
        // Verificar que el nombre de cada constante es el esperado
        assertEquals("C_AHORRO", TipoCuenta.C_AHORRO.name());
        assertEquals("C_CORRIENTE", TipoCuenta.C_CORRIENTE.name());
        assertEquals("C_EMPRESARIAL", TipoCuenta.C_EMPRESARIAL.name());
    }

}