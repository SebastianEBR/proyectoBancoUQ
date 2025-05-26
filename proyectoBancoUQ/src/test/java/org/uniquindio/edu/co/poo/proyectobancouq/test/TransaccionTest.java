package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.uniquindio.edu.co.poo.proyectobancouq.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    private Banco banco;
    private Cliente cliente;
    private Cliente cliente2;
    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    @BeforeEach
    void setUp() throws Exception {
        banco = new Banco("Banco UQ", "123456");
        cliente = new Cliente("1000", "Sebas", "@gmail", "1234");
        cliente2 = new Cliente("1100", "Pao", "@gmail", "3210");

        cuentaOrigen = new CuentaCorriente("1001", 5000);
        cuentaDestino = new CuentaCorriente("1002", 3000);

        banco.registrarUsuario(cliente, cuentaOrigen);
        banco.registrarUsuario(cliente2, cuentaDestino);
    }

    @Test
    void testRegistrarTransaccion() throws Exception {
        Transaccion transaccion = new Transaccion( LocalDate.now(), "2000f", "Depósito", TipoTransaccion.TRANSFERENCIA, banco);
        boolean registrada = banco.registrarTransaccion(transaccion, "1001", "1002");

        assertTrue(registrada);
        assertEquals(1, banco.getListTransacciones().size());
    }

    @Test
    void testTransaccionMontoInvalido() {
        Exception exception = assertThrows(Exception.class, () ->
                new Transaccion( LocalDate.now(), "abc", "Monto inválido", TipoTransaccion.DEPOSITO, banco));

        assertEquals("❌ El monto debe ser un número válido, sin letras ni símbolos.", exception.getMessage());
    }
    @Test
    void testTransaccionFechaNull() {
        Exception exception = assertThrows(Exception.class, () ->
                new Transaccion( null, "2000", "Fecha inválida", TipoTransaccion.DEPOSITO, banco));

        assertEquals("❌ La fecha no puede ser nula.", exception.getMessage());
    }

    @Test
    void testVerSaldoCuentaExistente() throws Exception {
        double saldo = cuentaOrigen.getSaldo();
        assertEquals(saldo, banco.buscarCuenta("1001").get().getSaldo(), "❌ El saldo no coincide.");
    }

    @Test
    void testVerSaldoCuentaInexistente() {
        Exception exception = assertThrows(Exception.class, () -> banco.buscarCuenta("9999").get().getSaldo());
        assertEquals("❌ No se encuentra una cuenta con ese número de cuenta.", exception.getMessage());
    }

    @Test
    void testDepositoMontoNegativo() {
        Exception exception = assertThrows(Exception.class, () -> {
            Transaccion transaccion = new Transaccion( LocalDate.now(), "-500", "Monto negativo", TipoTransaccion.DEPOSITO, banco);
            transaccion.deposito(cuentaOrigen.getNumeroCuenta(), -500);
        });
        assertEquals("❌ El monto debe ser mayor a cero.", exception.getMessage());
    }

    @Test
    void testRegistrarTransaccionDuplicada() throws Exception {
        banco.registrarTransaccion(new Transaccion( LocalDate.now(), "2000", "Depósito", TipoTransaccion.DEPOSITO, banco), "1001");

        Exception exception = assertThrows(Exception.class, () ->
                banco.registrarTransaccion(new Transaccion( LocalDate.now(), "3000", "Intento duplicado", TipoTransaccion.RETIRO, banco), "1001"));

        assertEquals("Ya existe una transacción con ese código", exception.getMessage());
    }

    @Test
    void testDeposito() throws Exception {
        Transaccion transaccion = new Transaccion( LocalDate.now(), "1000", "Depósito", TipoTransaccion.DEPOSITO, banco);
        boolean exitoso = transaccion.deposito(cuentaOrigen.getNumeroCuenta(), 1000f);

        assertTrue(exitoso);
        assertEquals(6000f, cuentaOrigen.getSaldo());
    }

    @Test
    void testRetiroExitoso() throws Exception {
        Transaccion transaccion = new Transaccion( LocalDate.now(), "1500f", "Retiro", TipoTransaccion.RETIRO, banco);
        boolean exitoso = transaccion.retiro("1001", 1500f);

        assertTrue(exitoso);
        assertEquals(3500f, cuentaOrigen.getSaldo());
    }

    @Test
    void testRetiroFallidoSaldoInsuficiente() throws Exception {
        Transaccion transaccion = new Transaccion( LocalDate.now(), "6000f", "Retiro", TipoTransaccion.RETIRO, banco);
        banco.registrarTransaccion(transaccion, "1001");
        Exception exception = assertThrows(Exception.class, () -> transaccion.retiro("1001", 6000f));

        assertEquals("❌ Saldo insuficiente en la cuenta origen.", exception.getMessage());
    }

    @Test
    void testTransferenciaExitosa() throws Exception {
        Transaccion transaccion = new Transaccion( LocalDate.now(), "2000", "Transferencia", TipoTransaccion.TRANSFERENCIA, banco);
        boolean exitosa = transaccion.transferir("1001", "1002", 2000f);

        assertTrue(exitosa);
        assertEquals(3000f, cuentaOrigen.getSaldo());
        assertEquals(5000f, cuentaDestino.getSaldo());
    }

    @Test
    void testTransferenciaFallidaSaldoInsuficiente() throws Exception {
        Transaccion transaccion = new Transaccion( LocalDate.now(), "6000", "Transferencia", TipoTransaccion.TRANSFERENCIA, banco);
        Exception exception = assertThrows(Exception.class, () -> transaccion.transferir("1001", "1002", 6000f));

        assertEquals("❌ Saldo insuficiente en la cuenta origen.", exception.getMessage());
    }
}