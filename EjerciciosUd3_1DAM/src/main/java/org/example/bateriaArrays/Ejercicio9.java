package org.example.bateriaArrays;
import java.util.Scanner;

public class Ejercicio9
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int TAM = 5;
        String oracion[] = new String[TAM];
        int posMayor = 0;

        System.out.println("Inserte "+ TAM +" palabras para comparar sus tamaños: ");
        for(int i = 0; i < TAM; i++)
        {
            System.out.print("> ");
            oracion[i] = key.nextLine();

            if(oracion[posMayor].length() < oracion[i].length()) posMayor = i;
        }
        System.out.println(oracion[posMayor] + " es la palabra más extensa de la cadena.");
    }
}
