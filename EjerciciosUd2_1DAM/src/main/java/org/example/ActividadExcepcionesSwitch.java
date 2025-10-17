package org.example;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ActividadExcepcionesSwitch
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

        switch (modo)
        {
            case 1:
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
                break;

            case 2:
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
                break;

            default:
                System.out.println("ESTÁS EN EL DEFAULT");
                break;
        }

        if(modo <= 1927)
        {
            System.out.println("Pertenece a la generación bautizada.");
        }
        else
        {
            if(modo <= 1944)
            {
                System.out.println("Pertenece a la generación Silent.");
            }
            else
            {
                if(modo <= 1964)
                {
                    System.out.println("Pertenece al Baby Boom.");
                }
                else
                {
                    if(modo <= 1981)
                    {
                        System.out.println("Pertenece a la generación X.");
                    }
                    else
                    {
                        if(modo <= 1994)
                        {
                            System.out.println("Pertenece a la generación Milennial.");
                        }
                        else
                        {
                            if(modo <= 2009)
                            {
                                System.out.println("Pertenece a la generación Z.");
                            }
                            else
                            {
                                System.out.println("Pertenece a la generación Alpha.");
                            }
                        }
                    }
                }
            }
        }
    }
}
