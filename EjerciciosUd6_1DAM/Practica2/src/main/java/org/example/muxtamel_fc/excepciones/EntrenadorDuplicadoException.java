package org.example.muxtamel_fc.excepciones;

public class EntrenadorDuplicadoException extends RuntimeException {
    public EntrenadorDuplicadoException() {
        super("Ya hay un entrenador para este equipo.");
    }
}
