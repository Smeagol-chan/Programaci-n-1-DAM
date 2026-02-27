package org.example.muxtamel_fc.excepciones;

/**
 * Excepción en caso de añadir un acompañante duplicado.
 */
public class AcompanteDuplicadoException extends RuntimeException {
    public AcompanteDuplicadoException() {
        super("EL acompañante ya ha sido creado.");
    }
}
