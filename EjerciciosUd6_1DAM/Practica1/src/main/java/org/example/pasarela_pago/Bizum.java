package org.example.pasarela_pago;
import lombok.Getter;
import lombok.Setter;
import org.example.FuncionesComunes;

/**
 * Objeto Bizum, clase hija de MetodoPago.
 * Sus atributos son pin y teléfono.
 * @author ericr
 * @version 1.0
 */
@Getter @Setter
public class Bizum extends MetodoPago
{
    //Constantes
    private static final int CANTIDAD_NUMEROS_PIN = 6;
    private static final int DIGITO_MAYOR_PIN = 9;
    private static final String FORMATO_TELEFONO = "^[0-9]{9}$";

    //Atributos
    private String pin;
    private String telefono;

    /**
     * Constructor de Bizum.
     * telefono se inicializa con la variable omónima.
     * Se invoca setPin para añadir valor a pin.
     * @param telefono - String cuyo contenido se almacenará en el atributo telefono.
     */
    public Bizum(String telefono)
    {
        this.telefono = telefono;
        setPin();
    }

    /**
     * Función estática que genera un número pin aleatorio.
     * @return String con el pin generado.
     */
    private static String generarPin()
    {
        String pin = "";

        for(int i = 0; i < CANTIDAD_NUMEROS_PIN; i++)
            pin += String.valueOf(FuncionesComunes.random.nextInt(DIGITO_MAYOR_PIN+1));

        return pin;
    }

    /**
     * Función que valida el formato de telefono.
     * @return True si el formato es correcto y false en caso contrario.
     */
    private boolean validarTelefono()
    {
        return telefono.matches(FORMATO_TELEFONO);
    }

    /**
     * Función que comprueba si el pin introducido por el usuario es el igual al atributo pin.
     * @return True si es igual y false si no.
     */
    private boolean validarPin()
    {
        System.out.print("Introduzca el pin ["+ pin +"]: ");
        return FuncionesComunes.solicitarString().equals(pin);
    }

    /**
     * Función heredada de la clase madre.
     * Invoca validarTelefono y validarPin y comprueba su resultado.
     * @return True si ambas funciones invocadas devuelven verdadero y false si cualquiera de ellas es falsa.
     */
    @Override
    public boolean validarMetodo()
    {
        return validarTelefono() && validarPin();
    }

    /**
     * Set del atributo pin alterado.
     * No recibe parámetros. El contenido de pin se recibe de la función generarPin.
     */
    private void setPin()
    {
        pin = generarPin();
    }

    /**
     * Procedimiento heredada de la clase madre.
     * Imprime por pantalla el importe introducido y que el pago fue exitoso.
     * @param importe - Double con el costo que el usuario va a pagar.
     */
    @Override
    public void procesarPago(double importe)
    {
        System.out.println("Procesando pago de "+ importe +"€ con Bizum.");
        System.out.println("Pago realizado con éxito.");
    }
}