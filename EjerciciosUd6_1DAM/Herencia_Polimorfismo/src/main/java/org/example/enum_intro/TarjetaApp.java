package org.example.enum_intro;
import org.example.FuncionesComunes;

public class TarjetaApp
{
    static void main()
    {
        TipoTarjeta tarjeta_tipo = TipoTarjeta.VISA;

        System.out.println(tarjeta_tipo.ordinal());
        System.out.println(tarjeta_tipo.name());

        System.out.println("\nTipos de tarjetas:");
        for(TipoTarjeta tipoTarjeta : TipoTarjeta.values()) System.out.println(tipoTarjeta);

        System.out.println("\n¡Se debe introducir el nombre extactamente igual!");
        TipoTarjeta tipo = TipoTarjeta.valueOf(FuncionesComunes.solicitarString());
        System.out.println("La tarjeta de tipo "+ tipo +" tiene una comisión de "+ tipo.getComision() +"€");
    }
}
