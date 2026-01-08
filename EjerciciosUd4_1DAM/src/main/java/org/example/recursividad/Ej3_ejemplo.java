package org.example.recursividad;

import org.example.FuncionesComunes;

public class Ej3_ejemplo
{
    private static int suma(int num)
    {
        if(num > 1) num += suma(num-1);
        return num;
    }

    static void main()
    {
        System.out.println(suma(FuncionesComunes.solicitudInt()));
    }
}
