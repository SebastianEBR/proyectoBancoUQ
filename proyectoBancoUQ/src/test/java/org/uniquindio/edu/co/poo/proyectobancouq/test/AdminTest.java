package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin("A001", "Carlos", "carlos@email.com", "admin123", "ADM-001");
    }

    @Test
    void testConstructorAdmin() {
        assertEquals("A001", admin.getId());
        assertEquals("Carlos", admin.getNombre());
        assertEquals("carlos@email.com", admin.getEmail());
        assertEquals("admin123", admin.getPassword());
        assertEquals("ADM-001", admin.getCodigo());
    }

    @Test
    void testGetCodigo() {
        assertEquals("ADM-001", admin.getCodigo());
    }

    @Test
    void testSetCodigo() {
        admin.setCodigo("ADM-002");
        assertEquals("ADM-002", admin.getCodigo());
    }

    @Test
    void testToString() {
        String esperado = "Admin: " + admin.toString() + "\n Codigo: ADM-001";
        assertTrue(admin.toString().contains("Admin:"));
        assertTrue(admin.toString().contains("Codigo: ADM-001"));
    }
}
