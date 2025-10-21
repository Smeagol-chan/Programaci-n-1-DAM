package org.example;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ActividadExcepcionesSwitch
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        LocalDateTime hoy = LocalDateTime.now();
        final int ANNO_MIN = 1900, ANNO_MAX = hoy.getYear();
        String annoNacimiento;
        int modo = 0;
        boolean falloCase, falloGeneral;

        System.out.println("¡Descubre cuál es su generación!");
        do
        {
            System.out.print("Seleccione una opción:\n\t1. Introduciendo el año de nacimiento\n\t2. Introduciendo la edad\n\nOpción: ");
            falloGeneral = false;
            if(!key.hasNextInt())
            {
                System.out.println("ERROR\nCarácter inválido.\n");
                falloGeneral = true;
            }
            else
            {
                modo = key.nextInt();
                key.nextLine();

                switch (modo)
                {
                    case 1:
                        do
                        {
                            falloCase = false;
                            System.out.print("Introduzca su año de nacimiento: ");
                            annoNacimiento = key.next();
                            try
                            {
                                modo = Integer.parseInt(annoNacimiento);
                            }
                            catch (Exception e)
                            {
                                System.out.println("ERROR\nExcepción producida por introducir un carácter: " + e.getMessage() + "\n");
                                falloCase = true;
                            }
                            key.nextLine();
                            if (!falloCase)
                            {
                                if (modo < ANNO_MIN || modo > ANNO_MAX)
                                {
                                    System.out.println("ERROR\nAño de nacimiento fuera del rango (" + ANNO_MIN + ", " + ANNO_MAX + ")\n");
                                    falloCase = true;
                                }
                            }
                        } while (falloCase);
                        break;

                    case 2:
                        do
                        {
                            falloCase = false;
                            System.out.print("Introduzca su edad: ");
                            if (key.hasNextInt())
                            {
                                modo = key.nextInt();
                            }
                            else
                            {
                                System.out.println("ERROR\nCarácter inválido.\n");
                                falloCase = true;
                            }
                            key.nextLine();

                            if (!falloCase)
                            {
                                modo = ANNO_MAX - modo;
                                if (modo < ANNO_MIN || modo > ANNO_MAX)
                                {
                                    System.out.println("ERROR\nAño de nacimiento fuera del rango (0, " + (ANNO_MAX - ANNO_MIN) + ")\n");
                                    falloCase = true;
                                }
                            }
                        } while (falloCase);
                        break;

                    default:
                        System.out.println("ERROR\nValor fuera del rango (1,2).\n");
                        falloGeneral = true;
                        break;
                }
            }
        }while(falloGeneral);

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
