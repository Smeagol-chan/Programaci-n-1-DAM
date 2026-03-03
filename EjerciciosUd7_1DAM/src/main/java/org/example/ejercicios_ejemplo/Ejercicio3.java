package org.example.ejercicios_ejemplo;
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
                if(!pila.isEmpty() && pila.peek().contains("(")) pila.pop();
                else pila.push(token);
            }
        }
        return pila.isEmpty();
    }

    static void main()
    {
        System.out.print("Introduzca una equación: ");
        String equacion = FuncionesComunes.solicitarString();
        System.out.println(parentesisCerrados(equacion) ? "Válida" : "Inválida");
    }
}
