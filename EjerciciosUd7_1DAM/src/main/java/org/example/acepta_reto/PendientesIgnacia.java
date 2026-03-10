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
        ArrayList<Integer> pendientes = new ArrayList<>();
        int pares = 0;
        for (int i = 0; i < casos; i++)
            pendientes.add(key.nextInt());

        for(Integer pendiente : pendientes)
        {
            if(pendientes.isEmpty()) desparejados.add(pendiente);
        }
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
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}
