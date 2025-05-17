package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    private Banco banco;
    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    @BeforeEach
    void setUp() {
        banco = new Banco("Banco UQ", "123456");
        Cliente cliente = new Cliente("1000", "Sebas", "@gmail", "1234");
        Cliente cliente2 = new Cliente("1100", "Pao", "@gmail", "3210");

        cuentaOrigen = new CuentaCorriente("1001", 5000f, cliente);
        cuentaDestino = new CuentaCorriente("1002", 3000, cliente2);

        try {
            banco.registrarCuenta(cuentaOrigen);
            banco.registrarCuenta(cuentaDestino);
        } catch (Exception e) {
            fail("Error al registrar cuentas: " + e.getMessage());
        }
    }

    @Test
    void testRegistrarTransaccion() throws Exception {
        Transaccion transaccion = new Transaccion("TX001", LocalDate.now(), 2000f, "Depósito", TipoTransferencia.TRANSFERENCIA, banco);
        boolean registrada = banco.registrarTransaccion(transaccion);

        assertTrue(registrada);
        assertEquals(1, banco.getListTransacciones().size());
    }

    @Test
    void testDeposito() throws Exception {
        Transaccion transaccion = new Transaccion("TX002", LocalDate.now(), 1000f, "Depósito", TipoTransferencia.DEPOSITO, banco);
        boolean exitoso = transaccion.deposito(cuentaOrigen, 1000f);

        assertTrue(exitoso);
        assertEquals(6000f, cuentaOrigen.getSaldo());
    }

    @Test
    void testRetiroExitoso() throws Exception {
        Transaccion transaccion = new Transaccion("TX003", LocalDate.now(), 1500f, "Retiro", TipoTransferencia.RETIRO, banco);
        boolean exitoso = transaccion.retiro("1001", 1500f);

        assertTrue(exitoso);
        assertEquals(3500f, cuentaOrigen.getSaldo());
    }

    @Test
    void testRetiroFallidoSaldoInsuficiente() {
        Transaccion transaccion = new Transaccion("TX004", LocalDate.now(), 6000f, "Retiro", TipoTransferencia.RETIRO, banco);
        Exception exception = assertThrows(Exception.class, () -> transaccion.retiro("1001", 6000f));

        assertEquals("❌ Saldo insuficiente en la cuenta origen.", exception.getMessage());
    }

    @Test
    void testTransferenciaExitosa() throws Exception {
        Transaccion transaccion = new Transaccion("TX005", LocalDate.now(), 2000f, "Transferencia", TipoTransferencia.TRANSFERENCIA, banco);
        boolean exitosa = transaccion.transferir("1001", "1002", 2000f);

        assertTrue(exitosa);
        assertEquals(3000f, cuentaOrigen.getSaldo());
        assertEquals(5000f, cuentaDestino.getSaldo());
    }

    @Test
    void testTransferenciaFallidaSaldoInsuficiente() {
        Transaccion transaccion = new Transaccion("TX006", LocalDate.now(), 6000f, "Transferencia", TipoTransferencia.TRANSFERENCIA, banco);
        Exception exception = assertThrows(Exception.class, () -> transaccion.transferir("1001", "1002", 6000f));

        assertEquals("❌ Saldo insuficiente en la cuenta origen.", exception.getMessage());
    }
}