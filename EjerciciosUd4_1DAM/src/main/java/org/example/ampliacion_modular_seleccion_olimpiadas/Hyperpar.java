package org.example.ampliacion_modular_seleccion_olimpiadas;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hyperpar
{
    public static int[] filtro(int[] vuelta)
    {
        Scanner key = new Scanner(System.in);

        vuelta[0]++;

        int[] n = new int[vuelta[0]];
        boolean fallo;
        do
        {
            fallo = false;
            try
            {
                n[vuelta[0]-1] = key.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se pueden introducir números.");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(n[vuelta[0]-1] < 0)
                {
                    if(n[vuelta[0]-1] != -1)
                    {
                        System.out.println("ERROR\nNo se pueden introducir números negativos.");
                        fallo = true;
                    }
                }
                else
                {
                   n = filtro(vuelta).clone();
                }
            }
        }while(fallo);
        return n;
    }

    static void main()
    {
        int[] tam = {0};


        System.out.println(Arrays.toString(filtro(tam)));
        System.out.println(tam[0]);
    }
}