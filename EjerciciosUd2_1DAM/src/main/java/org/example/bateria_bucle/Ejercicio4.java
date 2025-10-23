package org.example.bateria_bucle;

import java.util.Scanner;

public class Ejercicio4
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String frase;

        System.out.print("Escribe algo: ");
        frase = key.nextLine();

        for(int i = 0; i < frase.length(); i++) System.out.println(frase.charAt(i));
    }
}
