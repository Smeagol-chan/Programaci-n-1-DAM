package org.example.muxtamel_fc.excepciones;

public class IllegalFormacionException extends RuntimeException {
    public IllegalFormacionException()
    {
        super("Formato de formación erróneo.");
    }
}
