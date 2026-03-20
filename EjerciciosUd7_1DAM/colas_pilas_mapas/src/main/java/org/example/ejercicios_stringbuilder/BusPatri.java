package org.example.ejercicios_stringbuilder;

public class BusPatri
{
    public static final int TAM = 97;

    public static void main(String[] args) throws InterruptedException
    {

        int a = 0; // POSICIÓN INICIAL DEL AUTOBÚS

        System.out.println("\n<<<<<<<<<< AUTOBUSITO >>>>>>>>>>");
        Thread.sleep(3000);

        while (a < TAM)
        {

            a++; // avanzamos

            limpiarPantalla();

            if (a < TAM)
            {
                System.out.println(dibujarCarrera(a));
                Thread.sleep(70);
            }

        }
        System.out.println("\033[32m" + "EL AUTOBUSITO HA LLEGADO A SU DESTINO!!" + "\033[0m");
    }

    public static String dibujarCarrera(int n1)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("-".repeat(117)).append("\n");
        sb.append(" ".repeat(n1)).append("________________    ").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|__|__|__|__|__|___ ").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|   IES MUTXAMEL  |)").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|~~~@~~~~~~~~~@~~~|)").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append("_".repeat(117));

        return sb.toString();
    }

    public static void limpiarPantalla()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
