package org.example.acepta_reto;
import java.util.HashMap;
import java.util.Scanner;

public class Modas
{
    static Scanner key = new Scanner(System.in);

    static int contador(int casos)
    {
        HashMap<Integer, Integer> mapa = new HashMap<>();
        int moda = 0, repeticiones = 0;

        for(int i = 0; i < casos; i++)
        {
            int num = key.nextInt();

            if(!mapa.containsKey(num)) mapa.put(num, 1);
            else mapa.put(num, mapa.get(num)+1);

            if(mapa.get(num) > repeticiones)
            {
                moda = num;
                repeticiones = mapa.get(num);
            }
        }
        return moda;
    }

    public static boolean casoDePrueba()
    {
        int casos = key.nextInt();
        if(casos == 0)
        return false;
        else
        {
            System.out.println(contador(casos));
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