package org.example.intro_interface;

public class Avion implements Volar
{
    @Override
    public void puedeVolar()
    {
        System.out.println("Saliendo del aeropuerto.");
    }
}
