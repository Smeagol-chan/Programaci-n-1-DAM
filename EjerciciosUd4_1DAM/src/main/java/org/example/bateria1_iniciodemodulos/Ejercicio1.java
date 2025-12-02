package org.example.bateria1_iniciodemodulos;
import java.util.Scanner;

public class Ejercicio1
{
    private static int solicitud()
    {
        Scanner key = new Scanner(System.in);
        System.out.print("Escribe: ");
        return key.nextInt();
    }

    private static int cubo(int n)
    {
        int resul = n;
        for (int i = 0; i < 2; i++)  resul *= n;
        return resul;
    }

    static void main()
    {
        System.out.println(cubo(solicitud()));
    }
}
