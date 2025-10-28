package org.example.bateria_preexamen;

import java.util.Scanner;

public class Ejercicio7
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int cantidad = 0, num1 = 0, num2 = 1, aux;
        boolean fallo;

        System.out.println("\n\t**** FIBONACCI ****\n");
        do
        {
            fallo = false;
            System.out.print("Inserte cantidad de números de la cadena que desea ver: ");
            if(key.hasNextInt())
            {
                cantidad = key.nextInt();
                if(cantidad < 0)
                {
                    System.out.println("ERROR\nNo se permiten números negativos.\n");
                    fallo = true;
                }
            }
            else
            {
                System.out.println("ERROR\nCarácter inválido.\n");
                fallo = true;
            }
            key.nextLine();
        }while(fallo);

        System.out.print("\nSecuencia de Fibonacci: ");
        if(cantidad > 0)
        {
            System.out.print(num1 +" ");
            if(cantidad > 1)
            {
                System.out.print(num2 +" ");
                if(cantidad > 2)
                {
                    for(int i = 2; i < cantidad; i++)
                    {
                        aux = num1;
                        num1 = num2;
                        aux += num2;
                        num2 = aux;
                        System.out.print(num2 +" ");
                    }
                }
            }
        }
    }
}
