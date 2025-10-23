package org.example.bateria_bucle;
import java.util.Scanner;

public class Ejercicio1
{
    static void main()
    {
        final String CODE = "dam1";
        Scanner key = new Scanner(System.in);
        String contrasenya;
        boolean fallo;

        do
        {
            System.out.print("Contraseña: ");
            contrasenya = key.nextLine();

            fallo = !contrasenya.equals(CODE) ? true : false;
        }while(fallo);
    }
}
