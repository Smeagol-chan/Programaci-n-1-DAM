package org.example.acepta_reto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PendientesIgnacia
{
    static Scanner key = new Scanner(System.in);

    public static int contarPares(int casos)
    {
        Set<Integer> desparejados = new HashSet<>();
        ArrayList<Integer> joyero = new ArrayList<>();
        int pares = 0;

        for (int i = 0; i < casos; i++)
            joyero.add(key.nextInt());

        for(Integer pendiente : joyero)
        {
            int tamannoAntes = desparejados.size();
            desparejados.add(pendiente);

            if(tamannoAntes == desparejados.size())
            {
                desparejados.remove(pendiente);
                pares++;
            }
        }
        return pares;
    }

    public static boolean casoDePrueba() {
        int casos = key.nextInt();
        if (casos == 0)
        return false;
        else {
            System.out.println(contarPares(casos));
            return true;
        }
    }

    public static void main(String[] args) {
        while (casoDePrueba()) {
        }
    }
}
