package org.uniquindio.edu.co.poo.proyectobancouq.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.uniquindio.edu.co.poo.proyectobancouq.model.TipoTransferencia;

class TipoTransferenciaTest {

    @Test
    void testValoresTipoTransferencia() {
        // Verificar valores asignados a cada constante del enum
        assertEquals(0, TipoTransferencia.DEPOSITO.getValor());
        assertEquals(1, TipoTransferencia.RETIRO.getValor());
        assertEquals(3, TipoTransferencia.TRANSFERENCIA.getValor());
    }

    @Test
    void testEnumNombre() {
        // Verificar que los nombres de las constantes sean los esperados
        assertEquals("DEPOSITO", TipoTransferencia.DEPOSITO.name());
        assertEquals("RETIRO", TipoTransferencia.RETIRO.name());
        assertEquals("TRANSFERENCIA", TipoTransferencia.TRANSFERENCIA.name());
    }
}
