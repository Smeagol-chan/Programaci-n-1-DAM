package org.example.bateria_preexamen;
import java.util.Scanner;

public class Ejercicio1
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int cantidad, num, pos = 0, neg = 0, cero = 0;

        System.out.print("¿Cuántos números quieres introducir?\n> ");
        cantidad = key.nextInt();

        for(int i = 0; i < cantidad; i++)
        {
            System.out.print("Introduce el "+ (i + 1) +"º número: ");
            num = key.nextInt();

            if(num > 0)
            {
                pos++;
            }
            else if (num < 0)
            {
                neg++;
            }
            else cero++;
        }
        System.out.println("\nHas introducido "+ pos +" números positivos, "+ neg +" negativos y "+ cero +" ceros.");

    }
}
