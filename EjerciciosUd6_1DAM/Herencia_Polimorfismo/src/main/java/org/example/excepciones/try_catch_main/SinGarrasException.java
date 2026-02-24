package org.example.excepciones.try_catch_main;

public class SinGarrasException extends RuntimeException
{
    public SinGarrasException()
    {
        super("No le has puesto garras.");
    }
}
