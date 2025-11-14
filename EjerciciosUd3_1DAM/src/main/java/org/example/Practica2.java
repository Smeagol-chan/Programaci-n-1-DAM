package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//La primitiva. 6 números del 1 al 49 y 1 del 0 al 9. Los seis primeros son el premio y el último es el reintegro. Una final del 1 al 49, el complementario. Este no puede ser igual a los 6 primeros.
//5 aciertos en las primeras 6 y acierto en el complementario da el gordo igual.
public class Practica2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        //Declaro los números mínimos -ignorando el 0- y los máximos que pueden salir en cada tipo de tirada. También la cantidad de bolas totales que se van a lanzar.
        final int NUM_MIN_REGULARES = 1, NUM_MAX_REGULARES = 49, NUM_MAX_REINTEGRO = 9, CANTIDAD_REGULARES = 6, CANTIDAD_REINTEGRO = 1, CANTIDAD_COMPLEMENTARIOS = 1;   //Para soportar más de 1 complementario y 1 reintegro, debo declarar como array resultadoComplementario y un for para añadir el reintegro.
        Integer resultadoSorteo[] = new Integer[CANTIDAD_REGULARES + CANTIDAD_REINTEGRO + CANTIDAD_COMPLEMENTARIOS];
        int resultadoComplementario = random.nextInt(NUM_MAX_REGULARES - NUM_MIN_REGULARES + 1) + NUM_MIN_REGULARES;
        boolean repetido;

        //Creo en un for el número ganador. Queda mucho más limpio. La última posición se queda vacía para poder añadir el complementario sin que se repita con ninguno de los anteriores. El reintegro lo añadiré luego
        //ya que sí que se puede repetir con el complementario.
        for(int i = 0; i < CANTIDAD_REGULARES; i++) resultadoSorteo[i] = random.nextInt(NUM_MAX_REGULARES - NUM_MIN_REGULARES + 1) + NUM_MIN_REGULARES;

        do
        {
            repetido = Arrays.asList(resultadoSorteo).contains(resultadoComplementario);
            if(repetido) resultadoComplementario = random.nextInt(NUM_MAX_REGULARES - NUM_MIN_REGULARES + 1) + NUM_MIN_REGULARES;;
        }while(repetido);
    }
}
