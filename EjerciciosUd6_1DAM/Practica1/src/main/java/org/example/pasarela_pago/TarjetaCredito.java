package org.example.pasarela_pago;
import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;

/**
 * Objeto TarjetaCredito, clase hija de MetodoPago.
 * Sus atributos son el número y el tipo de la tarjeta.
 * @author ericr
 * @version 1.0
 */
@Getter @Setter
public class TarjetaCredito extends MetodoPago
{
    //Constantes
    private static final String FORMATO_TARJETA = "^[0-9]{16}$";
    private static final String[] TIPOS_VALIDOS = {"VISA", "MASTERCARD", "MAESTRO"};

    //Atributos
    private String nro_tarjeta;
    private String tipo;

    /**
     * Constructor de TarjetaCredito.
     * Los parámetros enviados se vuelcan en los atributos omónimos.
     * @param nro_tarjeta - String con el número de la targeta.
     * @param tipo - String con el tipo de la tarjeta.
     */
    public TarjetaCredito(String nro_tarjeta, String tipo)
    {
        this.nro_tarjeta = nro_tarjeta;
        this.tipo = tipo;
    }

    /**
     * Función heredada de la clase madre.
     * Invoca validarNumero y validarTipo y comprueba su resultado.
     * @return True si ambas funciones invocadas devuelven verdadero y false si cualquiera de ellas es falsa.
     */
    @Override
    public boolean validarMetodo()
    {
        return validarNumero() && validarTipo();
    }

    /**
     * Función que comprueba si el número de la tarjeta respeta el formato establecido.
     * @return True si respeta el formato y false en caso contrario.
     */
    private boolean validarNumero()
    {
        return nro_tarjeta.matches(FORMATO_TARJETA);
    }

    /**
     * Función que comprueba si el tipo de la tarjeta está presente en el listado de tipos válidos.
     * @return True si está presente en la lista y false en caso contrario.
     */
    private boolean validarTipo()
    {
        return Arrays.asList(TIPOS_VALIDOS).contains(tipo);
    }

    /**
     * Procedimiento heredada de la clase madre.
     * Imprime por pantalla el importe introducido y que el pago fue exitoso.
     * @param importe - Double con el costo que el usuario va a pagar.
     */
    @Override
    public void procesarPago(double importe)
    {
        System.out.println("Procesando pago de "+ importe +"€ contarjeta de crédito "+ tipo +".");
        System.out.println("Pago realizado con éxito.");
    }
}
