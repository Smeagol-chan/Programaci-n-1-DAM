package org.example.pasarela_pago;

/**
 * Superclase al que pertenecen Bizum, PayPal y TarjetaCredito.
 * @author ericr
 * @version 1.0
 */
public abstract class MetodoPago
{
    /**
     * Función abstracta para validar los datos de cada objeto.
     * @return True o false dependiendo de si los datos con válidos o no.
     */
    public abstract boolean validarMetodo();

    /**
     * Procedimiento para mostrar al usuario si el pago ha sido procesado.
     * @param importe - Double con el costo que el usuario va a pagar.
     */
    public abstract void procesarPago(double importe);
}