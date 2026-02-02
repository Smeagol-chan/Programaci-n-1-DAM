package org.example;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FuncionesComunes
{
    public static Scanner key = new Scanner(System.in);
    public static Random random = new Random();

    public static boolean negativoInt(int n)
    {
        return n < 0;
    }

    public static boolean limiteInferiorInt(int n, int l)
    {
        boolean inf = n < l;
        if(inf) System.out.println("ERROR\nNo pueden haber datos menores a "+ l +".\n");
        return inf;
    }

    public static boolean limiteSuperiorInt(int n, int l)
    {
        boolean sup = n > l;
        if(sup) System.out.println("ERROR\nNo pueden haber datos mayores a "+ l +".\n");
        return sup;
    }

    public static int filtroLimitesInt(int lInf, int lSup)
    {
        int n;
        do
        {
            n = solicitudInt();
        }while(limiteInferiorInt(n, lInf) || limiteSuperiorInt(n, lSup));
        return n;
    }

    public static int solicitudInt()
    {
        int n = 0;
        boolean fallo;

        do
        {
            fallo = false;
            try
            {
                n = key.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se pueden introducir números.\n");
                fallo = true;
                key.nextLine();
            }
        }while(fallo);
        return n;
    }

    public static int[] solicitudVectorInt(int tam, String sep)
    {
        String[] vS;
        int[] vI = new int[tam];
        int cont;
        boolean fallo;

        do
        {
            fallo = false;
            cont = 0;
            System.out.print("> ");
            vS = key.nextLine().split(sep);
            if(vS.length == tam)
            {
                while(!fallo && cont < tam)
                {
                    try
                    {
                        vI[cont] = Integer.parseInt(vS[cont]);
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("ERROR\nNo se permiten carácteres a parte del separador establecido: "+
                                (sep.contains(" ") ? "[espacio]" : sep) +"\n");
                        fallo = true;
                    }
                    cont++;
                }
            }
            else
            {
                System.out.println("ERROR\nSe deben introducir "+ tam +" datos.\n");
                fallo = true;
            }

        }while(fallo);
        return vI;
    }

    public static int solicitudPositivosInt()
    {
        int n;
        boolean fallo;
        do
        {
            n = solicitudInt();
            fallo = negativoInt(n);
            if(fallo) System.out.println("ERROR\nSolo se permiten números positivos.");
        }while(fallo);
        return n;
    }

    public static char solicitudChar()
    {
        boolean fallo;
        char c = 'c';
        String s;

        do
        {
            fallo = false;
            s = solicitarString();
            if(s.length() != 1)
            {
                System.out.println("ERROR\nSe debe introducir 1 carácter.");
                fallo = true;
            }
            else
            {
                c = s.charAt(0);
            }
        }while(fallo);
        return c;
    }

    public static char filtroChar(char[] permitidos)
    {
        char letra;
        boolean fallo;

        do
        {
            fallo = false;
            letra = solicitudChar();

            for (int i = 0; i < permitidos.length; i++)
            {
                if(letra != permitidos[i])
                {
                    if(i == permitidos.length-1)
                    {
                        System.out.println("ERROR\nCarácter introducido inválido.");
                        fallo = true;
                    }
                }
                else
                {
                    break;
                }
            }
        }while(fallo);
        return letra;
    }

    public static String solicitarString()
    {
        boolean fallo;
        String s;
        do
        {
            fallo = false;
            s = key.nextLine();
            if(s.length() == 0)
            {
                System.out.println("ERROR\nLa frase debe contener un carácter como mínimo.");
                fallo = true;
            }
        }while(fallo);
        return s;
    }

    public static char[] separarLetrasString()
    {
        char[] frase = solicitarString().toCharArray();
        return frase.clone();
    }

    public static void limpiarConsola() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static int digitos(int n)
    {
        int cont = 0;
        if(n > 9) cont = digitos(n/10);
        cont++;
        return cont;
    }
}
