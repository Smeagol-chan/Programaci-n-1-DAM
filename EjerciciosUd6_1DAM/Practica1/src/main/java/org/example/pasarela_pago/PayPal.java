package org.example.pasarela_pago;
import lombok.Getter;
import org.example.FuncionesComunes;

@Getter
public class PayPal extends MetodoPago
{
    private static final int DEFAULT_SALDO = 23;
    private static final String FORMATO_CUENTA = "^[a-zA-Z0-9+_.-]+@[a-z]+.com$";

    private String cuenta;
    private double saldo;

    public PayPal(String cuenta, double saldo)
    {
        if(validarCuenta(cuenta))
        {
            this.cuenta = cuenta;
            this.saldo = FuncionesComunes.negativoDouble(saldo) ? DEFAULT_SALDO : saldo;
        }
        else System.out.println("ERROR\nFormato del email incorrecto.\n");
    }

    private static boolean validarTransaccion(double saldo, double importe)
    {
        return saldo >= importe;
    }

    private static boolean validarCuenta(String cuenta)
    {
        return cuenta.matches(FORMATO_CUENTA);
    }

    private void realizarPago(double importe)
    {
        setSaldo(saldo-importe);
    }

    public void setCuenta(String cuenta)
    {
        if(validarCuenta(cuenta)) this.cuenta = cuenta;
        else System.out.println("ERROR\nFormato del email incorrecto.\n");
    }

    public void setSaldo(double saldo)
    {
        if(!FuncionesComunes.negativoDouble(saldo)) this.saldo = saldo;
        else System.out.println("ERROR\nNo se puede ingresar un saldo negativo.\n");
    }

    @Override
    public void procesarPago(double importe)
    {
        if(validarTransaccion(saldo, importe))
        {
            System.out.println("Procesando pago de "+ importe +"€ con PayPal.");
            realizarPago(importe);
        }
        else System.out.println("ERROR\nFondos insuficientes.");
    }
}