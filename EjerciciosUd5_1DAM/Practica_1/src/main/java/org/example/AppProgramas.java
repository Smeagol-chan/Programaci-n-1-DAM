package org.example;

/**
 * Clase con el main del programa.
 * @author ericr
 * @version 1.0 (06/02/2026)
 */
public class AppProgramas
{
    static void main()
    {
        Cadena antena3 = new Cadena("Antena 3");
        System.out.println(antena3);

        //director = Director1
        Programa el_hormiguero = new Programa("El Hormiguero", antena3);
        System.out.println(el_hormiguero);
        System.out.println(antena3);

        //nombre = Pablo Motos | cargo = presentador
        el_hormiguero.crearEmpleado();
        System.out.println(el_hormiguero);

        System.out.println(el_hormiguero.getListaEmpleados());

        //nombre = Aitana | profesion = cantante | temporada = 1
        el_hormiguero.crearInvitado();

        System.out.println(el_hormiguero.getListaInvitados());
    }
}