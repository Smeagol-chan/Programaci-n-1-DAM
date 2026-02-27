package org.example.muxtamel_fc.excepciones;

/**
 * Excepción en caso de añadir un jugador con el mismo dorsal que otro jugador del mismo equipo.
 */
public class DorsalDuplicadoExcepcion extends RuntimeException
{
    public DorsalDuplicadoExcepcion()
    {
        super("El dorsal ya existe.");
    }
}
