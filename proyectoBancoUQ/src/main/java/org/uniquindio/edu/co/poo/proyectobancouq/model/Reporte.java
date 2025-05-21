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

    public static String generarReporteMovimientos(List<Transaccion> transacciones) {
        String reporte = "📋 Reporte de Movimientos - Fecha: " + LocalDate.now() + "\n";

        if (transacciones.isEmpty()) {
            reporte += "⚠ No hay transacciones registradas.\n";
        } else {
            for (Transaccion transaccion : transacciones) {
                reporte += "🔹 " + transaccion.getFecha() + " | " + transaccion.getTipoTransaccion() + " | $" + transaccion.getMonto() + "\n";
            }
        }

        return reporte;
    }
}
