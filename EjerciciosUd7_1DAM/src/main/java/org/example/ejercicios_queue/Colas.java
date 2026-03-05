package org.example.ejercicios_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Colas
{
    static void main()
    {
        Deque<String> cola = new LinkedList<>();

        cola.poll();
        //.add y .remove sí que salta error si la cola está vacía.

        cola.offer("Pedro");
        cola.offer("Carlos");
        cola.offer("Cristina");
        System.out.println(cola.peek());

        cola.poll();
        System.out.println(cola.peek());
        System.out.println(cola);

        //Cosas exclusivas de Dequeue
        cola.offerFirst("Juanma");
        System.out.println(cola);
        System.out.println(cola.peek());

        cola.pollLast();
        System.out.println(cola);

        //Capacidad de la lista
        Queue<String> cola2 = new ArrayBlockingQueue<>(2);

        cola2.offer("Juan");
        cola2.offer("Jorge");
        cola2.offer("Chema");   //No da error, pero no guarda más datos del límite

        System.out.println(cola2);
    }
}
