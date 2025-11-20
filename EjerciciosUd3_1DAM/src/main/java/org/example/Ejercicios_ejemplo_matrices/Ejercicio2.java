package org.example.Ejercicios_ejemplo_matrices;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio2
{
    static void main()
    {
        Random random = new Random();
        final int N = random.nextInt(2,11);
        int matrizA[][] = new int[N][N];
        int matrizB[][] = new int[N][N];
        int matrizM[][] = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                matrizA[i][j] = random.nextInt(10, 100);
                matrizB[i][j] = random.nextInt(10, 100);
                matrizM[i][j] = matrizA[i][j] > matrizB[i][j] ? matrizA[i][j] : matrizB[i][j];
            }
        }

        System.out.println("\t*** A ***");
        for(int fila[] : matrizA)
        {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println("\n\t*** B ***");
        for(int fila[] : matrizB)
        {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println("\n\t*** M ***");
        for(int fila[] : matrizM)
        {
            System.out.println(Arrays.toString(fila));
        }

        System.out.println("\n"+ Arrays.toString(matrizA[1]));  //para mostrar una fila concreta
    }
}
