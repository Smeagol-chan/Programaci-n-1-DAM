package org.example;

import java.util.Scanner;

public class Ejercicio4
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int n1, n2, n3, min;
        boolean fallo;

        do
        {
            fallo = false;

            System.out.print("Introduzca el primer número: ");
            n1 = key.nextInt();
            System.out.print("Introduzca el segundo número: ");
            n2 = key.nextInt();
            System.out.print("Introduzca el tercer número: ");
            n3 = key.nextInt();

            if(n1 == n2 || n2 == n3 || n3 == n1)
            {
                fallo = true;
                System.out.println("ERROR.\nNo se pueden repetir números");
            }
        }while(fallo);

        min = n1;
        if(min > n2)
        {
            min = n2;
        }
        else if (min > n3)
        {
            min = n3;
        }

        System.out.println("El número menor es "+ min +".");
    }
}
