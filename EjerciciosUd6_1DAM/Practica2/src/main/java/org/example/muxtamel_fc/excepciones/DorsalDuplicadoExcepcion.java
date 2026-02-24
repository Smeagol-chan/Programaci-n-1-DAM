package org.example.muxtamel_fc.excepciones;

public class DorsalDuplicadoExcepcion extends RuntimeException
{
    public DorsalDuplicadoExcepcion()
    {
        super("El dorsal ya existe.");
    }
}
