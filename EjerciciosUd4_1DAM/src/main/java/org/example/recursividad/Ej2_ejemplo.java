package org.example.recursividad;

import org.example.FuncionesComunes;

public class Ej2_ejemplo
{
    private static int pedirNum()
    {
        int n = 0;
        do
        {
            n = FuncionesComunes.solicitudInt();
        }while(FuncionesComunes.negativoInt(n));
        return n;
    }

    private static void imprimir(int num)
    {
        if(num >= 1)
        {
            imprimir(num-1);
            System.out.println(num);
        }
    }

    static void main()
    {
        imprimir(pedirNum());
    }
}
