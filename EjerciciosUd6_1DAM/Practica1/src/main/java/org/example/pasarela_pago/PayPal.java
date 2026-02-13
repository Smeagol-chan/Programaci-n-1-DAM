package org.example.pasarela_pago;
import lombok.Getter;
import lombok.Setter;
import org.example.FuncionesComunes;

/**
 * Objeto PayPal, clase hija de MetodoPago.
 * Sus atributos son el email y el saldo de la cuenta.
 * @author ericr
 * @version 1.0
 */
@Getter @Setter
public class PayPal extends MetodoPago
{
    //Constantes
    private static final int DEFAULT_SALDO = 23;
    private static final String FORMATO_CUENTA = "^[a-zA-Z0-9+_.-]+@[a-z]+.com$";

    //Atributos
    private String cuenta;
    private double saldo;

    /**
     * Constructor de PayPal.
     * cuenta se inicializa con la variable omónima.
     * saldo se inicializa con un valor por defecto.
     * @param cuenta - String con el email de la cuenta.
     */
    public PayPal(String cuenta)
    {
        this.cuenta = cuenta;
        saldo = DEFAULT_SALDO;
    }

    /**
     * Función que comprueba si el importe recibido es menor o igual al atributo saldo.
     * @param importe - Double que comparar con saldo.
     * @return True si saldo es mayor o igual y false en caso contrario.
     */
    private boolean validarTransaccion(double importe)
    {
        return saldo >= importe;
    }

    /**
     * Función heredada de la clase madre.
     * Comprueba si el atributo cuenta cumple el formato establecido.
     * @return True si cuenta cumple el formato y false si no.
     */
    @Override
    public boolean validarMetodo()
    {
        return cuenta.matches(FORMATO_CUENTA);
    }

    /**
     * Procedimiento heredada de la clase madre.
     * Imprime por pantalla el importe introducido.
     * Invoca a validarTransacción para imprimir si el pago ha sido exitoso o no.
     * @param importe - Double con el costo que el usuario va a pagar.
     */
    @Override
    public void procesarPago(double importe)
    {
        System.out.println("Procesando pago de "+ importe +"€ con PayPal.");
        if(validarTransaccion(importe)) System.out.println("Pago realizado con éxito.");
        else System.out.println("Fondos insuficientes. Cancelando transacción.");
    }
}