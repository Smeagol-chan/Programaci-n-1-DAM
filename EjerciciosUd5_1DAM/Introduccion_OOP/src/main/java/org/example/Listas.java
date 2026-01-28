package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Introducción al ArrayList. No permite tipos primitivos.
 */
public class Listas
{
    static void main()
    {
        ArrayList<Integer> listaNums = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            listaNums.add(i);
        }

        System.out.println();
        System.out.println("Cantidad elementos: "+ listaNums.size());
        listaNums.add(2, 12);
        System.out.println("Cantidad elementos: "+ listaNums.size());

        System.out.println();
        System.out.println("Elemento posición 2: "+ listaNums.get(2));
        System.out.println("Contenido lista: "+ listaNums);

        System.out.println();
        System.out.println("El tipo Integer no permite borrar por valor, solo por posición: ");
        listaNums.remove(2);
        System.out.println(listaNums);
        System.out.println("Cantidad elementos: "+ listaNums.size());

        System.out.println();   //se puede usar contains
        System.out.println("El 3 está en la posición: "+ listaNums.indexOf(3));
        System.out.println("El 12 no existe en la lista, por lo que devuelve: "+ listaNums.indexOf(12));

        System.out.println();
        System.out.println("Imprimiendo con un for/each:");
        for(Integer num : listaNums) System.out.print(num +" ");
        System.out.println("Imprimiendo con un for:");
        for (int i = 0; i < listaNums.size(); i++) System.out.println("Número "+ (i+1) +": "+ listaNums.indexOf(i));

        System.out.println();
        System.out.println("Se cambia el valor de la posición 0:");
        listaNums.set(0, 12);
        System.out.println(listaNums);

        //Evitar usar .clone() porque devuelve tipo Object
        Object copiaMala = listaNums.clone();
        ArrayList<Integer> copiaBuena = new ArrayList<>(listaNums);
        System.out.println();
        System.out.println("Contenido copia: "+ copiaBuena);

        System.out.println();
        System.out.println("¿Lista vacía?: "+ listaNums.isEmpty());
        System.out.println("Limpiando lista...");
        listaNums.clear();
        System.out.println("¿Lista vacía?: "+ listaNums.isEmpty());
        System.out.println("Contenido: "+ listaNums);

        System.out.println();
        System.out.println("Añadiendo contenido nuevo...");
        listaNums.addAll(Arrays.asList(10, 9, 8, 7));
        System.out.println("Nuevo contenido: "+ listaNums);
    }
}
