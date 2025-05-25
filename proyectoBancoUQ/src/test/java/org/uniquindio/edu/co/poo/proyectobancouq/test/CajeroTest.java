package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cajero;

public class CajeroTest {
    private Cajero cajero;

    @BeforeEach
    void setUp() {
        cajero = new Cajero("C001", "Pedro", "pedro@email.com", "securePass", "CJ-100");
    }

    @Test
    void testConstructorCajero() {
        assertEquals("C001", cajero.getId(), "ID incorrecto.");
        assertEquals("Pedro", cajero.getNombre(), "Nombre incorrecto.");
        assertEquals("pedro@email.com", cajero.getEmail(), "Email incorrecto.");
        assertEquals("securePass", cajero.getPassword(), "Contraseña incorrecta.");
        assertEquals("CJ-100", cajero.getCodigo(), "Código incorrecto.");
    }

    @Test
    void testGetCodigo() {
        assertEquals("CJ-100", cajero.getCodigo(), "Código debería ser CJ-100.");
    }

    @Test
    void testSetCodigo() {
        cajero.setCodigo("CJ-200");
        assertEquals("CJ-200", cajero.getCodigo(), "Código no se actualizó correctamente.");
    }

    @Test
    void testToString() {
        String textoCajero = cajero.toString();
        assertTrue(textoCajero.contains("Cajero:"), "`toString()` no incluye 'Cajero:'.");
        assertTrue(textoCajero.contains("CJ-100"), "`toString()` no incluye el código.");
    }
}
