package org.example;

import java.util.ArrayList;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main()
    {
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        Stack<Integer> pila = new Stack<>();
        pila.push(4);
        pila.push(1);
        pila.push(3);

        System.out.println(pila.peek());
        pila.pop(); //También devuelve el valor que está siendo eliminado
        System.out.println(pila.peek());
    }
}
