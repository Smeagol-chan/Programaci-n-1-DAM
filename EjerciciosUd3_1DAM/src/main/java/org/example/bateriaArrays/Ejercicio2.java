package org.example.bateriaArrays;

import java.util.Random;

public class Ejercicio2
{
    static void main()
    {
        Random random = new Random();
        final int MIN = 2, MAX = 9;
        int vector[] = new int[random.nextInt(MAX - MIN + 1) + MIN], vectorInv[] = new int[vector.length];

        System.out.print("Array original: ");
        for(int i = 0; i < vector.length; i++)
        {
            vector[i] = random.nextInt(MAX + 1);
            System.out.print(vector[i] + (i != vector.length - 1 ? "," : "\n"));
        }

        for(int i = vector.length; i > 0; i--)
        {
            vectorInv[vector.length - i] = vector[i - 1];
        }

        System.out.print("Array invertido: ");
        for(int i = 0; i < vector.length; i++)
        {
            System.out.print(vectorInv[i] + (i != vector.length - 1 ? "," : "\n"));
        }
    }
}
