package org.example;

import java.util.Scanner;

public class Ejercicio1
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        String textoOg, texto1, texto2;
        int longitud;

        System.out.println("Introduzca texto:");
        textoOg = key.nextLine();

        System.out.println(textoOg);
        longitud = textoOg.length();
        System.out.println(longitud);
        System.out.println(textoOg.replace(" ", ""));

        texto1 = textoOg.substring(0, longitud/2);
        texto2 = textoOg.substring(longitud/2);
        System.out.println("Primera mitad del texto es: "+ texto1 +"\nSegunda mitad del texto es: "+ texto2);
        System.out.println("El texto completo es: "+ texto1.concat(texto2));

        System.out.println("Y si lo grito queda así: "+ textoOg.toUpperCase());
    }
}
