package org.example.bateria_preexamen;

import java.util.Scanner;

public class Ejercicio5
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int MIL = 1000, CANTIDAD_SUELDOS = 5;
        int sueldo = 0, sueldoMax = 0, contador = 0;

        for(int i = 1; i <= CANTIDAD_SUELDOS; i++)
        {
            System.out.print("Sueldo nº"+ i +": ");
            sueldo = key.nextInt();

            if(sueldo > MIL) contador++;
            if(sueldo > sueldoMax) sueldoMax = sueldo;
        }
        System.out.println("\nEl sueldo más alto es: "+ sueldoMax +"\n"+ contador +" trabajadores cobran más de "+ MIL +"€.");
    }
}
