package org.example.excepciones.cajero_automatico;

public class LimiteDiarioException extends RuntimeException
{
    public LimiteDiarioException()
    {
        super("Límite de retirada diario excedido.");
    }
}
