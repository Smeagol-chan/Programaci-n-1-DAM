package org.example.acepta_reto;

import java.util.HashMap;
import java.util.Scanner;

public class LigaPadel
{
    static Scanner key = new Scanner(System.in);

    static String liga()
    {
        String[] partido;
        HashMap<String, Integer> mapa = new HashMap<>();
        do
        {
            partido = key.nextLine().split("");
            if(partido[0].equals("FIN")) break;
            for(int i = 0; i < 4; i = i+2)
            {
                if(mapa.containsKey(partido[i])) mapa.put
            }

        }while(true);

        return "resultado";
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

//  A 3 B 0
//  A 3 D 0
//  A 2 C 1
//
//  B 0 A 3
//  B 0 C 3
//
//  C 1 A 2
//  C 3 B 0
//  C 2 D 1
//
//  D 0 A 3
//  D 1 C 2
