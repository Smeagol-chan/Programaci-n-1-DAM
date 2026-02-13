package org.example;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase con métodos de uso recurrente.
 * @author ericr
 * @version 1.5 (06/02/2026)
 */
public class FuncionesComunes
{
    public static Scanner key = new Scanner(System.in);
    public static Random random = new Random();

    /**
     * Función que comprueba cuál es el día máximo del mes comprobando de qué mes se trata y si es un año bisiesto o no.
     * @param mes - Entero con el mes a comprobar.
     * @param any - Entero con el año a comprobar.
     * @return El número máximo posible de días: 31, 30, 29 ó 28.
     */
    public int diaMaximoDelMes(int mes, int any)
    {
        final int MES_31[] = {1, 3, 5, 7, 8, 10, 12};
        final int MES_30[] = {4, 6, 9, 11};
        final int DIA_MAXIMO_30 = 30;
        final int DIA_MAXIMO_28 = 28;

        if(Arrays.asList(MES_31).contains(mes)) return DIA_MAXIMO_30+1;
        else if(Arrays.asList(MES_30).contains(mes)) return DIA_MAXIMO_30;
        else if(any%4 == 0) return DIA_MAXIMO_28+1;
        else return DIA_MAXIMO_28;
    }

    /**
     * Método que comprueba si el entero es negativo o no.
     * @param n - entero sobre el que realizar la comprobación.
     * @return true/false - devolverá true si el número es menor estricto a 0 y false si no.
     */
    public static boolean negativoInt(int n)
    {
        return n < 0;
    }

    public static boolean negativoDouble(double n)
    {
        return n < 0;
    }

    /**
     * Método para comprobar si un número es superior a un límite inferior.
     * @param n - entero a comprobar
     * @param l - entero que delimita rango inferior
     * @return inf - devuelve el valor de inf, siendo true si n es menor a l y flase de caso contrario.
     */
    public static boolean limiteInferiorInt(int n, int l)
    {
        boolean inf = n < l;
        if(inf) System.out.println("ERROR\nNo pueden haber datos menores a "+ l +".\n");
        return inf;
    }

    /**
     * Método para comprobar si un número es inferior a un límite superior.
     * @param n - entero a comprobar
     * @param l - entero que delimita rango superior
     * @return sup - devuelve el valor de sup, siendo true si n es mayor a l y flase de caso contrario.
     */
    public static boolean limiteSuperiorInt(int n, int l)
    {
        boolean sup = n > l;
        if(sup) System.out.println("ERROR\nNo pueden haber datos mayores a "+ l +".\n");
        return sup;
    }

    /**
     * Método para solicitar al usuario ingresar un número controlando que se encuentre dentro de un rango establecido.
     * @param lInf - entero que sirve como rango mínimo.
     * @param lSup - entero que sirve como rango máximo.
     * @return n - devuelve el número introducido por el usuario que respete el rango.
     */
    public static int filtroLimitesInt(int lInf, int lSup)
    {
        int n;
        do
        {
            n = solicitudInt();
        }while(limiteInferiorInt(n, lInf) || limiteSuperiorInt(n, lSup));
        return n;
    }

    /**
     * Método que permite ingresar al usuario enteros, controlando que no se  introcuzcan carácteres.
     * @return n - devuelve el entero introducido por el usuario.
     */
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

    public static double solicitudDouble()
    {
        double n = 0;
        boolean fallo;

        do
        {
            fallo = false;
            try
            {
                n = key.nextDouble();
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

    /**
     * Solicitar al usuario introducir un String de números con un separador determinado para devolverlo
     * como un array de enteros.
     * @param tam - Tamaño de la cadena.
     * @param sep - Separador.
     * @return vI - Vector de enteros.
     */
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

    /**
     * Solicitar enteros al usuario validando que sea positivo.
     * @return n - Número validado que sea positivo.
     */
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

    /**
     * Solicitar al usuario que introduzca un carácter.
     * @return c - Carácter introducido.
     */
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

    /**
     * Solicitar al usuario introducir un carácter validando que esté presente en la lista de
     * carácteres permitidos.
     * @param permitidos - Array de carácteres con todos los que están permitidos introducir.
     * @return letra - Carácter validado.
     */
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

    /**
     * Se solicita al usuario introducir s,S,n ó N. Hace referencia a las palabras Sí y No y devolverá true o false respectivamente.
     * @return True si es ha introducido s ó S, y false en caso de n ó N.
     */
    public static boolean solicitarSNChar()
    {
        final char[] SI_NO = {'s', 'n', 'S', 'N'};

        switch(filtroChar(SI_NO))
        {
            case 's':
            case 'S':
                return true;
            default:
                return false;
        }
    }

    /**
     * Solicitar String al usuario, validando que como mínimo contenga un carácter.
     * @return s - String validado.
     */
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

    /**
     * Separar en carácteres un String introducido al usuario.
     * @return frase - Array de carácteres con cada carácter en una posición de la cadena.
     */
    public static char[] separarLetrasString()
    {
        char[] frase = solicitarString().toCharArray();
        return frase.clone();
    }

    /**
     * Limpiar la consola. No funciona con la consola integrada en IntelliJ.
     * @throws IOException
     * @throws InterruptedException
     */
    public static void limpiarConsola() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    /**
     * Devolver el número de cifras de un entero introducido.
     * @param n - Entero al que contar las cifras.
     * @return
     */
    public static int digitos(int n)
    {
        return String.valueOf(n).length();
    }
}
