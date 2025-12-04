package org.example.bateria1_iniciodemodulos;

import java.util.Scanner;

public class Ejercicio3
{
    private static String solicitud()
    {
        Scanner key = new Scanner(System.in);
        System.out.print("Introduzca una cadena: ");
        return key.nextLine();
    }

    private static String convertirMayus(String cadena)
    {
        return cadena.toUpperCase();
    }

    private static int contarVocales(String cadena)
    {
        final String vocales = "AEIOU";
        int numVoc = 0;
        cadena = convertirMayus(cadena);

        exterior:
        for(int i = 0; i < cadena.length(); i++)
        {
            for(int j = 0; j < vocales.length(); j++)
            {
                if(cadena.charAt(i) == vocales.charAt(j))
                {
                    numVoc++;
                    continue exterior;
                }
            }
        }
        return numVoc;
    }

    static void main()
    {
        String cad = solicitud();

        System.out.println("\nCadena introduc" + "ida:\n> "+ cad
                +"\nCadena convertida en mayúsculas:\n> "+ convertirMayus(cad)
                +"\nCantidad de vocales presentes:\n> "+ contarVocales(cad));

    }
}
