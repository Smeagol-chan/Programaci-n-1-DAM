package org.example.ejercicios_queue;

import org.example.FuncionesComunes;

import java.util.Deque;
import java.util.LinkedList;

public class Ejercicio5
{
    static boolean palindromo(String palabra)
    {
        Deque<Character> palabraDividida = new LinkedList<>();
        for(int i = 0; i < palabra.length(); i++) palabraDividida.offer(palabra.charAt(i));

        while(!palabraDividida.isEmpty())
        {
            if(palabraDividida.peekFirst() == palabraDividida.pollLast())
            {
                palabraDividida.pollFirst();
                palabraDividida.pollLast();
            }
            else break;
        }
        return palabraDividida.isEmpty();
    }

    static void main()
    {
        System.out.print("Introduce una palabra: ");
        if(palindromo(FuncionesComunes.solicitarString())) System.out.println("Es palíndromo");
        else System.out.println("No es palíndromo.");
    }
}
