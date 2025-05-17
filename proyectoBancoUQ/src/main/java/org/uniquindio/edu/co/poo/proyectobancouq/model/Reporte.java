package org.uniquindio.edu.co.poo.proyectofinalbanco.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reporte {

    // atributos
    private TipoTransferencia tipoReporte;
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

    public TipoTransferencia getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoTransferencia tipoReporte) {
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

    public Reporte(TipoTransferencia tipoReporte, LocalDate fechaReporte) {
        this.tipoReporte = tipoReporte;
        this.fechaReporte = fechaReporte;
        this.listTransacciones = new ArrayList<>();
    }
}
