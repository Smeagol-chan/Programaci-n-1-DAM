package org.example.ActividadRandoms;
import java.util.Scanner;
import java.util.Random;

public class Ejercicio3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        int max = 0, min = 0, cantidad = 0;
        boolean fallo;

        do  //Es más largo de lo que quería porque tenía un key.hasNextLine() y no me dí uenta hasta el final. Está así porque empecé a cambiarlo para ver por qué fallaba.
        {
            fallo = false;
            System.out.print("Introduce el rango mínimo: ");
            try
            {
                min = key.nextInt();
            }
            catch(NumberFormatException e)
            {
                System.out.println("ERROR\nSolo se admiten números.\n");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                System.out.print("Introduce el rango máximo: ");
                try
                {
                    max = key.nextInt();
                }
                catch(NumberFormatException e)
                {
                    System.out.println("ERROR\nSolo se admiten números.\n");
                    fallo = true;
                    key.nextLine();
                }
            }

            if(!fallo && (min >= max))
            {
                System.out.println("ERROR\nEl límite mínimo siempre ha de ser menor que el máximo.\n");
                fallo = true;
            }
        }while(fallo);

        do
        {
            fallo = false;
            System.out.print("¿Cuántos números quieres?: ");
            try
            {
                cantidad = key.nextInt();
            }
            catch(NumberFormatException e)
            {
                System.out.println("ERROR\nSolo se admiten números.\n");
                fallo = true;
                key.nextLine();
            }
            if(cantidad < 0)
            {
                System.out.println("ERROR\nNo puede ser negativo.\n");
                fallo = true;
                key.nextLine();
            }
        }while(fallo);

        System.out.print("\nNúmeros:\n> ");
        for(int i = 0; i < cantidad; i++)
        {
            System.out.print(random.nextInt(min, max +1));  //aleatorio.nextInt(max - min + 1) + min PARA TODO!!!! El mio es solo a partir de Java 21
            System.out.print(" ");
        }
    }
}
