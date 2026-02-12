package org.example.abstraccion.plataforma_streaming;

public abstract class Suscripcion
{
    private String nombrePlan;
    private double precio;

    public Suscripcion(String nombrePlan, double precio)
    {
        this.nombrePlan = nombrePlan;
        this.precio = precio;
    }

    public void mostratInfo()
    {
        System.out.println("Nombre del plan: "+ nombrePlan);
        System.out.println("Precio: "+ precio);
    }

    public abstract void obtenerBeneficios();

    public abstract void periodoPrueba();
}