package org.example;
import java.util.Scanner;

public class Practica1_ampliacion
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final  String SEPERADOR = " ";
        final int CANTIDAD_MOMENTOS = 5;
        String nick = "@", datos;
        String[] numEspectadores = null, numComentarios;
        int aux = 0, cont, max = 0, min = 0, hype = 0;
        float ratio = 0, racha;
        boolean fallo, segundoDato = false;

        System.out.println("\t*** ESTADÍSTICAS PREMIOS ESLAND ***");
        System.out.println("------------------------------------------------------------------");
        System.out.print("Inserta streamer a analizar: ");
        nick += key.nextLine();
        do
        {
            cont = 0;
            fallo = false;
            System.out.print("Inserta "+ (!segundoDato ? "los espectadores medios" : "el número de comentarios") +": ");
            datos = key.nextLine();
            numComentarios = datos.split(SEPERADOR);
            if(numComentarios.length == CANTIDAD_MOMENTOS)
            {
                while(cont < CANTIDAD_MOMENTOS && !fallo)
                {
                    try
                    {
                        aux = Integer.parseInt(numComentarios[cont]);
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("ERROR\nSolo se puede introdcir números.\n");
                        fallo = true;
                    }
                    if(!fallo)
                    {
                        if(aux < 0)
                        {
                            System.out.println("ERROR\nNo es posible tener "+ (!segundoDato ? "viewers" : "comentarios") +" negativos.\n");
                            fallo = true;
                        }
                        else if(!segundoDato)
                        {
                            if(cont == 0) min = aux;
                            if(max < aux) max = aux;
                            if(min > aux) min = aux;
                        }
                        else
                        {
                            racha = Float.parseFloat(numEspectadores[cont]);
                            if(ratio < (aux / racha))
                            {
                                ratio = aux / racha;
                                hype = cont + 1;
                            }
                        }
                        cont++;
                    }
                }
            }
            else
            {
                System.out.println("ERROR\nSe deben introducir "+ CANTIDAD_MOMENTOS +" datos en total.\n");
                fallo = true;
            }
            if(!fallo)
            {
                if(!segundoDato) numEspectadores = numComentarios.clone();
                segundoDato = !segundoDato;
            }
        }while(fallo || segundoDato);

        racha = ((max - min) * 100) / max;

        System.out.println("------------------------------------------------------------------");
        System.out.println(nick);
        System.out.println("MAX = "+ max);
        System.out.println("HYPE = "+ hype +" ("+ ratio +")");
        System.out.println("RACHA = "+ racha);
    }
}