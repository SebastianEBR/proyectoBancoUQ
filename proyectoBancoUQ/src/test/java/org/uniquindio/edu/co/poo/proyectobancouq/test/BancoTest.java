package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    private Banco banco;
    private Cliente cliente1;
    private Admin cliente2;
    private Cliente cliente3;
    private CuentaBancaria cuenta1;
    private CuentaBancaria cuenta2;
    private Transaccion transaccion1;
    private Transaccion transaccion2;
    private Transaccion transaccion3;

    @BeforeEach
    void setUp() throws Exception {
        banco = new Banco("Banco UQ", "123456");
        cliente1 = new Cliente("101", "Juan", "@gmail", "1234");
        cliente2 = new Admin("101", "Sebas", "@gmail", "1234", "02");
        cliente3 = new Cliente("102", "PP", "@gmail", "1234");
        cuenta1 = new CuentaAhorros("147", 5000);
        cuenta2 = new CuentaCorriente("145", 5000);
        transaccion1 = new Transaccion("TX001", LocalDate.now(), "2000", "Depostito", TipoTransaccion.DEPOSITO, banco);
        transaccion2 = new Transaccion("TX002", LocalDate.now(), "2000", "retirio", TipoTransaccion.RETIRO, banco);
        transaccion3 = new Transaccion("TX001", LocalDate.now(), "2000", "trnasferencia", TipoTransaccion.TRANSFERENCIA, banco);
    }

    @Test
    // test para el metodo registrarUsuario con Cliente
    void testRegistrarUsuario() throws Exception {
        boolean registrado = banco.registrarUsuario(cliente1, cuenta1);
        assertTrue(registrado);
        assertEquals(1, banco.getListUsuarios().size());
    }

    @Test
    void testRegistrarUsuarioDuplicado() {
        assertDoesNotThrow(() -> banco.registrarUsuario(cliente1));

        Exception exception = assertThrows(Exception.class, () -> banco.registrarUsuario(cliente2));
        assertEquals("Ya existe un usuario con ese ID", exception.getMessage());
    }

    @Test
    void testBuscarUsuario() throws Exception {
        banco.registrarUsuario(cliente1);
        Optional<Usuario> usuarioEncontrado = banco.buscarUsuario("101");

        assertTrue(usuarioEncontrado.isPresent());
        assertEquals("Juan", usuarioEncontrado.get().getNombre());
    }

    @Test
    void testEliminarUsuario() throws Exception {
        banco.registrarUsuario(cliente3);
        boolean eliminado = banco.eliminarUsuario("102");

        assertTrue(eliminado);
        assertTrue(banco.buscarUsuario("102").isEmpty());
    }

    @Test
    void testRegistrarCuenta() throws Exception {

        boolean registrada = banco.registrarCuenta(cuenta1);
        banco.registrarCuenta(cuenta2);

        assertTrue(registrada);
        assertEquals(2, banco.getListCuentasBancarias().size());
    }

    @Test
    void testAgregarCuentaCliente() throws Exception {
        banco.agregarCuentaCliente(cuenta2, cliente1);

        assertTrue(banco.buscarCuenta("145").isPresent());
        assertTrue(cliente1.getListCuentaBancaria().contains(cuenta2));
        assertEquals(cliente1, cuenta2.getCliente());
    }

    @Test
    void testRegistrarTransaccion() throws Exception {
        banco.registrarUsuario(cliente1, cuenta1);
        banco.agregarCuentaCliente(cuenta2, cliente1);
        boolean registrada = banco.registrarTransaccion(transaccion3, "145", "147");

        assertTrue(registrada);
        assertEquals(1, banco.getListTransacciones().size());
    }

    @Test
    void testVerInfoTransaccion() throws Exception {
        banco.verInfoTransaccion("145");
    }
}
