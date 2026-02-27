package org.example.muxtamel_fc.excepciones;

/**
 * Excepción en caso de añadir un masajista duplicado.
 */
public class MasajistaDuplicadoException extends RuntimeException {
    public MasajistaDuplicadoException() {
        super("El masajista ya existe");
    }
}
