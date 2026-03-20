package org.example;

public class EmptyDiccionaryException extends RuntimeException {
    public EmptyDiccionaryException() {
        super("El diccionario está vacío.");
    }
}
