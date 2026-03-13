package org.example.ejercicios_iterator;

import org.example.FuncionesComunes;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ejercicio_ListIterator
{
    static void main()
    {
        List<Character> lista = new ArrayList<>();
        ListIterator<Character> iterador = lista.listIterator();
        String texto;

        System.out.print("Escribe: ");
        texto = FuncionesComunes.solicitarString();

        //for(Character letra : texto.toCharArray())

        for(int i = 0; i < texto.length(); i++)
        {
            switch(texto.charAt(i))
            {
                case '#':
                    if(iterador.hasPrevious())
                    {
                        iterador.previous();
                        iterador.remove();
                    }
                    break;

                case '<':
                    if(iterador.hasPrevious())
                        iterador.previous();
                    break;

                case '>':
                    if(iterador.hasNext())
                        iterador.next();
                    break;

                default:
                    iterador.add(texto.charAt(i));
                    break;
            }
        }

        System.out.print("Salida: ");
        for(Character letra : lista)
            System.out.print(letra);
    }
}
