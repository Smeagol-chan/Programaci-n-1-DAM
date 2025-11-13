package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
ORDENAR MENOR A MAYOR
Arrays.sort(vector);    ->  NO PUEDE SER DATO PRIMITIVO (comprobar, que no sé)

ORDENAR MAYOR A MENOR
Arrays.sort(vector, Collections.reverseOrder());    ->  NO PUEDE SER DATO PRIMITIVO

BUSCAR EN ARRAY ORDENADO
Arrays.binarySearch(vector, num)    ->  Devuelve la posición. Negativo si no encuntra nada. MISMO TIPO (int != Integer)
Es una ordenación donde se coge de anclaje la primera posición y la última. Sumando ambas posiciones y dividiento entre dos.
Se compara la posición resultante -el centro- con el número a buscar. Si el número del vector es mayor, el anclaje derecho cambia al adyacente izquierdo,
si es menor, es el izquierdo el que se sitúa en el flanco derecho. En el momento en el que se compare con el número correcto, se acabará y devolverá la posición. Si no encuentra nada, dará un negativo.
 */

public class EliminarDuplicados
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        final int TAM_MAX = 10, RAN_MAX = 100;
        Integer[] vector1 = new Integer[TAM_MAX + 1];
        Integer[] vector2 = new Integer[TAM_MAX + 1];
        int modo, repetidos = 0;

        for(int i = 0; i < vector1.length; i++)
        {
            vector1[i] = random.nextInt(RAN_MAX);
            vector2[i] = 0;
        }
        Arrays.sort(vector1);

        System.out.println("\t*** MENÚ ***\n1. Eliminar con un auxiliar\n2. Eliminar sin auxiliar\n3. Recalcular duplicados");
        System.out.print("> ");
        modo = key.nextInt();
        System.out.println(Arrays.toString(vector1));

        //TENGO QUE COMPRIBAR CON EL DE LA IZQUIERDA. Ahora no tengo mucho tiempo; lo hago en casa.
        switch (modo)
        {
            case 1:
                modo = 0;
                for(int i = 0; i < vector1.length-1; i++)
                {
                    if(vector1[i+1] != vector1[i])
                    {
                        vector2[modo] = vector1[i];
                        modo++;
                        if(i == vector1.length-2)
                        {
                            vector2[modo] = vector1[i+1];
                        }
                    }
                    else
                    {
                        repetidos++;
                    }
                }
                Integer vectorFinal1[] = new Integer[vector1.length-repetidos];
                for (int i = 0; i < vectorFinal1.length; i++) vectorFinal1[i] = vector2[i];

                System.out.println(Arrays.toString(vectorFinal1));
                break;

            case 2:
                modo = 0;
                for(int i = 0; i < vector1.length-1; i++)
                {
                    if(vector1[i+1] != vector1[i])
                    {
                        vector1[modo] = vector1[i];
                        modo++;
                        if(i == vector1.length-2)
                        {
                            vector1[modo] = vector1[i+1];
                        }
                    }
                    else
                    {
                        repetidos++;
                    }
                }
                Integer vectorFinal2[] = new Integer[vector1.length-repetidos];
                for (int i = 0; i < vectorFinal2.length; i++) vectorFinal2[i] = vector1[i];

                System.out.println(Arrays.toString(vectorFinal2));
                break;

            case 3: //Este sí que lo tengo bien, pero tiene que reiniciar el for haasta que no hayan repetidos
                do
                {
                    repetidos = 0;
                    for(int i = 1; i < vector1.length; i++)
                    {
                        while(vector1[i].equals(vector1[i-1]))
                        {
                            vector1[i] = random.nextInt(RAN_MAX);
                            repetidos++;
                        }
                    }
                    if(repetidos != 0) Arrays.sort(vector1);
                }while(repetidos != 0);

                System.out.println(Arrays.toString(vector1));
                break;

            default:
                break;
        }
    }
}
