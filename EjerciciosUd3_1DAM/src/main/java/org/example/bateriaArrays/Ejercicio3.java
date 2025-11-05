package org.example.bateriaArrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Ejercicio3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        final int MAX = 100, TAM = 25;
        int vector[] = new int[TAM], num = 0, cont = 0;
        boolean fallo;

        for(int i = 0; i < TAM; i++) vector[i] = random.nextInt(MAX + 1);

        do
        {
            fallo = false;
            System.out.print("Introduce un número natural para buscar: ");
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
                    System.out.println("ERROR\nNo se permiten negativos.\n");
                    fallo = true;
                }
                else if (num > MAX)
                {
                    System.out.println("ERROR\nNo se puede superar "+ MAX +".\n");
                    fallo = true;
                }
            }
        }while(fallo);

        for(int i = 0; i < TAM; i++) if(num == vector[i]) cont++;
        System.out.println("El número "+ num +" aparece "+ cont +" veces en el array.");
    }
}
