package org.example;


import java.util.Scanner;

public class borrador
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        System.out.print("Número: ");
        int n = key.nextInt();
        //InputMismatchException comprende desde formatos erróneos hasta el StackOverflow
        key.nextLine();

        System.out.print("Número para convertir: ");
        String numero = key.nextLine();
        n = Integer.parseInt(numero);
        //NumberFormatException controla el .parseInt
    }
}