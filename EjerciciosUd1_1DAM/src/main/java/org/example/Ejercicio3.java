package org.example;

import java.util.Scanner;

public class Ejercicio3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int COMPROBANTE = 0;
        int n;

        System.out.print("Escriba un número: ");
        n = key.nextInt();

        if(n == COMPROBANTE)
        {
            System.out.println("El número "+ n +" es natural.");
        } else if (n < COMPROBANTE)
        {
            System.out.println("El número "+ n +" es negativo.");
        }
        else
        {
            System.out.println("El número "+ n +" es positivo.");
        }
    }
}
