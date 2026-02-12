package org.example.abstraccion.plataforma_streaming;

public class PlanPremium extends Suscripcion
{
    public PlanPremium(String nombrePlan, double precio)
    {
        super(nombrePlan, precio);
    }

    @Override
    public void obtenerBeneficios()
    {
        System.out.println("Acceso a todo el contenido en alta definición y descargas offline.");
    }

    @Override
    public void periodoPrueba()
    {
        System.out.println("14 días de prueba gratuita.");
    }
}