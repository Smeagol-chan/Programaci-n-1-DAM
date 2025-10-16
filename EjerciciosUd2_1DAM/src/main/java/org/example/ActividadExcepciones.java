package org.example;
import java.time.LocalDateTime;
import java.util.Scanner;
/*
Generación bautizada 1900-1927
Generación Silent 1928-1944
Baby Boom 1945-1964
X 1965-1981
Milennial 1982-1994
Z 1995-2009
Alpha 2010-actualidad
*/
public class ActividadExcepciones
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        LocalDateTime ahora = LocalDateTime.now();
        byte modo;
        boolean fallo;

        System.out.println("¡Descubre cuál es tu generación!");
        do
        {
            System.out.println("Seleccione una opción:\n\t1. Introduciendo el año de nacimiento\n\t2. Introduciendo la edad");
            fallo = false;
            if(key.hasNextByte())
            {
                modo = key.nextByte();
                if(modo < 1 || modo > 2)
                {
                    System.out.println("ERROR\nValor fuera del rango (1,2).\n");
                    fallo = true;
                }
            }
            else
            {
                System.out.println("ERROR\nCarácter inválido.\n");
                fallo = true;
            }
            key.nextLine();
        }while(fallo);

        if(modo == 1)
        {

        }
        else
        {

        }
    }
}
