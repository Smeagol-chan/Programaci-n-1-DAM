package org.example;

import java.util.Scanner;

public class Ejercicio6
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        double h, b, a;
        boolean fallo;

        do
        {
            fallo = false;
            System.out.print("Introduzca la base del triángulo: ");
            b = key.nextDouble();

            if(b < 0)
            {
                System.out.println("ERROR\nIntoduzca una base positiva.");
                fallo = true;
            }
        }while(fallo);

        do
        {
            fallo = false;
            System.out.print("Introduzca la altura del triángulo: ");
            h = key.nextDouble();

            if(h < 0)
            {
                System.out.println("ERROR\nIntoduzca una altura positiva.");
                fallo = true;
            }
        }while(fallo);

        a = b * h;
        a /= 2;
        System.out.println("El triángulo de altura "+ h +" y base "+ b +" tiene de área "+ a +".");
    }
}
