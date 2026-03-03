package org.example.ejercicios_ejemplo;

import org.example.FuncionesComunes;

import java.util.Stack;

public class Ejercicio2
{
    static String invertirFrase(String frase)
    {
        String delReves = "";
        Stack<Character> pila = new Stack<>();
        for(String token : frase.split(""))
            pila.push(token.charAt(0));

        while(!pila.isEmpty())
            delReves += pila.pop();

        return delReves;
    }

    static void main()
    {
        System.out.print("Introduce una frase: ");
        String frase = FuncionesComunes.solicitarString();
        System.out.println("\nFrase inversa: "+ invertirFrase(frase));
    }
}
