package org.example.inmobiliaria;

public class InmobiliaraApp
{
    static void main()
    {
        Casa pisito = new Casa ("Calle falsa 123");

        pisito.crearHabitacion("cocina", 20);
        pisito.crearHabitacion("dormitorio", 21);
        pisito.crearHabitacion("baño", 7);
        pisito.mostrarHabitaciones();
        System.out.println("Habitación mayor: "+ pisito.habitacionMasGrande().getNombre());
        System.out.println();


    }
}
