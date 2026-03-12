package org.example.ejercicios_map;

import org.example.FuncionesComunes;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio2
{
    static void main()
    {
        HashMap<Character, Integer> mapa = new HashMap<>();

        System.out.print("Introduce una palabra: ");
        String palabra = FuncionesComunes.solicitarString().toLowerCase();

        for(Character letra : palabra.toCharArray())
        {
            if(mapa.containsKey(letra)) mapa.put(letra, mapa.get(letra)+1);
            else mapa.put(letra, 1);
        }

        for(Map.Entry<Character, Integer> dato : mapa.entrySet())
            System.out.println(dato.getKey() + ": " + dato.getValue() + " veces");

        System.out.println(mapa.size());
    }
}
