package org.example;
import java.util.Scanner;

public class Practica3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int RESOLUCION_MAX = 48, RESULUCION_MIN = 8;
        int alto = 0, ancho = 0;
        boolean fallo, segundoDato = false;

        System.out.println("\t**** VALIDADOR DE COMPATIBILIDAD ZX SPECTRUM ****\nIntroduce la resolución de tu pantalla (ancho x alto)...");
        do
        {
            fallo = false;
            System.out.print("> "+ (!segundoDato ? "Anchura" : "Altura") +": ");
            try
            {
                alto = key.nextInt();
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR\nSolo se permiten números.\n");
                fallo = true;
            }
            if(alto >= RESULUCION_MIN && alto <= RESOLUCION_MAX)
            {
                if(!segundoDato) ancho = alto;
                segundoDato = !segundoDato;
            }
            else
            {
                System.out.println("ERROR\nEl valor no puede ser inferior a "+ RESULUCION_MIN +" ni superior a "+ RESOLUCION_MAX +".\n");
                fallo = true;
            }
        }while(fallo || segundoDato);
        String resolucion[][] = new String[alto][ancho];

        System.out.println("Introduce los colores de tu imagen píxel a píxel:");
        for(int i = 0; i < alto; i++)
        {
            String fila[] = key.next().split("");
            if(fila.length < )
        }
    }
}
