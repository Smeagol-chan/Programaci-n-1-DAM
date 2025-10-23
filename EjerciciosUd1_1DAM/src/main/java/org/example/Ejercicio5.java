package org.example;

import java.util.Scanner;

public class Ejercicio5
{
    static void main()
    {
        Scanner key =  new Scanner(System.in);
        double n1, n2;
        boolean fallo;

        do
        {
            fallo = false;

            System.out.print("Introduzca el dividendo: ");
            n1 = key.nextInt();
            System.out.print("Introduzca el divisor: ");
            n2 = key.nextInt();

            if(n2 == 0)
            {
                fallo = true;
                System.out.println("ERROR.\nEl divisor no puede ser igual a cero.");
            }
        }while(fallo);

        System.out.println("La división de "+ n1 +" entre "+ n2 +" da "+ (n1/n2) +" de resultado.");
    }
}
