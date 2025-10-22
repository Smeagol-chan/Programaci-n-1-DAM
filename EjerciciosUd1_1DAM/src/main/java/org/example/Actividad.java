package org.example;

import java.util.Scanner;

public class Actividad
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int n1, n2, resul;
        String nom, curso;

        System.out.print("Introduzca su nombre: ");
        nom = key.nextLine();
        System.out.print("Introduzca su curso: ");
        curso = key.nextLine();

        System.out.println("Buenas tardes "+ nom +". Bienvenida/o a "+ curso +".");

        System.out.print("Introduzca el primer número: ");
        n1 = key.nextInt();
        System.out.print("Introduzca el segundo número: ");
        n2 = key.nextInt();
        resul = n1 + n2;

        System.out.println("El resultado de la suma entre "+ n1 +" y "+ n2 +" es "+ resul +".");
    }
}
