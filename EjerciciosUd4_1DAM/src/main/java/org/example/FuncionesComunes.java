package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionesComunes
{
    public static Scanner key = new Scanner(System.in);

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
            System.out.print("> ");
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


}
