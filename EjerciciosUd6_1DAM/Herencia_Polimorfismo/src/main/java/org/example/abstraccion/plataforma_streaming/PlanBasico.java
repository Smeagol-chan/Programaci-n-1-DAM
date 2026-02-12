package org.example.abstraccion.plataforma_streaming;

public class PlanBasico extends Suscripcion
{
    public PlanBasico(String nombrePlan, double precio)
    {
        super(nombrePlan, precio);
    }

    @Override
    public void obtenerBeneficios()
    {
        System.out.println("Acceso a todo el contenido en calidad estándar sin anuncios.");
    }

    @Override
    public void periodoPrueba()
    {
        System.out.println("30 días de prueba gratuita.");
    }
}