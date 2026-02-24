package org.example.muxtamel_fc.excepciones;

public class IllegalFormacionExpeccion extends RuntimeException {
    public IllegalFormacionExpeccion()
    {
        super("Formato de formación erróneo.");
    }
}
