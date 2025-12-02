package org.example.bateria1_iniciodemodulos;

import java.util.Scanner;

public class Ejercicio2
{
    private static void verMenu()
    {
        System.out.println("\t>> MENU <<");
        System.out.println("a. Primero\nb. Segundo\nc. Tercero\nd. Salir");
    }

    private static char opMenu()
    {
        Scanner key = new Scanner(System.in);
        System.out.print("Elige opción: ");
        return key.next().charAt(0);
    }

    private static boolean seleccionarMenu(char op)
    {
        switch(op)
        {
            case 'a':
                System.out.println("Primero!!!!!\n");
                return true;

            case 'b':
                System.out.println("Segundo!!!!!!\n");
                return true;

            case 'c':
                System.out.println("Tercero!!!!!!\n");
                return true;

            case 'd':
                System.out.println("Adiós OwO\n");
                return false;

            default:
                System.out.println("\n\tERROR");
                return false;
        }
    }

    static void main()
    {
        do
        {
            verMenu();
        }while(seleccionarMenu(opMenu()));
    }
}
