package org.example.ejercicios_map;

import org.example.FuncionesComunes;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio1
{
    static void main()
    {
        HashMap<String, Integer> mapa = new HashMap<>();

        System.out.print("Introduce una frase: ");
        String frase = FuncionesComunes.solicitarString().toLowerCase();

//        for(String palabra : frase.split(" "))
//        {
//            if(mapa.containsKey(palabra)) mapa.put(palabra, mapa.get(palabra)+1);
//            else mapa.put(palabra, 1);
//        }

        for(String palabra : frase.split(" "))
            mapa.put(palabra, mapa.getOrDefault(palabra, 0)+1);

        for(Map.Entry<String, Integer> dato : mapa.entrySet())
            System.out.println(dato.getKey() + ": " + dato.getValue() + " veces");
    }
}
