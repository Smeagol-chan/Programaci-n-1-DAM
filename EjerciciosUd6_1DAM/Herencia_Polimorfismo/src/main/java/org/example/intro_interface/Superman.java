package org.example.intro_interface;

public class Superman extends Superhero implements Volar, Ataques
{
    @Override
    public void puedeVolar()
    {
        System.out.println("Sobrevolando la metrópolis en busca del mal.");
    }

    @Override
    public void lanzarRayos()
    {
        System.out.println("Atacando con rayos.");
    }

    @Override
    public void congelar()
    {
        System.out.println("Congelando el aire.");
    }
}
