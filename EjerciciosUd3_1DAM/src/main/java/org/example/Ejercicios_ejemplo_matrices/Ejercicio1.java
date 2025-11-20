package org.example.Ejercicios_ejemplo_matrices;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio1
{
    static void main()
    {
        Random random = new Random();
        final int N = random.nextInt(2,11);
        int matriz[][] = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                matriz[i][j] = random.nextInt(10, 100);
            }
        }

        for(int fila[] : matriz)
        {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println("\n\t*** B ***");

        for(int i = 0; i < N; i++)
        {
            System.out.print("[");
            for(int j = 0; j < N; j++)
            {
                if(j > 0) System.out.print(", ");
                System.out.print(j == (N-(i+1)) ? matriz[i][j] : "-");
            }
            System.out.println("]");
        }
        System.out.println("\n\t*** A ***");

        for(int i = 0; i < N; i++)
        {
            System.out.print("[");
            for(int j = 0; j < N; j++)
            {
                if(j > 0) System.out.print(", ");
                System.out.print(j == i ? matriz[i][j] : "-");
            }
            System.out.println("]");
        }
    }
}
