package org.example.ampliacion_modular_seleccion_olimpiadas;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hyperpar
{
    static int tam = 0;

    public static int[] filtro()
    {
        Scanner key = new Scanner(System.in);

        tam++;

        int[] total = new int[tam];
        int n = 0, p = tam-1;
        boolean fallo;
        do
        {
            fallo = false;
            try
            {
                n = key.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se pueden introducir números.");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(n < 0)
                {
                    if(n != -1)
                    {
                        System.out.println("ERROR\nNo se pueden introducir números negativos.");
                        fallo = true;
                    }
                }
                else
                {
                   total = filtro().clone();
                }
            }
        }while(fallo);

        total[p] = n;
        return total;
    }

    public static void comprobarHyperpares(int[] num)
    {
        String auxS;
        int auxI;
        fuera:
        for(int i = 0; i < num.length-1; i++)
        {
            auxS = String.valueOf(num[i]);
            for(int j = 0; j < auxS.length(); j++)
            {
                auxI = Integer.parseInt(String.valueOf(auxS.charAt(j)));
                if(auxI%2 != 0)
                {
                    System.out.println("NO");
                    continue fuera;
                }
            }
            System.out.println("SÍ");
        }
    }

    static void main()
    {
        int[] numeros = filtro().clone();

        System.out.println();
        comprobarHyperpares(numeros.clone());
    }
}