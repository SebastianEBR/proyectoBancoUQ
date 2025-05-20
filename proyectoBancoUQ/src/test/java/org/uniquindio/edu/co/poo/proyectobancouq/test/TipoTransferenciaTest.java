package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.TipoTransaccion;

class TipoTransferenciaTest {

    @Test
    void testValoresTipoTransferencia() {
        // Verificar valores asignados a cada constante del enum
        assertEquals(0, TipoTransaccion.DEPOSITO.getValor());
        assertEquals(1, TipoTransaccion.RETIRO.getValor());
        assertEquals(3, TipoTransaccion.TRANSFERENCIA.getValor());
    }

    @Test
    void testEnumNombre() {
        // Verificar que los nombres de las constantes sean los esperados
        assertEquals("DEPOSITO", TipoTransaccion.DEPOSITO.name());
        assertEquals("RETIRO", TipoTransaccion.RETIRO.name());
        assertEquals("TRANSFERENCIA", TipoTransaccion.TRANSFERENCIA.name());
    }
}
