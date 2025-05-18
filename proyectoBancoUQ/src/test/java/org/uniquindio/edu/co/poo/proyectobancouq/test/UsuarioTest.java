package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cliente;
import org.uniquindio.edu.co.poo.proyectobancouq.model.CuentaBancaria;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

import java.util.ArrayList;

class UsuarioTest {

    @Test
    void testCreacionUsuario() {
        // Instancia de Usuario (debe ser una subclase, ya que Usuario es abstracta)
        Usuario usuario = new Cliente("Juan Pérez", "1234", "juan@example.com", "clave123");

        // Verificar que los valores iniciales son correctos
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("1234", usuario.getId());
        assertEquals("juan@example.com", usuario.getEmail());
        assertEquals("clave123", usuario.getPassword());
    }

    @Test
    void testModificacionDatosUsuario() {
        Usuario usuario = new Cliente("Ana Gómez", "5678", "ana@example.com", "pass456");

        // Modificar valores
        usuario.setNombre("Ana Martínez");
        usuario.setEmail("ana.martinez@example.com");
        usuario.setPassword("nuevaClave");

        // Verificar que los cambios se reflejan correctamente
        assertEquals("Ana Martínez", usuario.getNombre());
        assertEquals("ana.martinez@example.com", usuario.getEmail());
        assertEquals("nuevaClave", usuario.getPassword());
    }

    @Test
    void testToString() {
        Usuario usuario = new Cliente("Carlos López", "9999", "carlos@example.com", "abc789");

        String esperado = "Cliente: " + "\n" +
                "\n Nombre: Carlos López" +
                "\n ID: 9999" +
                "\n Email: carlos@example.com" +
                "\n Cuentas: " + new ArrayList<CuentaBancaria>();

        assertEquals(esperado, usuario.toString());
    }
}
