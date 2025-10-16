package org.example;
 import java.util.Scanner;

public class Ejercicio5
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String frase, palabra;
        byte cont = 10, posicion = -1;
        boolean acierto = false;

        System.out.print("TURNO DEL JUGADOR 1\nIntroduce tu frase secreta: ");
        frase = key.nextLine();

        System.out.println("\nTURNO DEL JUGADOR 2");
        do
        {
            System.out.print("Quedan "+ cont +" intentos.\nEscribe la palabra que creas que aparece en la frase: ");
            palabra = key.nextLine();
            palabra = palabra.toLowerCase();
            frase = frase.toLowerCase();

            if(frase.contains(palabra))
            {
                System.out.println("¡Enhorabuena, has acertado una palabra!");
                acierto = true;
            }
            else
            {
                System.out.println("Intento fallido.");
                cont--;
            }
        }while(!acierto && cont > 0);

        if(!acierto) System.out.println("\nFIN DEL JUEGO\nNo has encontrado ninguna palabra.");
    }
}
