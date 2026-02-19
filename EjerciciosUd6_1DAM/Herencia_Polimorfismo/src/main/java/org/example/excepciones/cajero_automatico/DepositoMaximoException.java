package org.example.excepciones.cajero_automatico;

public class DepositoMaximoException extends RuntimeException
{
    public DepositoMaximoException()
    {
        super("Depósito excedido.");
    }
}
