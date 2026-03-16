package org.example.reserva_pistas.excepciones;

public class UsuarioOrPistaDuplicatedException extends RuntimeException {
    public UsuarioOrPistaDuplicatedException() {
        super("EL usuario o la pista ya están en una reserva previa a esta hora.");
    }
}
