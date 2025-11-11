package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ruleta
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        final String COLOR[] = {"rojo","negro"}, PAR_IMPAR[] = {"par","impar"};
        final String COLOR_RESULTADO = COLOR[random.nextInt(COLOR.length)], PAR_IMPAR_RESULTADO = PAR_IMPAR[random.nextInt(PAR_IMPAR.length)];
        final int NUM_MAX = 36, NUM_RESULTADO = random.nextInt(NUM_MAX + 1), TAM_APUESTA = 3;
        Integer listaNumValidos[] = new Integer[NUM_MAX+1], numApuesta;
        String colorApuesta, parimparApuesta;

        for(int i = 0; i < NUM_MAX+1; i++)
        {
            listaNumValidos[i] = i;
        }
        System.out.println("\t**** LUDOPATÍA SIMULATOR 2025****");
        System.out.print("Introduzca el número: ");
        numApuesta = key.nextInt();
        if(!Arrays.asList(listaNumValidos).contains(numApuesta))
        {
            System.out.println("ERROR\nNúmero imposible.");
            return;
        }

        System.out.print("Introduzca el color: ");
        colorApuesta = key.next();
        colorApuesta = colorApuesta.toLowerCase();
        if(!Arrays.asList(COLOR).contains(colorApuesta))
        {
            System.out.println("ERROR\nColor imposible.");
            return;
        }

        System.out.print("Introduzca si par o impar: ");
        parimparApuesta = key.next();
        parimparApuesta = parimparApuesta.toLowerCase();
        if(!Arrays.asList(PAR_IMPAR).contains(parimparApuesta))
        {
            System.out.println("ERROR\nSolo par o imper.");
            return;
        }

        if(numApuesta == NUM_RESULTADO && COLOR_RESULTADO.contains(colorApuesta) && PAR_IMPAR_RESULTADO.contains(parimparApuesta))
        {
            System.out.println("HAS GANADO");
        }
        else if(numApuesta == NUM_RESULTADO)
        {
            System.out.println(NUM_RESULTADO == 0 ? "TE LO LLEVAS TODO" : ("Has acertado el número "+ NUM_RESULTADO));
        }
        else if(COLOR_RESULTADO.contains(colorApuesta))
        {
            System.out.println("Acertaste el color"+ COLOR_RESULTADO);
        }
        else if(PAR_IMPAR_RESULTADO.contains(parimparApuesta))
        {
            System.out.println("Acertaste si el número sería "+ parimparApuesta);
        }
        else
        {
            System.out.println("NO HAS ACERTADO NADA");
        }
    }
}
