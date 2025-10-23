package org.example.bateria_bucle;

import java.util.Scanner;

public class Ejercicio5
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int numero;

        System.out.print("Número para ver la tabla de multiplicar: ");
        numero = key.nextInt();

        for(int i = 1; i <= 10; i++) System.out.println(i +" * "+ numero +" = "+ (numero*i));
    }
}
