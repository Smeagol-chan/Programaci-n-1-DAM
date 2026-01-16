package org.example.app;

import org.example.objetos.Televisor;

/**
 * Clase para probar objeto Televisor
 */
public class AplicaiconTv
{
    static void main()
    {
        Televisor tvVacio = new Televisor();
        Televisor tvInicializado = new Televisor(70);

        tvVacio.bajarCanal();
        tvVacio.subirVolumen();
        tvVacio.bajarCanal();

        tvInicializado.subirVolumen();
        for (int i = 0; i < 30; i++) tvInicializado.subirCanal();
        tvInicializado.subirCanal();
    }
}
