package org.example.bateriaMatrices;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final byte TAM = 3;
        int num, matriz[][] = new int[TAM][TAM], contador = 9, contJ = 902387409;
        boolean coincidencia = false;

        for(int i = 0; i < TAM; i++)
        {
            for(int j = 0; j < TAM; j++)
            {
                System.out.print("Introduzca un número ("+ contador-- +" restantes): ");
                matriz[i][j] = key.nextInt();
            }
        }
        System.out.println("\nMatriz:");
        for(int fila[] : matriz) System.out.println(Arrays.toString(fila));
        System.out.print("Número a buscar: ");
        num = key.nextInt();
        key.nextLine();
        while(contador < 3 && !coincidencia)
        {
            contJ = 0;
            while(contJ < 3 && !coincidencia)
            {
                if(matriz[contador][contJ] == num) coincidencia = true;
                else contJ++;
            }
            if(!coincidencia) contador++;
        }
        System.out.println("\nSalida:\nEl número "+ num +" "+
                (coincidencia ? "se encuentra en la posición ("+ contador + ", "+ contJ +")."
                        : "no se encuentra en la matriz."));
    }
}
