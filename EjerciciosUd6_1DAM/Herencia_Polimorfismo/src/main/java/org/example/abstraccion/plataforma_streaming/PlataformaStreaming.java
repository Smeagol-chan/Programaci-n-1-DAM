package org.example.abstraccion.plataforma_streaming;

import java.util.ArrayList;

public class PlataformaStreaming
{
    static void main()
    {
        Suscripcion gratis = new PlanGratis("Plan gratis", 0);
        Suscripcion basico = new PlanBasico("Plan básico", 8);
        Suscripcion premium = new PlanPremium("Plan premium", 15);
        Suscripcion familiar = new PlanFamiliar("Plan familiar", 30);

        ArrayList<Suscripcion> planes = new ArrayList<>();
        planes.add(gratis);
        planes.add(basico);
        planes.add(premium);
        planes.add(familiar);

        for(Suscripcion suscripcion : planes)
        {
            suscripcion.mostratInfo();
            suscripcion.obtenerBeneficios();
            suscripcion.periodoPrueba();
            System.out.println();
        }
    }
}
