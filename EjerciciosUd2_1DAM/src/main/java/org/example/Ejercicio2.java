package org.example;

import java.util.Scanner;

public class Ejercicio2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String t1, t2;

        //Tengo que filtrar que solo entren palabras
        System.out.print("Introduzca la primera palabra: ");
        t1 = key.next();
        System.out.print("Introduzca la segunda palabra: ");
        t2 = key.next();

        if(t1.length() < t2.length())
        {
            System.out.println(t2 +" es más larga.");
        }
        else
        {
            if(t1.length() > t2.length())
            {
                System.out.println(t2 +" es más larga.");
            }
            else
            {
                System.out.println("Ambas palabras son igual de largas.");
            }
        }
    }
}
