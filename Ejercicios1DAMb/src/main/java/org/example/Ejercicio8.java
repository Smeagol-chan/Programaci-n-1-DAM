package org.example;

import java.util.Scanner;

public class Ejercicio8
{
    //Isósceles == 2 lados iguales
    //Equilátero == todos iguales
    //Escaleno == todos diferentes
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int l1, l2, l3;
        boolean fallo;

        do {
            fallo = false;
            System.out.print("Introduzca el primer lado del triángulo: ");
            l1 = key.nextInt();

            if(l1 < 0)
            {
                System.out.println("ERROR\nLos lados no pueden ser negativos.");
                fallo = true;
            }
        }while(fallo);

        do {
            fallo = false;
            System.out.print("Introduzca el segundo lado del triángulo: ");
            l2 = key.nextInt();

            if(l2 < 0)
            {
                System.out.println("ERROR\nLos lados no pueden ser negativos.");
                fallo = true;
            }
        }while(fallo);

        do {
            fallo = false;
            System.out.print("Introduzca el tercer lado del triángulo: ");
            l3 = key.nextInt();

            if(l3 < 0)
            {
                System.out.println("ERROR\nLos lados no pueden ser negativos.");
                fallo = true;
            }
        }while(fallo);

        if(l1 == l2 || l2 == l3 || l3 == l1)
        {
            if(l1 == l2 && l2 == l3)
            {
                System.out.println("El triángulo es equilátero. Todos sus lados son iguales.");
            }
            else
            {
                System.out.println("El triángulo es isósceles. Dos de sus lados son iguales.");
            }
        }
        else
        {
            System.out.println("El triángulo es escaleno. Todos sus lados son diferentes.");
        }
    }
}
