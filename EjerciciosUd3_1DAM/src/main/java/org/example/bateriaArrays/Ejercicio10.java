package org.example.bateriaArrays;
import java.util.Scanner;

public class Ejercicio10
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int TAM = 5;
        String oracion[] = new String[TAM], letraS;
        char letraC;
        boolean fallo;

        System.out.println("Inserte "+ TAM +" palabras para completar el array: ");
        for(int i = 0; i < TAM; i++)
        {
            do
            {
                fallo = false;
                System.out.print("> ");
                oracion[i] = key.nextLine();
                if(oracion[i].length() < 1)
                {
                    System.out.println("No se pueden dejar posiciones vacías.");
                    fallo = true;
                }
            }while(fallo);
        }
        do
        {
            fallo = false;
            System.out.print("\nLetra inicial de la palabra que quieras encontrar: ");
            letraS = key.nextLine();
            if(letraS.length() != 1)
            {
                System.out.println("Solo se puede introducir un carácter.");
                fallo = true;
            }
        }while(fallo);

        letraC = letraS.toLowerCase().charAt(0);
        for(int i = 0; i < TAM; i++)
        {
            if(letraC == oracion[i].toLowerCase().charAt(0)) System.out.println("> "+ oracion[i]);
        }
    }
}
