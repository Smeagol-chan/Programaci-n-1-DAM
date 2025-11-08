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
        final int POTENCIA_TOTAL = 30, POTENCIA_MIN = 1, CANTIDAD_SAMURAIS = 7, INICIO_BATALLA = random.nextInt(CANTIDAD_SAMURAIS), BAJAS_MAX = 4;
        String potencia;
        String[] potenciasDivididasJ2, potenciasDivididasJ1 = null;
        int cont = 0, auxComprobante = 0, auxPotenciaJugador, bajasJ1 = 0, bajasJ2 = 0, i = INICIO_BATALLA;
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

        System.out.println("> La batalla la inicia el samurai Nº "+ (INICIO_BATALLA + 1) +".");
        //Desde la posici'on de inicio aleatorio se dan 7 vueltas. Cuandoo i >= 7, toca mirar las posiciones iniciales.
        while(i < (CANTIDAD_SAMURAIS + INICIO_BATALLA) && bajasJ1 < BAJAS_MAX && bajasJ2 < BAJAS_MAX)
        {
            cont = i < CANTIDAD_SAMURAIS ? i : i - CANTIDAD_SAMURAIS;
            System.out.print("> Samurai "+ (cont + 1) +". ");
            auxComprobante = Integer.parseInt(potenciasDivididasJ1[cont]);
            auxPotenciaJugador = Integer.parseInt(potenciasDivididasJ2[cont]);
            if(auxComprobante < auxPotenciaJugador)
            {
                System.out.print("Gana equipo 2. ");
                potenciasDivididasJ1[cont] = "0";
                bajasJ1++;
            }
            else if(auxComprobante > auxPotenciaJugador)
            {
                System.out.print("Gana equipo 1. ");
                potenciasDivididasJ2[cont] = "0";
                bajasJ2++;
            }
            else
            {
                System.out.print("Empate. ");
                potenciasDivididasJ2[cont] = "0";
                potenciasDivididasJ1[cont] = "0";
                bajasJ1++;
                bajasJ2++;
            }
            System.out.print(auxComprobante +" vs. "+ auxPotenciaJugador +"\n");
            i++;
        }
        if(bajasJ1 < bajasJ2)
        {
            System.out.println("> ¡Ejército 1 GANA! Equipo 2 ha tenido "+ bajasJ2 +" bajas.");
        }
        else if(bajasJ1 > bajasJ2)
        {
            System.out.println("> ¡Ejército 2 GANA! Equipo 1 ha tenido "+ bajasJ1 +" bajas.");
        }
        else
        {
            auxComprobante = 0;
            auxPotenciaJugador = 0;
            for(int j = 0; j < CANTIDAD_SAMURAIS; j++)
            {
                auxComprobante += Integer.parseInt(potenciasDivididasJ1[i]);
                auxPotenciaJugador += Integer.parseInt(potenciasDivididasJ2[i]);
            }
            if(auxComprobante != auxPotenciaJugador)
            {
                System.out.println("> ¡Ejército "+ (auxPotenciaJugador > auxComprobante ? "2" : "1") +" GANA! " +
                        "Ambos equipos han tenido "+ bajasJ2 +" bajas, pero el ejército "+ (auxPotenciaJugador > auxComprobante ? "2" : "1") +" tiene" +
                        " "+  (auxPotenciaJugador > auxComprobante ? auxPotenciaJugador : auxComprobante) +" de potencia restante. " +
                        "Una ventaja de "+ (auxPotenciaJugador > auxComprobante ? auxPotenciaJugador-auxComprobante : auxComprobante-auxPotenciaJugador) +".");
            }
            else
            {
                System.out.println("> ¡NINGÚN ejército ha ganado! Ambos han perdido "+ bajasJ2 +" y tienen "+ auxComprobante +" de potencia restante.");
            }
        }
    }
}