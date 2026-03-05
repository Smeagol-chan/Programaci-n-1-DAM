package org.example.ejercicios_stack;
import org.example.FuncionesComunes;

import java.util.Stack;

public class Ejercicio3
{
    static boolean parentesisCerrados(String equacion)
    {
        Stack<String> pila = new Stack<>();
        for(String token : equacion.split(""))
        {
            if(token.contains("(")) pila.push(token);
            else if(token.contains(")"))
            {
                if(pila.isEmpty()) pila.push(token);
                else
                {
                    if(pila.peek().contains("(")) pila.pop();
                    else pila.push(token);
                }
            }
        }
        return pila.isEmpty();
    }

    static void main()
    {
        System.out.print("Introduzca una equación: ");
        System.out.println(parentesisCerrados(FuncionesComunes.solicitarString()) ?
                "Válido" : "Inválido");
    }
}