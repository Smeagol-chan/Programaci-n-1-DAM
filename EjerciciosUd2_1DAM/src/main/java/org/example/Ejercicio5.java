package org.example;
 import java.util.Scanner;

public class Ejercicio5
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String frase, palabra;
        final byte MIN = 2;
        byte cont = 10;
        boolean acierto = false, fallo;

        System.out.print("TURNO DEL JUGADOR 1\nIntroduce tu frase secreta: ");
        frase = key.nextLine();

        System.out.println("\nTURNO DEL JUGADOR 2");
        do
        {
            System.out.print("Quedan "+ cont +" intentos.\nEscribe la palabra que creas que aparece en la frase: ");
            do  //Intentar comprobar que solo sea una palabra. Ni una frase ni una letra.
            {
                fallo = false;
                palabra = key.nextLine();
                if(palabra.length() < 2)
                {
                    System.out.println("ERROR\nUna palabra contiene como mínimo "+ MIN +" letras.\n\nEscribe la palabra que creas que aparece en la frase: ");
                    fallo = true;
                }
                else
                {
                    if(palabra.contains(" "))
                    {
                        System.out.println("ERROR\nNo se pueden introducir más de 1 palabra" +
                                ".\n\nEscribe la palabra que creas que aparece en la frase: ");
                        fallo = true;
                    }
                }
            }while (fallo);

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
