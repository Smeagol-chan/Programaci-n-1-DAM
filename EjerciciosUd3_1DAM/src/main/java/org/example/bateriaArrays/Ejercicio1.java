package org.example.bateriaArrays;

import java.util.Random;

public class Ejercicio1
{
    static void main()
    {
        Random random = new Random();
        final int MAX = 500;
        int vector[] = new int[7], suma = 0;

        for(int i = 0; i < vector.length; i++)
        {
            vector[i] = random.nextInt(MAX+1);
        }
        for(int i = 0; i < vector.length; i++)
        {
            System.out.print(vector[i] + (i == vector.length - 1 ? " = ": " + "));
            suma += vector[i];
        }
        System.out.print(suma);
    }
}
