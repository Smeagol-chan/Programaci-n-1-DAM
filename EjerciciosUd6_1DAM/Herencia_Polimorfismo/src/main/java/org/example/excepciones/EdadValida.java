package org.example.excepciones;

public class EdadValida extends RuntimeException
{
    public EdadValida()
    {
        super("Edad inválida.");
    }
}
