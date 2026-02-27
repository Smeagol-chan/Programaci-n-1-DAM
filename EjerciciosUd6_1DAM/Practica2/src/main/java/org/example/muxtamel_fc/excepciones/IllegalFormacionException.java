package org.example.muxtamel_fc.excepciones;

/**
 * Excepción en caso de introducir una formación que incumple el formato establecido.
 */
public class IllegalFormacionException extends RuntimeException {
    public IllegalFormacionException()
    {
        super("Formato de formación erróneo.");
    }
}
