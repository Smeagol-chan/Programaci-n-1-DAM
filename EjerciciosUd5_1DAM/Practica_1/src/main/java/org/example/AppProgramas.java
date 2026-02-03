package org.example;

public class AppProgramas
{
    static void main()
    {
        Cadena antena3 = new Cadena("Antena 3");
        Programa pasapalabra = new Programa("Pasapalabra", antena3);
        antena3.anyadirPrograma(pasapalabra);
        Programa simpson = new Programa("Los Simpson", antena3);
        antena3.anyadirPrograma(simpson);

        pasapalabra.crearEmpleado();

        System.out.println(antena3);
    }
}
