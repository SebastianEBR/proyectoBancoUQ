package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteTest {
    private Banco banco;
    private Cliente cliente;
    private CuentaBancaria cuenta1;
    private CuentaBancaria cuenta2;

    @BeforeEach
    void setUp() {
        banco = new Banco("UQ", "12");
        cliente = new Cliente("C001", "Pedro", "pedro@email.com", "securePass");
        cuenta1 = new CuentaAhorros("Ahorros", 500000);
        cuenta2 = new CuentaCorriente("Corriente", 20000000);
    }

    @Test
    void testConstructorCliente() {
        assertEquals("C001", cliente.getId(), "ID incorrecto.");
        assertEquals("Pedro", cliente.getNombre(), "Nombre incorrecto.");
        assertEquals("pedro@email.com", cliente.getEmail(), "Email incorrecto.");
        assertEquals("securePass", cliente.getPassword(), "Contraseña incorrecta.");
        assertTrue(cliente.getListCuentaBancaria().isEmpty(), "La lista de cuentas debería estar vacía al inicio.");
    }

    @Test
    void testSetListCuentaBancaria() {
        List<CuentaBancaria> nuevaLista = new ArrayList<>();
        nuevaLista.add(cuenta1);
        nuevaLista.add(cuenta2);

        cliente.setListCuentaBancaria(nuevaLista);
        assertEquals(2, cliente.getListCuentaBancaria().size(), "La lista de cuentas no se actualizó correctamente.");
    }

    @Test
    void testAgregarCuenta() {
        cliente.agregarCuenta(cuenta1);
        assertTrue(cliente.getListCuentaBancaria().contains(cuenta1), "La cuenta no se agregó correctamente.");

        cliente.agregarCuenta(cuenta2);
        assertEquals(2, cliente.getListCuentaBancaria().size(), "No se agregaron las cuentas correctamente.");
    }

    @Test
    void testToString() throws Exception {
        banco.registrarUsuario(cliente, cuenta1);
        String textoCliente = cliente.toString();

        assertTrue(textoCliente.contains("Cliente:"), "`toString()` no incluye 'Cliente:'.");
        assertTrue(textoCliente.contains("Cuentas:"), "`toString()` no incluye la lista de cuentas.");
    }
}
