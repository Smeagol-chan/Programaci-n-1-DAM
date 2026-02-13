package org.example.pasarela_pago;
import lombok.Getter;
import java.util.Arrays;

@Getter
public class TarjetaCredito extends MetodoPago
{
    private static final String FORMATO_TARJETA = "^[0-9]{16}$";
    private static final String[] TIPOS_VALIDOS = {"VISA", "MASTERCARD", "MAESTRO"};

    private String nro_tarjeta;
    private String tipo;

    public TarjetaCredito(String nro_tarjeta, String tipo)
    {
        if(validarTarjeta(nro_tarjeta, tipo))
        {
            setNro_tarjeta(nro_tarjeta);
            setTipo(tipo);
        }
    }

    private static boolean validarTarjeta(String nro_tarjeta, String tipo)
    {
        if(!validarNumero(nro_tarjeta))
        {
            System.out.println("ERROR\nEl número de la tarjeta no es válido.\n");
            return false;
        }
        else if(!validarTipo(tipo))
        {
            System.out.print("ERROR\nEl tipo de la tarjeta no es válido.\nLos tipos válidos son:");
            for(String tipoValido : TIPOS_VALIDOS) System.out.print(" "+ tipoValido);
            System.out.println("\n");
            return false;
        }
        else return true;
    }

    private static boolean validarNumero(String nro_tarjeta)
    {
        return nro_tarjeta.matches(FORMATO_TARJETA);
    }

    private static boolean validarTipo(String tipo)
    {
        return Arrays.asList(TIPOS_VALIDOS).contains(tipo);
    }

    private void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void procesarPago(double importe)
    {
        System.out.println("Procesando pago de "+ importe +"€ contarjeta de crédito "+ tipo +".");
    }
}
