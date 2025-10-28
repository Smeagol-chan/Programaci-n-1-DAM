package org.example.bateria_preexamen;
import java.util.Scanner;

public class Ejercicio3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int meses, pagos, total=0;

        System.out.print("Meses de financiación: ");
        meses = key.nextInt();
        System.out.print("Pago mensual: ");
        pagos = key.nextInt()/2;

        System.out.println("\nFinanciación a "+ meses +" meses");
        for(int i = 1; i <= meses; i++)
        {
            pagos *= 2;
            System.out.println("Mes "+ i +": "+ pagos +"€");
            total += pagos;
        }
        System.out.println("Total a pagar: "+ total +"€");
    }
}
