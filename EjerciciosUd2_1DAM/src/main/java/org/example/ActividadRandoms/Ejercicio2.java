package org.example.ActividadRandoms;
import java.util.Random;

public class Ejercicio2
{
    static void main()
    {
        Random random = new Random();
        final int TAMANYO = 12;
        final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String contrasenya = "";

        for(int i = 0; i < TAMANYO; i++)
        {
            contrasenya += CARACTERES.charAt(random.nextInt(CARACTERES.length())-1);
        }
        System.out.println(contrasenya);
    }
}
