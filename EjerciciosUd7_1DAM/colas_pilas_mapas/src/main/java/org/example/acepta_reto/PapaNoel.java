package org.example.acepta_reto;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class PapaNoel
{
    public static Scanner key = new Scanner(System.in);
    public static void casoDePrueba()
    {
        int tamCola = key.nextInt(), posicion = key.nextInt()-1;
        int regalosAitor = 0, regalosPedidos = 0;
        Queue<Integer> cola = new LinkedBlockingDeque<>(tamCola);

        for (int i = 0; i < tamCola; i++)
        {
            int numRegalos = key.nextInt();
            if(i == posicion) regalosAitor = numRegalos;
            cola.offer(numRegalos);
        }

        while(regalosAitor != 0)
        {
            if(posicion == 0)
            {
                posicion = tamCola-1;
                regalosAitor--;
            }
            else posicion--;

            if(cola.peek() == 0) cola.offer(cola.poll());
            else
            {
                cola.offer(cola.poll()-1);
                regalosPedidos++;
            }
        }

        System.out.println(regalosPedidos*2);
    }

    public static void main(String[] args)
    {
        int numCasos = key.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}
