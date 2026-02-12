package org.example.abstraccion.plataforma_streaming;

public class PlanFamiliar extends Suscripcion
{
    public PlanFamiliar(String nombrePlan, double precio)
    {
        super(nombrePlan, precio);
    }

    @Override
    public void obtenerBeneficios()
    {
        System.out.println("Acceso para vaios perfiles simultáneamente en alta definición.");
    }

    @Override
    public void periodoPrueba()
    {
        System.out.println("7 días de prueba para cuentas nuevas.");
    }
}