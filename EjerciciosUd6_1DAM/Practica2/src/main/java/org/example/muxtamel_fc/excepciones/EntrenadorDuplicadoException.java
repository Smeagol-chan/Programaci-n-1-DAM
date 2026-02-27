package org.example.muxtamel_fc.excepciones;

/**
 * Excepción en caso de añadir un entrenador a un equipo que ya tiene otro asignado.
 */
public class EntrenadorDuplicadoException extends RuntimeException {
    public EntrenadorDuplicadoException() {
        super("Ya hay un entrenador para este equipo.");
    }
}
