package org.example.bateria_bucle;
import java.util.Scanner;

public class Ejercicio8
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String frase;

        System.out.print("Introduce una frase: ");
        frase = key.nextLine();

        for(int i = frase.length() - 1; i >= 0; i--) System.out.print(frase.charAt(i));
    }
}
