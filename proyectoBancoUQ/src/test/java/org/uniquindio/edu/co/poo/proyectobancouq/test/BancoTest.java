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
        cuenta1 = new CuentaAhorros("147", 1000000);
        cuenta2 = new CuentaCorriente("145", 10000000);
        transaccion1 = new Transaccion( LocalDate.now(), "2000", "Depostito", TipoTransaccion.DEPOSITO, banco);
        transaccion2 = new Transaccion( LocalDate.now(), "2000", "retirio", TipoTransaccion.RETIRO, banco);
        transaccion3 = new Transaccion( LocalDate.now(), "2000", "trnasferencia", TipoTransaccion.TRANSFERENCIA, banco);
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
        banco.registrarUsuario(cliente1, cuenta1);
        banco.agregarCuentaCliente(cuenta2, cliente1);
        boolean registrada = banco.registrarTransaccion(transaccion3, "145", "147");
        assertEquals(transaccion3.toString(), banco.verInfoTransaccion(transaccion3.getCodigo()));
    }

    @Test
    void testValidarCredencialesCorrectas() throws Exception {
        banco.registrarUsuario(cliente1, cuenta1);

        Usuario usuarioValidado = banco.validarCredenciales("101", "1234");
        assertNotNull(usuarioValidado, "El usuario no debería ser null.");
        assertEquals(cliente1, usuarioValidado, "Las credenciales deberían coincidir.");
    }

    @Test
    void testValidarCredencialesIncorrectas() {
        Usuario usuarioInvalido = banco.validarCredenciales("999", "wrongPass");
        assertNull(usuarioInvalido, "Un usuario inválido debería devolver null.");
    }

    @Test
    void testMonitoreoTransaccionSospechosa() throws Exception {
        Transaccion transaccionFraudulenta = new Transaccion(LocalDate.now(), "150000", "Transferencia Sospechosa", TipoTransaccion.TRANSFERENCIA, banco);
        banco.registrarUsuario(cliente1, cuenta1);
        banco.agregarCuentaCliente(cuenta2, cliente1);
        banco.registrarTransaccion(transaccionFraudulenta, "145", "147");
        banco.monitorearTransacciones(transaccionFraudulenta);

        String reporteFraudes = banco.generarReporteAvanzado("fraudes");
        assertTrue(reporteFraudes.contains("FRAUDE001"), "La transacción fraudulenta no aparece en el reporte.");
    }

    @Test
    void testGenerarReporteAvanzadoTransacciones() throws Exception {
        banco.registrarTransaccion(transaccion1, "145");

        String reporte = banco.generarReporteAvanzado("transacciones");
        assertNotNull(reporte, "El reporte no debería ser null.");
        assertTrue(reporte.contains("TX001"), "La transacción debería estar en el reporte.");
    }

    @Test
    void testGenerarReporteAvanzadoFraudes() throws Exception {
        banco.registrarUsuario(cliente1, cuenta1);
        banco.agregarCuentaCliente(cuenta2, cliente1);
        banco.registrarTransaccion(transaccion3, "145", "147");
        banco.monitorearTransacciones(transaccion3);
        String reporte = banco.generarReporteAvanzado("fraudes");
        assertNotNull(reporte, "El reporte de fraudes no debería ser null.");
        assertFalse(reporte.contains("TX003"), "La transacción no es sospechosa, no debería estar en el reporte.");
    }

    @Test
    void testGenerarReporteAvanzadoSinDatos() throws Exception {
        String reporte = banco.generarReporteAvanzado("transacciones");
        assertEquals("⚠ No hay transacciones registradas.", reporte, "El mensaje debería indicar que no hay datos.");
    }


}
