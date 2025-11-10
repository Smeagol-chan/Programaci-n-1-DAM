package org.example;
import java.util.Scanner;

//Un programa para calcular la cantidad de interacciones en un canal de twitch de los últimos 5 meses.
//El programa funciona exactamente igual que el ejercicio anterior, el de los samurais.
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
                        else if(!segundoDato)   //Se guardan los máximos y mínimos de los espectadores
                        {
                            if(cont == 0) min = aux;
                            if(max < aux) max = aux;
                            if(min > aux) min = aux;
                        }
                        else
                        {
                            racha = Float.parseFloat(numEspectadores[cont]);    //Se calcula el ratio de comentarios en cada mes introducido. En el momento en el que se halla un ratio mayor, se guarda la posición y el ratio.
                            if(ratio < (aux / racha))
                            {
                                ratio = aux / racha;
                                hype = cont + 1 ;
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

        racha = ((max - min) * 100) / max;  //Por último, se calcula la racha y se imprimen los resultados en pantalla.

        System.out.println("------------------------------------------------------------------");
        System.out.println(nick);
        System.out.println("MAX = "+ max);
        System.out.println("HYPE = "+ hype +" ("+ ratio +")");
        System.out.println("RACHA = "+ racha);
    }
}