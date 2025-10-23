package org.example.bateria_bucle;

import java.util.Scanner;

public class Ejercicio6
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int n, suma = 0, cantidad;

        System.out.print("¿Cuántos números quieres sumar?\n> ");
        cantidad = key.nextInt();

        for(int i = 1; i <= cantidad; i++)
        {
            System.out.print("Inserta nº"+ i +": ");
            n = key.nextInt();
            suma += n;
        }
        System.out.println("El resultado es: "+ suma);

    }
}
