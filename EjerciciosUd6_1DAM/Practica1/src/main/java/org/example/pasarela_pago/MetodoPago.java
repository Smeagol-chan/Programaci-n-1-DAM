package org.example.pasarela_pago;

public abstract class MetodoPago
{
    public void mostrarInfo() {}

    public abstract void procesarPago(double importe);
}
