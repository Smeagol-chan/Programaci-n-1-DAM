package org.example.bateria_bucle;

import java.util.Scanner;

public class Ejercicio2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int n;

        System.out.print("Número: ");
        n = key.nextInt();

        for(int i = n; i >= 1; i--) System.out.println(i);
    }
}
