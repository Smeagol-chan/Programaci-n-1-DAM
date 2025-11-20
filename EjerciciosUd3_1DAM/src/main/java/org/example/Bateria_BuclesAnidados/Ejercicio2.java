package org.example.Bateria_BuclesAnidados;
import java.util.Scanner;

public class Ejercicio2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int h;

        System.out.print("h = ");
        h = key.nextInt();

        System.out.println("\n");
        for(int i = 1; i <= h; i++)
        {
            for(int j = 0; j < (h-i); j++) System.out.print(" ");
            for(int j = 0; j < i; j++) System.out.print("*");
            for(int j = 1; j < i; j++) System.out.print("*");
            System.out.println();
        }
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < h-1; j++) System.out.print(" ");
            System.out.println("*");
        }
    }
}
