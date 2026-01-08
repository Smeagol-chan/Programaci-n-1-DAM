package org.example.recursividad;

import org.example.FuncionesComunes;

public class Ej2_ejemplo
{
    private static int pedirNum()
    {
        int n;
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

    private static void imprimirBucle(int num)
    {
        for(int i = 1; i <= num; i++)
        {
            System.out.println(i);
        }
    }

    private static void menu()
    {
        System.out.println("1. Recursivo\n2. Bucles");
        switch (FuncionesComunes.filtroLimitesInt(1, 2))
        {
            case 1:
                imprimir(pedirNum());
                break;
            case 2:
                imprimirBucle(pedirNum());
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

    static void main()
    {
        menu();
    }
}
