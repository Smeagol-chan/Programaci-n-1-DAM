package org.example.bateria_bucle;
import java.util.Scanner;

public class Ejercicio7
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int n, factorial = 1;

        System.out.print("Número para calcular si factorial: ");
        n = key.nextInt();

        for(int i = 1; i <= n; i++) factorial *= i;

        System.out.println("!"+ n +" = "+ factorial);
    }
}
