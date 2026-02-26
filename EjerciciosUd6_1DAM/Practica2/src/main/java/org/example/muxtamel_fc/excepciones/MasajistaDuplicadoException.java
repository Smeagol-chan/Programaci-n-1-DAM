package org.example.muxtamel_fc.excepciones;

public class MasajistaDuplicadoException extends RuntimeException {
    public MasajistaDuplicadoException() {
        super("El masajista ya existe");
    }
}
