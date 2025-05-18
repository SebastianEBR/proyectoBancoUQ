package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reporte {

    // atributos
    private TipoTransaccion tipoReporte;
    private LocalDate fechaReporte;

    // conexion con otras clases
    private List<Transaccion> listTransacciones;

    @Override
    public String toString() {
        return "Reporte{" +
                "tipoReporte=" + tipoReporte +
                ", fechaReporte=" + fechaReporte +
                ", listTransacciones=" + listTransacciones +
                '}';
    }

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

    public List<Transaccion> getListTransacciones() {
        return listTransacciones;
    }

    public void setListTransacciones(List<Transaccion> listTransacciones) {
        this.listTransacciones = listTransacciones;
    }

    public Reporte(TipoTransaccion tipoReporte, LocalDate fechaReporte) {
        this.tipoReporte = tipoReporte;
        this.fechaReporte = fechaReporte;
        this.listTransacciones = new ArrayList<>();
    }
}
