package org.example.ejercicios_comparadores.ordenar_mapas;
import java.util.*;

public class CumpleApp3
{
    static void main()
    {
        TreeMap<Invitado3, String> mapaComparable = new TreeMap<>();    //Se puede meter dentro de new TreeMap<>(Comparator.reverseOrder()). Esto la ordna al revés.

        Invitado3 a = new Invitado3(25, "Eric");
        Invitado3 b = new Invitado3(12, "Álvaro");
        Invitado3 c = new Invitado3(53, "Carla");
        String regalo1 = "Botas";
        String regalo2 = "Alicates";
        String regalo3 = "Zapatos";

        mapaComparable.put(a, regalo1);
        mapaComparable.put(b, regalo2);
        mapaComparable.put(c, regalo3);

        List<Map.Entry<Invitado3, String>> listaInvitados = new LinkedList<>(mapaComparable.entrySet());

        listaInvitados.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); // También se puede poner aquí el Comparator.reverseOrder()

        for(Map.Entry<Invitado3, String> dato : listaInvitados)
            System.out.println(dato.getKey().getNombre() +" "+ dato.getValue());
    }
}
