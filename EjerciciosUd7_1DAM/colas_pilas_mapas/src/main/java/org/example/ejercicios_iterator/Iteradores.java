package org.example.ejercicios_iterator;

import java.util.*;

public class Iteradores
{
    static void main()
    {
        TreeSet<String> lista = new TreeSet<>();
        lista.add("Bulbasaur");
        lista.add("Pikachu");
        lista.add("Charmander");
        lista.add("Magikard");
        lista.add("Squirtle");

        Iterator<String> iterador = lista.iterator();

        while(iterador.hasNext())
        {
            String pokemon = iterador.next();
            if(pokemon.equals("Pikachu"))
                iterador.remove();
        }


        LinkedHashMap<String, Integer> mapa = new LinkedHashMap<>();
        mapa.put("lunes", 1);
        mapa.put("martes", 2);
        mapa.put("miércoles", 3);
        mapa.put("jueves", 4);
        mapa.put("viernes", 5);
        mapa.put("sábado", 6);
        mapa.put("domingo", 7);

        System.out.println(mapa);

        Iterator<String> iteradorMapa = mapa.keySet().iterator();

        while(iteradorMapa.hasNext())
        {
            if(iteradorMapa.next().equals("viernes"))
                iteradorMapa.remove();
        }

        System.out.println(mapa);

        Iterator<Map.Entry<String, Integer>> iteradorMapa2 = mapa.entrySet().iterator();

        while(iteradorMapa2.hasNext())
        {
            Map.Entry<String, Integer> dato = iteradorMapa2.next();
            if(dato.getValue() == 3) iteradorMapa2.remove();
        }

        System.out.println(mapa);
    }
}
