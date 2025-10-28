package org.example.ActividadRandoms;
import java.util.Random;

public class Ejercicio4
{
    static void main()
    {
        Random random = new Random();
        final String CARACTERES_MAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String CARACTERES_MIN = "abcdefghijklmnopqrstuvwxyz";
        final String CARACTERES_NUM = "0123456789";
        final String CARACTERES_TOTALES = CARACTERES_MAY + CARACTERES_MIN + CARACTERES_NUM;
        final int TAM_MAX = 9, TAM_MIN = 5;
        int tamanyo = random.nextInt(TAM_MAX - TAM_MIN + 1) + TAM_MIN;
        String contrasenya = "";

        for(int i = 0; i < tamanyo; i++)
        {
            contrasenya += CARACTERES_TOTALES.charAt(random.nextInt(CARACTERES_TOTALES.length()-1));
        }
        contrasenya += CARACTERES_MAY.charAt(random.nextInt(CARACTERES_MAY.length()-1));
        contrasenya += CARACTERES_MIN.charAt(random.nextInt(CARACTERES_MIN.length()-1));
        contrasenya += CARACTERES_NUM.charAt(random.nextInt(CARACTERES_NUM.length()-1));
        System.out.println(contrasenya +"\n"+contrasenya.length());
    }
}
