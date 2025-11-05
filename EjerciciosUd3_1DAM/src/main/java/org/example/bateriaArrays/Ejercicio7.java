package org.example.bateriaArrays;

import java.util.Random;

public class Ejercicio7
{
    static void main()
    {
        Random random = new Random();
        final int MIN = 5, MAX = 10;
        int vector1[] = new int[random.nextInt(MAX - MIN + 1) + MIN], vector2[] = new int[random.nextInt(MAX - MIN + 1) + MIN];
        int vector3[] = new int[vector1.length + vector2.length];

        System.out.print("Array 1: ");
        for(int i = 0; i < vector1.length; i++)
        {
            vector1[i] = random.nextInt(MAX + 1);
            vector3[i] = vector1[i];
            System.out.print(vector1[i] + (i == vector1.length - 1 ? "\n" : ", "));
        }

        System.out.print("Array 2: ");
        for(int i = 0; i < vector2.length; i++)
        {
            vector2[i] = random.nextInt(MAX + 1);
            vector3[i + vector1.length] = vector2[i];
            System.out.print(vector2[i] + (i == vector2.length - 1 ? "\n" : ", "));
        }

        System.out.print("Array resultante: ");
        for(int i = 0; i < vector3.length; i++) System.out.print(vector3[i] + (i == vector3.length - 1 ? "\n" : ", "));
    }
}
