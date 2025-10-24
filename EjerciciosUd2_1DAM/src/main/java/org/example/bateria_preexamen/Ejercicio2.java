package org.example.bateria_preexamen;

import java.util.Scanner;

public class Ejercicio2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int base = 0, exponente = 0, baseAux = 0;
        boolean fallo;

        do
        {
            fallo = false;
            System.out.print("Introduzca la base: ");
            if(key.hasNextInt())
            {
                base = key.nextInt();
                System.out.print("Introduce el exponente: ");

                if(key.hasNextInt())
                {
                    exponente = key.nextInt();
                    if(exponente < 0)
                    {
                        System.out.println("ERROR\nEl exponente no puede ser negativo.\n");
                        fallo = true;
                    }
                }
                else
                {
                    System.out.println("ERROR\nFormato carácter inválido\n");
                    fallo = true;
                }
            }
            else
            {
                System.out.println("ERROR\nFormato carácter inválido\n");
                fallo = true;
            }
        }while(fallo);

        if(exponente == 0)
        {
            System.out.println("\nResultado: 1");
        }
        else
        {
            baseAux = base;
            for(int i = 1; i < exponente; i++)
            {
                baseAux *= base;
            }
            System.out.println("\nResultado: "+ baseAux);
        }
    }
}
