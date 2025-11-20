package org.example;
import java.util.Scanner;

public class PerderPadel
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final String SEPAADOR = " ";
        final int TAM = 4, PORCENTAJE_TOTAL = 100, PORCENTAJE_MINIMO = 1, PORCENTAJE_MAXIMO = 90;
        String valores, valoresDivididos[] = new String[TAM];
        int cont, porcentajeIntroducido, aux = 0;
        boolean fallo;

        do
        {
            porcentajeIntroducido = 0;
            cont = 0;
            fallo = false;
            System.out.println("Introduce el porcentaje de los "+ TAM +" factores externos (compi pista pala pelota):");
            valores = key.nextLine();
            valoresDivididos = valores.split(SEPAADOR);
            if(valoresDivididos.length == TAM)
            {
                while(!fallo && cont < TAM)
                {
                    try
                    {
                        aux = Integer.parseInt(valoresDivididos[cont]);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("ERROR\nSolo se pueden introducir números.\n");
                        fallo = true;
                    }
                    if(!fallo)
                    {
                        if(aux < PORCENTAJE_MINIMO)
                        {
                            System.out.println("ERROR\nEl porcentaje no puede ser menor a "+ PORCENTAJE_MINIMO +"%.\n");
                            fallo = true;
                        }
                        else if(aux > PORCENTAJE_MAXIMO)
                        {
                            System.out.println("ERROR\nEl porcentaje no puede ser mayor a "+ PORCENTAJE_MAXIMO +"%.\n");
                            fallo = true;
                        }
                        else
                        {
                            porcentajeIntroducido += aux;
                            cont++;
                        }
                    }
                }
                if(!fallo)
                {
                    if(porcentajeIntroducido >= PORCENTAJE_TOTAL)
                    {
                        System.out.println("ERROR\nEl porcentaje total intoducido ha de ser menor a "+ PORCENTAJE_TOTAL +"%.\n");
                        fallo = true;
                    }
                }
            }
            else
            {
                System.out.println("ERROR\nSe deben introducir "+ TAM +" datos en total.\n");
                fallo = true;
            }
        }while(fallo);

        System.out.println("=============================================================================");
        System.out.println("Tienes un "+ (PORCENTAJE_TOTAL - porcentajeIntroducido) +"% de culpa.");
    }
}
