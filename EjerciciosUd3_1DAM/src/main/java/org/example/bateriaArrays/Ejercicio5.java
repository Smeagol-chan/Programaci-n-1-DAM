package org.example.bateriaArrays;

import java.util.Random;

public class Ejercicio5
{
    static void main()
    {
        Random random = new Random();
        final int MIN = 5, MAX = 10;
        int vector[] = new int[random.nextInt(MAX - MIN + 1) + MIN], aux;

        System.out.print("Array original: ");
        for(int i = 0; i < vector.length; i++)
        {
            vector[i] = random.nextInt(MAX + 1);
            System.out.print(vector[i] + (i == vector.length - 1 ? "\n" : ", "));
        }

        for(int i = 1; i < vector.length; i++)
        {
            aux = vector[i];
            vector[i] = vector[0];
            vector[0] = aux;
        }

        System.out.print("Array original: ");
        for(int i = 0; i < vector.length; i++) System.out.print(vector[i] + (i == vector.length - 1 ? "\n" : ", "));
    }
}
