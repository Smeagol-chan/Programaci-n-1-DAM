package org.example.comercios;
import org.example.FuncionesComunes;
import org.example.pasarela_pago.Bizum;
import org.example.pasarela_pago.MetodoPago;
import org.example.pasarela_pago.PayPal;
import org.example.pasarela_pago.TarjetaCredito;

/**
 * Clase que gestiona la creación y validación del método de pago.
 * @author ericr
 * @version 1.0
 */
public class Tienda
{
    /**
     * Procedimiento que, recibiendo el método de pago creado por el usuario, inicia el pago.
     * Solicita el importe.
     * @param metodo - MetodoPago creado por el usuario previamente.
     */
    private static void realizarPago(MetodoPago metodo)
    {
        System.out.print("Introduzca un importe: ");
        metodo.procesarPago(FuncionesComunes.solicitudNumero());
    }

    /**
     * Procedimiento que, a través de un switch, crea un método de pago del tipo seleccionado por el usuario.
     * Tras crear el método valida los datos, invocando  realizarPago de ser correcto.
     */
    public static void iniciarPago()
    {
        MetodoPago metodo;

        System.out.print("Introduzca un método de pago (Tarjeta, PayPal, Bizum): ");
        switch(FuncionesComunes.solicitarString().toLowerCase())
        {
            case "tarjeta":
                System.out.println("Añada los datos de su tarjeta:");
                metodo = anyadirTarjeta();
                break;

            case "paypal":
                System.out.println("Añada su cuenta de PayPal:");
                metodo = anyadirPaypal();
                break;

            case "bizum":
                System.out.println("Añada los datos de Bizum:");
                metodo = anyadirBizum();
                break;

            default:
                System.out.println("El método no existe.");
                return;
        }

        if(metodo.validarMetodo()) realizarPago(metodo);
        else System.out.println("Datos del método inválidos.");
    }

    /**
     * Función que solicita al usuario los datos para crear un objeto de tipo TarjetaCredito.
     * @return TarjetaCredito con los datos introducidos.
     */
    private static MetodoPago anyadirTarjeta()
    {
        System.out.print("Número de la tarjeta: ");
        String nro_tarjeta = FuncionesComunes.solicitarString();
        System.out.print("Tipo de tarjeta (VISA, MASTERCARD, MAESTRO): ");
        String tipo = FuncionesComunes.solicitarString();

        return new TarjetaCredito(nro_tarjeta, tipo);
    }

    /**
     * Función que solicita al usuario los datos para crear un objeto de tipo Paypal.
     * @return Paypal con los datos introducidos.
     */
    private static MetodoPago anyadirPaypal()
    {
        System.out.print("Email: ");
        String cuenta = FuncionesComunes.solicitarString();

        return new PayPal(cuenta);
    }

    /**
     * Función que solicita al usuario los datos para crear un objeto de tipo Bizum.
     * @return Bizum con los datos introducidos.
     */
    private static MetodoPago anyadirBizum()
    {
        System.out.print("Teléfono: ");
        String telefono = FuncionesComunes.solicitarString();

        return new Bizum(telefono);
    }
}
