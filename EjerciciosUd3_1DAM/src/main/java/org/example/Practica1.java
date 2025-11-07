package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

//Juego de dos jugadores donde, con sendas 7 fichas, los jugadores asignan un total de 30 puntos repartido entre sus fichas. Cada ficha representa a un samurai.
//Tras la asignación, los samurais combaten en orden iniciado desde una posición aleatoria. El mayor número siempre gana a uno menor. El jugador cuyo ejército pierda más de la mitad de batallas resulta perdedor.
//Si un samurai pierde, su potencia se iguala a 0. En caso de empate ambos mueren.
public class Practica1
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        Random random = new Random();
        final String SEPARADOR = " ";
        final int POTENCIA_TOTAL = 30, POTENCIA_MIN = 1, CANTIDAD_SAMURAIS = 7, INICIO_BATALLA = random.nextInt(CANTIDAD_SAMURAIS);
        String potencia;
        String[] potenciasDivididasJ2, potenciasDivididasJ1 = null;
        int cont = 0, auxComprobante = 0, auxPotenciaJugador;
        boolean fallo, jugador2 = false;    //jugador2 es para poder saber si el primer jugador ya a introducido la potencia. Cuando es true, es el turno del jugador 2 de imtroducir sus valores.

        System.out.println("\t**** BATALLA SAMURAI ****\n");
        //Vamos a pedir la introducción de la potencia. La potencia mínima que ha de tener cada pieza es 1 y la cantidad a asignar es 30.
        do
        {
            cont = 0;
            auxPotenciaJugador = 0;
            fallo = false;
            System.out.println("> Ejército "+ (jugador2 ? "2" : "1"));
            System.out.print("> Introduce la potencia de los samurais: ");
            potencia = key.nextLine();
            potenciasDivididasJ2 = potencia.split(SEPARADOR);

            //Comprobar si la cantidad de samurais es 7
            if(potenciasDivididasJ2.length == CANTIDAD_SAMURAIS)
            {
                //Comprobar que solo haya introducido números
                while(cont < CANTIDAD_SAMURAIS && !fallo)
                {
                    try
                    {
                        auxComprobante = Integer.parseInt(potenciasDivididasJ2[cont]);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("ERROR\nSolo pueden ser introducidos números.");
                        fallo = true;
                    }
                    if(!fallo)
                    {
                        //Comprobar que ningún samurai tenga menos de 1 de potencia
                        if(auxComprobante < POTENCIA_MIN)
                        {
                            System.out.println("ERROR\nLa potencia mínima por samurai es "+ POTENCIA_MIN +".");
                            fallo = true;
                        }
                        else
                        {
                            auxPotenciaJugador += auxComprobante;
                            cont++;
                        }
                    }
                }
            }
            else
            {
                System.out.println("ERROR\nDebes introducir valor a "+ CANTIDAD_SAMURAIS +" samurais.");
                fallo = true;
            }
            if(!fallo)
            {
                //Comprobar que no le queden puntos por asignar
                if(auxPotenciaJugador < POTENCIA_TOTAL)
                {
                    System.out.println("ERROR\nFaltan "+ (POTENCIA_TOTAL-auxPotenciaJugador) +" puntos por asignar.");
                    fallo = true;
                }
                //Comprobar que no haya introducido puntos de más
                else if(auxPotenciaJugador > POTENCIA_TOTAL)
                {
                    System.out.println("ERROR\nHas introducido "+ (auxPotenciaJugador-POTENCIA_TOTAL) +" puntos de más.");
                    fallo = true;
                }
                else
                {
                    if(!jugador2) potenciasDivididasJ1 = potenciasDivididasJ2.clone();
                    System.out.println("> Ejército asignado.");
                    jugador2 = !jugador2;
                }
            }
        }while(fallo || jugador2);

        //Si esto no funciona moveré todo INICIO_BATALLA posiciones cada array
        for(int i = INICIO_BATALLA; i < CANTIDAD_SAMURAIS + INICIO_BATALLA; i++)
        {
            if(potenciasDivididasJ1[])
        }
    }
}