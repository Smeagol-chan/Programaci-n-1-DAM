package org.example.excepciones.cajero_automatico;

public class SaldoInsuficienteException extends RuntimeException
{
    public SaldoInsuficienteException()
    {
        super("Saldo insuficiente.");
    }
}
