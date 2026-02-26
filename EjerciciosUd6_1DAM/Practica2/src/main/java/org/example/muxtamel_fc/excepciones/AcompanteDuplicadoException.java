package org.example.muxtamel_fc.excepciones;

public class AcompanteDuplicadoException extends RuntimeException {
    public AcompanteDuplicadoException() {
        super("EL acompañante ya ha sido creado.");
    }
}
