package org.example.bateriaArrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio8
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        final int MIN = 5, MAX = 10;
        int vector[] = new int[random.nextInt(MAX - MIN + 1) + MIN], tam = vector.length - 1, pos = 0, num = 0, aux;
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
            System.out.print("Ingresa índice donde desea agregar un valor (0, "+ tam +"): ");
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
                else if (pos > tam)
                {
                    System.out.println("ERROR\nNo se puede superar "+ tam +".\n");
                    fallo = true;
                }
            }
        }while(fallo);

        do
        {
            fallo = false;
            System.out.print("Ingresa el número (0, 9): ");
            try
            {
                num = key.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se pueden números.\n");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(num < 0)
                {
                    System.out.println("ERROR\nNo se pueden números negativos.\n");
                    fallo = true;
                }
                else if (num > 9)
                {
                    System.out.println("ERROR\nNo se puede superar 9.\n");
                    fallo = true;
                }
            }
        }while(fallo);

        tam++;
        for(int i = pos + 1; i < tam; i++)
        {
            aux = vector[pos];
            vector[pos] = vector[i];
            vector[i] = aux;
        }
        vector[pos] = num;

        System.out.print("Array resultante: ");
        for(int i = 0; i < tam; i++)
        {
            System.out.print(vector[i] + (i == tam - 1 ? "\n" : ", "));
        }
    }
}