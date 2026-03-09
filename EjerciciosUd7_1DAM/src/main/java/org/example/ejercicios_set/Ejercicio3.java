package org.example.ejercicios_set;

import java.util.Stack;

public class Ejercicio3
{
    static void main()
    {
        Stack<Informe> pilaInformes = new Stack<>();
        pilaInformes.push(new Informe("PERSONAL"));
        pilaInformes.push(new Informe("ADMINISTRATIVO"));
        pilaInformes.push(new Informe("PERSONAL"));
        pilaInformes.push(new Informe("EMPRESARIAL"));
        pilaInformes.push(new Informe("EMPRESARIAL"));

        System.out.println("Tareas:");
        for(Informe informe : pilaInformes)
            System.out.println("["+ informe +"]");

        System.out.println("\nDespachando...");
        for(int i = pilaInformes.size(); i > 0; i--)
            System.out.println(pilaInformes.pop());

        pilaInformes.push(new Informe("PERSONAL"));
        pilaInformes.push(new Informe("ADMINISTRATIVO"));
        pilaInformes.push(new Informe("ADMINISTRATIVO"));

        System.out.println("\nTareas nuevas (orden de despacho):");
        for(int i = pilaInformes.size()-1; i >= 0; i--)
            System.out.println("["+ pilaInformes.get(i) +"]");
    }
}