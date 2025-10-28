package org.example.ActividadRandoms;
import java.util.Random;

public class Ejercicio1
{
    static void main()
    {
        Random random = new Random();
        int n1 = random.nextInt(6)+1, n2 = random.nextInt(1,7);
        /*
        n1 = (int) (random.nextDouble()*10+1);
        n1 = Math.random()*10+1;

        Son lo mismo. Nunca usar el Math.random();
         */

        System.out.println("Dado 1: "+ n1 +"\nDado 2: "+ n2 +"\nResultado: "+ (n1+n2));
    }
}
