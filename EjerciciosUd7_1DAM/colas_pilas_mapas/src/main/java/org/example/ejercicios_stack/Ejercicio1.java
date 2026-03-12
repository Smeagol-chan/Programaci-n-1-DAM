package org.example.ejercicios_stack;

import java.util.Stack;

public class Ejercicio1
{
    static void main()
    {
        Stack<Character> pilaChar = new Stack<>();
        pilaChar.add('a');
        pilaChar.add('b');
        pilaChar.add('c');
        pilaChar.add('d');
        pilaChar.add('e');
        System.out.println(pilaChar.isEmpty());
        System.out.println(pilaChar.size());
        System.out.println(pilaChar.peek());
        System.out.println(pilaChar.pop());
        System.out.println(pilaChar.size());
        System.out.println(pilaChar.peek());
    }
}
