package org.example.bateriaMatrices;
import java.util.Random;
import java.util.Arrays;

public class Ejercicio2
{
    static void main()
    {
        Random random = new Random();
        final int TAM_MIN = 1, TAM_MAX = 5, FILAS = random.nextInt(TAM_MIN, TAM_MAX+1), COLUMNAS = random.nextInt(TAM_MIN, TAM_MAX+1);
        int matriz[][] = new int[FILAS][COLUMNAS], suma;

        for(int i = 0; i < FILAS; i++)
        {
            for (int j = 0; j < COLUMNAS; j++)
            {
                matriz[i][j] = random.nextInt(21);
            }
        }
        System.out.println("Matriz:");
        for(int fila[] : matriz)
        {
            System.out.println(Arrays.toString(fila));
        }

        System.out.println("\nSuma de filas:");
        for(int i = 0; i < FILAS; i++)
        {
            suma = 0;
            for (int j = 0; j < COLUMNAS; j++) suma += matriz[i][j];
            System.out.println("Fila "+ (i+1) +": "+ suma);
        }

        System.out.println("\nSuma de columnas:");
        for(int j = 0; j < COLUMNAS; j++)
        {
            suma = 0;
            for(int i = 0; i < FILAS; i++) suma += matriz[i][j];
            System.out.println("Columna "+ (j+1) +": "+ suma);
        }
    }
}
