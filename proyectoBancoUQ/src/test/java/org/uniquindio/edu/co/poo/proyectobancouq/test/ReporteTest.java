package org.uniquindio.edu.co.poo.proyectobancouq.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Reporte;
import org.uniquindio.edu.co.poo.proyectobancouq.model.TipoTransaccion;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Transaccion;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReporteTest {
    private Banco banco;
    private List<Transaccion> transacciones;
    private Transaccion transaccion1;
    private Transaccion transaccion2;
    private Transaccion transaccionFraudulenta;

    @BeforeEach
    void setUp() throws Exception {
        banco = new Banco("UQ", "12");
        transacciones = new ArrayList<>();

        transaccion1 = new Transaccion( LocalDate.now(), "5000", "Depósito normal", TipoTransaccion.DEPOSITO, banco);
        transaccion2 = new Transaccion( LocalDate.now(), "7000", "Retiro normal", TipoTransaccion.RETIRO, banco);
        transaccionFraudulenta = new Transaccion( LocalDate.now(), "15000", "Transferencia sospechosa", TipoTransaccion.TRANSFERENCIA, banco);

        transacciones.add(transaccion1);
        transacciones.add(transaccion2);
    }

    @Test
    void testGenerarReporteTransaccionesConDatos() {
        String reporte = Reporte.generarReporteTransacciones(transacciones);

        assertNotNull(reporte, "El reporte no debería ser null.");
        assertTrue(reporte.contains("TX001"), "La transacción TX001 no aparece en el reporte.");
        assertTrue(reporte.contains("TX002"), "La transacción TX002 no aparece en el reporte.");
    }

    @Test
    void testGenerarReporteTransaccionesSinDatos() {
        String reporte = Reporte.generarReporteTransacciones(new ArrayList<>());

        assertEquals("📋 Reporte de Transacciones - Generado: " + LocalDate.now() + "\n⚠ No hay transacciones registradas.\n",
                reporte, "El mensaje de reporte vacío no es correcto.");
    }

    @Test
    void testGenerarReporteFraudesSinTransaccionesSospechosas() {
        String reporte = Reporte.generarReporteFraudes(transacciones);

        assertFalse(reporte.contains("⚠ ALERTA"), "No debería haber alertas de fraude en transacciones normales.");
    }

    @Test
    void testGenerarReporteFraudesConTransaccionSospechosa() {
        transacciones.add(transaccionFraudulenta);
        String reporte = Reporte.generarReporteFraudes(transacciones);

        assertTrue(reporte.contains("TXFRAUDE"), "La transacción fraudulenta no aparece en el reporte.");
        assertTrue(reporte.contains("⚠ ALERTA"), "No se detectó una transacción sospechosa.");
    }

    @Test
    void testConstructorReporte() {
        Reporte reporte = new Reporte(TipoTransaccion.RETIRO, LocalDate.now());

        assertEquals(TipoTransaccion.RETIRO, reporte.getTipoReporte(), "`TipoReporte` no se inicializó correctamente.");
        assertEquals(LocalDate.now(), reporte.getFechaReporte(), "`FechaReporte` no se inicializó correctamente.");
    }
}
