package org.example.app;

import org.example.objetos.Persona;

public class PersonaApp
{
    static void main()
    {
        Persona profe = new Persona("patricia", "10000000J", 20, "profesora pública", "Alicante");

        profe.imprimirDatos();
    }
}
