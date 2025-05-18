package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.time.LocalDate;

public interface IValidarDatos {

    boolean validarDatos(String codigo, LocalDate fecha, String monto, String descripcion, TipoTransaccion tipoTransaccion) throws Exception;
}
