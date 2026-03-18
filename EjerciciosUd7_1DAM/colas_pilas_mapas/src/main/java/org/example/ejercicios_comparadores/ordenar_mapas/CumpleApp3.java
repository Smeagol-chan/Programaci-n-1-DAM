package org.example.ejercicios_comparadores.ordenar_mapas;

import java.util.Map;
import java.util.TreeMap;

public class CumpleApp3
{
    static void main()
    {
        Map<Invitado3, String> mapaComparable = new TreeMap<>();
        Invitado3 a = new Invitado3(25, "Eric");
        Invitado3 b = new Invitado3(12, "Álvaro");
        Invitado3 c = new Invitado3(53, "Carla");
    }
}
