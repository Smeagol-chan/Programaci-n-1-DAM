package org.example.bus_imserso;

import org.example.FuncionesComunes;

public class ImsersoApp
{
    static void main()
    {
        Abuelo manolo = new Abuelo("Manolo", 91);
        Abuelo mercedes = new Abuelo("Mercedes", 92);
        Abuelo alberto = new Abuelo("Alberto", 80);
        Abuelo fina = new Abuelo("Josefina", 75);

        BusImserso alse = new BusImserso("kalwd231", "Madrid");

        alse.anyadirAbuelo(manolo);
        alse.anyadirAbuelo(mercedes);
        alse.anyadirAbuelo(alberto);
        alse.anyadirAbuelo(fina);

        alse.mostrarAbuelos();

        System.out.print("Filtro de edad: ");
        alse.mostrarMayores(FuncionesComunes.solicitudInt());
    }
}
