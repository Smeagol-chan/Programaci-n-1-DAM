package org.example.bateriaArrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        final int MIN = 5, MAX = 10;
        int tam = random.nextInt(MAX - MIN + 1) + MIN, vector[] = new int[tam], pos = 0;
        boolean fallo;

        System.out.print("Array original: ");
        for(int i = 0; i < tam; i++)
        {
            vector[i] = random.nextInt(MAX + 1);
            System.out.print(vector[i] + (i == tam - 1 ? "\n" : ", "));
        }

        do
        {
            fallo = false;
            System.out.print("Ingresa índice a eliminar (0, "+ (tam-1) +"): ");
            try
            {
                pos = key.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se pueden números.\n");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(pos < 0)
                {
                    System.out.println("ERROR\nNo hay posición negativa.\n");
                    fallo = true;
                }
                else if (pos > MAX)
                {
                    System.out.println("ERROR\nNo se puede superar "+ (tam-1) +".\n");
                    fallo = true;
                }
            }
        }while(fallo);

        for(int i = pos; i < tam - 1; i++) vector[i] = vector[i + 1];
        tam--;

        System.out.print("Array resultante: ");
        for(int i = 0; i < tam; i++)
        {
            System.out.print(vector[i] + (i == tam - 1 ? "\n" : ", "));
        }
    }
}
