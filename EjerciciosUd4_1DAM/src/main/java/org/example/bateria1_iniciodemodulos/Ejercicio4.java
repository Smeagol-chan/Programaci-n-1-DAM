package org.example.bateria1_iniciodemodulos;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
185,50
250,36
163,45
535,20
950,22
450,38
*/

/**
 * @author - Eric
 * @version - 1.0
 */
public class Ejercicio4
{
    /**
     * Método para pedir el dinero generado cada sía
     * @param dia - El día de la semana que se analiza
     * @return - El dinero del día
     */
    private static float filtro(int dia)
    {
        Scanner key = new Scanner(System.in);
        float dinero = 0;
        boolean fallo;

        do
        {
            fallo = false;
            try
            {
                dinero = key.nextFloat();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se deben introducir números.");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(dinero < 0)
                {
                    if(dia != 0)
                    {
                        System.out.println("ERROR\nNo se permiten números negativos.");
                        fallo = true;
                    }
                    else if(dinero != -1)
                    {
                        System.out.println("ERROR\nPara el martes, solo se puede insertar el número negativo -1.");
                        fallo = true;
                    }
                }
            }
        }while(fallo);
        return dinero;
    }

    /**
     * Método para comprobar que el dinero de cada día es válido
     * @param dinero - El dinero conseguido del día
     * @param dias - el total de días de la semana
     */
    private static void ventasSemanales(float[] dinero, byte dias)
    {
        float aux;
        for(int i = 0; i < dias; i++)
        {
            aux = filtro(i);
            dinero[i] = aux;
            if(i == 0 && aux == -1)
            {
                break;
            }
        }
    }

    /**
     * Método para imprimir el día de mayor y menor ganancias
     * @param dinero - Vector con todas las ganancias de cada día
     * @param totalDias - Total de días a analizar
     */
    private static void resumenSemanal(float[] dinero, byte totalDias)
    {
        byte aux;
        boolean segundoDato = false;

        do
        {
            aux = 0;
            for(byte i = 1; i < totalDias; i++)
            {
                if((!segundoDato ? dinero[aux] < dinero[i] : dinero[aux] > dinero[i])) aux = i;
            }

            switch (aux)
            {
                case 0:
                    System.out.print("MARTES\t");
                    break;

                case 1:
                    System.out.print("MIÉRCOLES\t");
                    break;

                case 2:
                    System.out.print("JUEVES\t");
                    break;

                case 3:
                    System.out.print("VIERNES\t");
                    break;

                case 4:
                    System.out.print("SÁBADO\t");
                    break;

                case 5:
                    System.out.print("DOMINGO\t");
                    break;
            }

            segundoDato = !segundoDato;
        }while(segundoDato);
    }

    /**
     * Método para imprimir s
     * @param dinero
     * @param totalDias
     */
    private static void datosDomingo(float[] dinero, byte totalDias)
    {
        for(int i = 1; i < totalDias; i++)
        {
            dinero[0] += dinero[i];
        }
        dinero[0] /= totalDias;
        System.out.println((dinero[0] == dinero[5] ? "EMPATE" : dinero[0] < dinero[5] ? "SÍ" : "NO") +"\n");
    }
    
    static  void main()
    {
        final byte DIAS_ABIERTO = 6;
        float[] ganancias = new float[DIAS_ABIERTO];

        do
        {
            ventasSemanales(ganancias, DIAS_ABIERTO);
            if(ganancias[0] != -1)
            {
                resumenSemanal(ganancias.clone(), DIAS_ABIERTO);
                datosDomingo(ganancias.clone(), DIAS_ABIERTO);
            }
        }while(ganancias[0] != -1);
    }
}
