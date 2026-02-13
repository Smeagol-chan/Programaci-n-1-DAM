package org.example.comercios;
import org.example.FuncionesComunes;
import org.example.pasarela_pago.Bizum;
import org.example.pasarela_pago.MetodoPago;
import org.example.pasarela_pago.PayPal;
import org.example.pasarela_pago.TarjetaCredito;

public class Tienda
{
    private static void realizarPago(MetodoPago metodo)
    {
        System.out.print("Introduzca un importe: ");
        metodo.procesarPago(FuncionesComunes.solicitudDouble());
    }

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

        if(metodo == null) realizarPago(metodo);
    }

    private static MetodoPago anyadirTarjeta()
    {
        System.out.print("Número de la tarjeta: ");
        String nro_tarjeta = FuncionesComunes.solicitarString();
        System.out.print("Tipo de tarjeta (VISA, MASTERCARD, MAESTRO): ");
        String tipo = FuncionesComunes.solicitarString();

        return new TarjetaCredito(nro_tarjeta, tipo);
    }

    private static MetodoPago anyadirPaypal()
    {
        System.out.print("Email: ");
        String cuenta = FuncionesComunes.solicitarString();
        System.out.print("¿Quiere añadir saldo manualmente? (s/n): ");
        double saldo;
        if(FuncionesComunes.solicitarSNChar())
        {
            System.out.print("Saldo: ");
            saldo = FuncionesComunes.solicitudDouble();
        }
        else saldo = -1;

        return new PayPal(cuenta, saldo);
    }

    private static MetodoPago anyadirBizum()
    {
        System.out.print("Teléfono: ");
        String telefono = FuncionesComunes.solicitarString();

        return new Bizum(telefono);
    }
}
