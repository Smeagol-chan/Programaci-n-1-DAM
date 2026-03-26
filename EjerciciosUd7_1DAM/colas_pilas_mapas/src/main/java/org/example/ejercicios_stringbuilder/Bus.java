package org.example.ejercicios_stringbuilder;
import java.util.Random;

public class Bus
{
    public static final int TAM = 120;
    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException
    {

        int mutxamel = 0, mareNostrum = 0, balmis = 0, busQueAvanza;

        System.out.println("\n<<<<<<<<<< CARRERA DE AUTOBUSES >>>>>>>>>>");
        Thread.sleep(3000);


        while (mutxamel < TAM && mareNostrum < TAM && balmis < TAM)
        {
            limpiarPantalla();
            busQueAvanza = random.nextInt(3)+1;

            switch(busQueAvanza)
            {
                case 1:
                    mutxamel++;
                    break;
                case 2:
                    mareNostrum++;
                    break;
                case 3:
                    balmis++;
                    break;
            }
            System.out.println(dibujarBusMutxamel(mutxamel, mareNostrum, balmis));
            Thread.sleep(10);

        }
        System.out.println("\033[32m" + "¡¡HA GANADO IES "+ (mutxamel == TAM ? "MUTXAMEL" : mareNostrum == TAM ? "MARE NOSTRUM" : "BALMIS") +"!!" + "\033[0m");
    }

    public static String dibujarBusMutxamel(int avanceMutxamel, int avanceMareNostrum, int avanceBalmis)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("-".repeat(143)).append("\n");
        sb.append(" ".repeat(avanceMutxamel)).append("___________________    ").append(" ".repeat(TAM - avanceMutxamel)).append("|\n");
        sb.append(" ".repeat(avanceMutxamel)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - avanceMutxamel)).append("|\n");
        sb.append(" ".repeat(avanceMutxamel)).append("|    IES MUTXAMEL    |)").append(" ".repeat(TAM - avanceMutxamel)).append("|\n");
        sb.append(" ".repeat(avanceMutxamel)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - avanceMutxamel)).append("|\n");
        sb.append("-".repeat(143)).append("\n");
        sb.append(" ".repeat(avanceMareNostrum)).append("___________________    ").append(" ".repeat(TAM - avanceMareNostrum)).append("|\n");
        sb.append(" ".repeat(avanceMareNostrum)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - avanceMareNostrum)).append("|\n");
        sb.append(" ".repeat(avanceMareNostrum)).append("|  IES MARE NOSTRUM  |)").append(" ".repeat(TAM - avanceMareNostrum)).append("|\n");
        sb.append(" ".repeat(avanceMareNostrum)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - avanceMareNostrum)).append("|\n");
        sb.append("-".repeat(143)).append("\n");
        sb.append(" ".repeat(avanceBalmis)).append("___________________    ").append(" ".repeat(TAM - avanceBalmis)).append("|\n");
        sb.append(" ".repeat(avanceBalmis)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - avanceBalmis)).append("|\n");
        sb.append(" ".repeat(avanceBalmis)).append("|     IES BALMIS     |)").append(" ".repeat(TAM - avanceBalmis)).append("|\n");
        sb.append(" ".repeat(avanceBalmis)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - avanceBalmis)).append("|\n");
        sb.append("_".repeat(143));

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
