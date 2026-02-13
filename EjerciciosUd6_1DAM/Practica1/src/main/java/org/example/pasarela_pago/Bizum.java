package org.example.pasarela_pago;
import lombok.Getter;
import org.example.FuncionesComunes;

@Getter
public class Bizum extends MetodoPago
{
    private static final int CANTIDAD_NUMEROS_PIN = 6;
    private static final int DIGITO_MAYOR_PIN = 9;
    private static final String FORMATO_TELEFONO = "^[0-9]{9}$";

    private String pin;
    private String telefono;

    public Bizum(String telefono)
    {
        if(validarTelefono(telefono))
        {
            this.telefono = telefono;
            setPin();
        }
        else System.out.println("ERROR\nFormato del teléfono incorrecto.\n");
    }

    private static String generarPin()
    {
        String pin = "";

        for(int i = 0; i < CANTIDAD_NUMEROS_PIN; i++)
            pin += String.valueOf(FuncionesComunes.random.nextInt(DIGITO_MAYOR_PIN+1));

        return pin;
    }

    private static boolean validarTelefono(String telefono)
    {
        return telefono.matches(FORMATO_TELEFONO);
    }

    private boolean validarBizum()
    {
        FuncionesComunes.key.nextLine();
        System.out.print("Introduzca el pin ["+ pin +"]: ");
        return FuncionesComunes.solicitarString().equals(pin);
    }

    private void setPin()
    {
        pin = generarPin();
    }

    public void setTelefono(String telefono)
    {
        if(validarTelefono(telefono)) this.telefono = telefono;
        else System.out.println("ERROR\nFormato del teléfono incorrecto.\n");
    }

    @Override
    public void procesarPago(double importe)
    {
        if(validarBizum())
        {
            System.out.println("Procesando pago de "+ importe +"€ con Bizum.");
        }
        else System.out.println("ERROR\nPin incorrecto. Cancelando transacción.");
    }
}