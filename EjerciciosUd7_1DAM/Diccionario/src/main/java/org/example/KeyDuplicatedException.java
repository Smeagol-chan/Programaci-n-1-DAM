package org.example;

public class KeyDuplicatedException extends RuntimeException {
    public KeyDuplicatedException() {
        super("La palabra en español ya está presente.");
    }
}
