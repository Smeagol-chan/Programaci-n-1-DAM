package org.example.acepta_reto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LigaPadel
{
    static Scanner key = new Scanner(System.in);

    static String liga()
    {
        String ganador = "";
        int mayorPuntuacion = 0, partidosJugados = 0;
        String[] partido;
        HashMap<String, Integer> mapa = new HashMap<>();
        do
        {
            partido = key.nextLine().split(" ");
            if(partido[0].equals("FIN")) break;

            if(!mapa.containsKey(partido[0])) mapa.put(partido[0], 0);
            if(!mapa.containsKey(partido[2])) mapa.put(partido[2], 0);

            if(Integer.parseInt(partido[1]) > Integer.parseInt(partido[3]))
            {
                mapa.put(partido[0], mapa.get(partido[0])+2);
                mapa.put(partido[2], mapa.get(partido[2])+1);
            }
            else
            {
                mapa.put(partido[0], mapa.get(partido[0])+1);
                mapa.put(partido[2], mapa.get(partido[2])+2);
            }
            partidosJugados++;
        }while(true);

        for(Map.Entry<String, Integer> equipo : mapa.entrySet())
        {
            if(mayorPuntuacion < equipo.getValue())
            {
                ganador = equipo.getKey();
                mayorPuntuacion = equipo.getValue();
            }
            else if(mayorPuntuacion == equipo.getValue())
                ganador = "EMPATE";
        }

        return ganador + " " + (mapa.size() * (mapa.size() - 1) - partidosJugados);
    }

    public static boolean casoDePrueba()
    {
        String categoria = key.nextLine();
        if(categoria.equals("FIN"))
        return false;
        else
        {
            System.out.println(liga());
            return true;
        }
    }

    public static void main(String[] args)
    {
        while (casoDePrueba())
        {
        }
    }
}