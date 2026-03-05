package org.example.acepta_reto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PatentesisBalanceados
{
    static Scanner key = new Scanner(System.in);
    static final Character[] ABIERTOS = {'(', '{', '['};
    static final Character[] CERRADOS = {')', '}', ']'};

    public static boolean valido(String texto)
    {
        Stack<Character> pila = new Stack<>();
        for(int i = 0; i < texto.length(); i++)
        {
            if(Arrays.asList(ABIERTOS).contains(texto.charAt(i))) pila.push(texto.charAt(i));
            else if(Arrays.asList(CERRADOS).contains(texto.charAt(i)))
            {
                if(pila.isEmpty()) return false;
                else
                {
                    if(pila.peek() == ABIERTOS[Arrays.asList(CERRADOS).indexOf(texto.charAt(i))]) pila.pop();
                    else return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static boolean casoDePrueba()
    {
        if (!key.hasNext())
            return false;
        else
        {
            System.out.println(valido(key.nextLine()) ? "YES" : "NO");
            return true;
        }
    }

    public static void main(String[] args)
    {
        while (casoDePrueba())
        {
        }
    }
}
