package org.example.ejercicios_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio3
{
    static void main()
    {
        Queue<String> colaReproduccion = new LinkedList<>();
        colaReproduccion.offer("Duality - Slipknot");
        colaReproduccion.offer("Vermilion - Slipknot");
        colaReproduccion.offer("Vermilion Pt.2 - Slipknot");

        System.out.println("Estado inicial de la playlist: "+ colaReproduccion);
        while(!colaReproduccion.isEmpty())
        {
            System.out.println("Reproduciendo: "+ colaReproduccion.poll());
            System.out.println("Estado actual de la playlist: "+ colaReproduccion);
        }
        System.out.println("La playlist ha terminado.");
    }
}