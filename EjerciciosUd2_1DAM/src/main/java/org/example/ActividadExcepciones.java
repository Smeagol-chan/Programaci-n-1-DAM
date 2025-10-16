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
        LocalDateTime hoy = LocalDateTime.now();
        String annoNacimiento;
        int modo = 0;
        boolean fallo;

        System.out.println("¡Descubre cuál es su generación!");
        do
        {
            System.out.print("Seleccione una opción:\n\t1. Introduciendo el año de nacimiento\n\t2. Introduciendo la edad\n\nOpción: ");
            fallo = false;
            if(key.hasNextInt())
            {
                modo = key.nextInt();
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
            do
            {
                fallo = false;
                System.out.print("Introduzca su año de nacimiento: ");
                annoNacimiento = key.next();
                try
                {
                    modo = Integer.parseInt(annoNacimiento);
                }
                catch(Exception e)
                {
                    System.out.println("ERROR\nExcepción producida por introducir un carácter: "+ e.getMessage() +"\n");
                    fallo = true;
                }
                key.nextLine();
                if(!fallo)
                {
                    if(modo < 1900 || modo > hoy.getYear())
                    {
                        System.out.println("ERROR\nAño de nacimiento fuera del rango (1900, "+ hoy.getYear() +")\n");
                        fallo = true;
                    }
                }
            }while(fallo);
        }
        else
        {
            do
            {
                fallo = false;
                System.out.print("Introduzca su edad: ");
                if(key.hasNextInt())
                {
                    modo = key.nextInt();
                }
                else
                {
                    System.out.println("ERROR\nCarácter inválido.\n");
                    fallo = true;
                }
                key.nextLine();

                if(!fallo)
                {
                    modo = hoy.getYear() - modo;
                    if(modo < 1900 || modo > hoy.getYear())
                    {
                        System.out.println("ERROR\nAño de nacimiento fuera del rango (1900, "+ hoy.getYear() +")\n");
                        fallo = true;
                    }
                }
            }while(fallo);
        }
        if(modo >= 1900 && modo <= 1927) System.out.println("Pertenece a la generación bautizada.");
        if(modo >= 1928 && modo <= 1944) System.out.println("Pertenece a la generación Silent.");
        if(modo >= 1945 && modo <= 1964) System.out.println("Pertenece al Baby Boom.");
        if(modo >= 1965 && modo <= 1981) System.out.println("Pertenece a la generación X.");
        if(modo >= 1982 && modo <= 1994) System.out.println("Pertenece a la generación Milennial.");
        if(modo >= 1995 && modo <= 2009) System.out.println("Pertenece a la generación Z.");
        if(modo >= 2010 && modo <= hoy.getYear()) System.out.println("Pertenece a la generación Alpha.");
    }
}
