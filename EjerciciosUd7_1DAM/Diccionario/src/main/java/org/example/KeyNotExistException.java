package org.example;

public class KeyNotExistException extends RuntimeException {
    public KeyNotExistException() {
        super("La palabra no está en el diccionario.");
    }
}
