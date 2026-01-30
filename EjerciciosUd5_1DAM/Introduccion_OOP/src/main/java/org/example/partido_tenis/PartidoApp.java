package org.example.partido_tenis;

public class PartidoApp
{
    static void main()
    {
        Jugador j1 = new Jugador("Nadal", 1);
        Jugador j2 = new Jugador("Djokovic", 2);

        Partido partido = new Partido(j1, j2);
        partido.crearSet();
        partido.crearSet();

        System.out.println(partido);
    }
}
