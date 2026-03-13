package org.example.acepta_reto;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TecladoEstropeado
{
    public static boolean casoDePrueba()
    {
        Scanner key = new Scanner(System.in);
        if (!key.hasNext())
        {
            return false;
        }
        else
        {
            ArrayList<Character> list = new ArrayList<>();
            ListIterator<Character> iterator = list.listIterator();

            String texto = key.nextLine();

            for(Character letra : texto.toCharArray())
            {
                switch(letra)
                {
                    case '-':
                        while(iterator.hasPrevious())
                        {
                            iterator.previous();
                        }
                        break;

                    case '+':
                        while(iterator.hasNext())
                        {
                            iterator.next();
                        }
                        break;

                    case '*':
                        if(iterator.hasNext())
                        {
                            iterator.next();
                        }
                        break;

                    case '3':
                        if(iterator.hasNext())
                        {
                            iterator.next();
                            iterator.remove();
                        }
                        break;

                    default:
                        iterator.add(letra);
                        break;
                }
            }
            for(Character letra : list)
            {
                System.out.print(letra);
            }
            System.out.println();
            return true;
        }
    }

    public static void main(String[] args)
    {
        while (casoDePrueba()) {
        }
    }
}
