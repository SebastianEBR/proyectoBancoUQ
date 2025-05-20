package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    private Banco banco;

    @BeforeEach
    void setUp() {
        banco = new Banco("Banco UQ", "123456");
    }

    @Test
    // test para el metodo registrarUsuario con Cliente
    void testRegistrarUsuario() throws Exception {
        Cliente cliente = new Cliente("Juan", "1001", "@gmail", "1234");
        boolean registrado = banco.registrarUsuario(cliente);
        assertTrue(registrado);
        assertEquals(1, banco.getListUsuarios().size());
    }

    @Test
    void testRegistrarUsuarioDuplicado() {
        Cliente cliente = new Cliente("Juan", "1001", "@gmail", "1234");
        assertDoesNotThrow(() -> banco.registrarUsuario(cliente));

        Exception exception = assertThrows(Exception.class, () -> banco.registrarUsuario(cliente));
        assertEquals("Ya existe un usuario con ese ID", exception.getMessage());
    }

    @Test
    void testBuscarUsuario() throws Exception {
        Cliente cliente = new Cliente("1002", "Carlos", "@gmail", "1234");
        banco.registrarUsuario(cliente);
        Optional<Usuario> usuarioEncontrado = banco.buscarUsuario("1002");

        assertTrue(usuarioEncontrado.isPresent());
        assertEquals("Carlos", usuarioEncontrado.get().getNombre());
    }

    @Test
    void testEliminarUsuario() throws Exception {
        Cliente cliente = new Cliente("1003", "Ana", "@gmail", "1234");
        banco.registrarUsuario(cliente);
        boolean eliminado = banco.eliminarUsuario("1003");

        assertTrue(eliminado);
        assertTrue(banco.buscarUsuario("1003").isEmpty());
    }

    @Test
    void testRegistrarCuenta() throws Exception {
        Cliente cliente = new Cliente("1004", "Ana", "@gmail", "1234");
        CuentaAhorros cuenta = new CuentaAhorros("12345", 20000, cliente);
        boolean registrada = banco.registrarCuenta(cuenta, cliente);

        assertTrue(registrada);
        assertEquals(1, banco.getListCuentasBancarias().size());
    }

    @Test
    void testEliminarCuenta() throws Exception {
        Cliente cliente = new Cliente("1005", "Ana", "@gmail", "1234");
        CuentaAhorros cuenta = new CuentaAhorros("67890", 100000, cliente);
        banco.registrarCuenta(cuenta, cliente);
        boolean eliminada = banco.eliminarCuenta("67890");

        assertTrue(eliminada);
        assertTrue(banco.buscarCuenta("67890").isEmpty());
    }

    @Test
    void testRegistrarTransaccion() throws Exception {
        Transaccion transaccion = new Transaccion("TX001", LocalDate.now(), "2000", "Depostito", TipoTransaccion.TRANSFERENCIA, banco);
        boolean registrada = banco.registrarTransaccion(transaccion, "12");

        assertTrue(registrada);
        assertEquals(1, banco.getListTransacciones().size());
    }

    @Test
    void testEliminarTransaccion() throws Exception {
        Transaccion transaccion = new Transaccion("TX002", LocalDate.now(), "50.0", "Depostito", TipoTransaccion.TRANSFERENCIA, banco);
        banco.registrarTransaccion(transaccion, "12");
        boolean eliminada = banco.eliminarTransaccion("TX002");

        assertTrue(eliminada);
        assertTrue(banco.buscarTransaccion("TX002").isEmpty());
    }
}
