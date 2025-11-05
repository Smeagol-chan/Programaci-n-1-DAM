package org.example.bateriaArrays;
import java.util.Random;

public class Ejercicio6
{
    static void main()
    {
        Random random = new Random();
        final int MIN = 5, MAX = 10;
        int vector[] = new int[random.nextInt(MAX - MIN + 1) + MIN];
        boolean simetria = true;

        System.out.print("Array: ");
        for(int i = 0; i < vector.length; i++)
        {
            vector[i] = random.nextInt(MAX + 1);
            System.out.print(vector[i] + (i == vector.length - 1 ? "\n" : ", "));
        }

        for(int i = 0; i < vector.length/2; i++) if(vector[i] != vector[(vector.length - 1) - i]) simetria = false;
        System.out.println(simetria ? "Es simétrico." : "No es simétrico.");
    }
}
