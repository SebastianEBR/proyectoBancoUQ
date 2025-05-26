package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reporte {

    // atributos
    private TipoTransaccion tipoReporte;
    private LocalDate fechaReporte;

    public TipoTransaccion getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoTransaccion tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }


    public Reporte(TipoTransaccion tipoReporte, LocalDate fechaReporte) {
        this.tipoReporte = tipoReporte;
        this.fechaReporte = fechaReporte;
    }

    public static String generarReporteTransacciones(List<Transaccion> transacciones) {
        String reporte = "📋 Reporte de Transacciones - Generado: " + java.time.LocalDate.now() + "\n";

        if (transacciones.isEmpty()) {
            reporte += "⚠ No hay transacciones registradas.\n";
        } else {
            for (Transaccion transaccion : transacciones) {
                reporte += "codigo: " + transaccion.getCodigo() + " | " + transaccion.getFecha() + " | " + transaccion.getTipoTransaccion() + " | $" + transaccion.getMonto() + "\n";
            }
        }

        return reporte;
    }

    public static String generarReporteFraudes(List<Transaccion> transacciones) {
        String reporte = "🚨 Reporte de Operaciones Sospechosas\n";

        for (Transaccion transaccion : transacciones) {
            if (Double.parseDouble(transaccion.getMonto()) > 10000) { // Ejemplo de transacción sospechosa
                reporte += "⚠ ALERTA - Transacción de alto valor: $" + transaccion.getMonto() + " - Fecha: " +
                        transaccion.getFecha() + "\n con codigo: " + transaccion.getCodigo() + "\n";
            }
        }

        return reporte;
    }
}
