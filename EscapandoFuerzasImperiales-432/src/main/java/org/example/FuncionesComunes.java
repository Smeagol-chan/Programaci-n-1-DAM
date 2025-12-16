package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase almacena funciones que uso con regularidad. En este caso, solo están presentes las empleadas en EscapandoFuerzasImperiales.java
 * @author Eric Ramos Pastor
 * @version 1.0 (15/12/2025)
 */
public class FuncionesComunes
{
    public static Scanner key = new Scanner(System.in);

    /**
     * Método que comprueba si el entero es negativo o no.
     * @param n - entero sobre el que realizar la comprobación.
     * @return true/false - devolverá true si el número es menor estricto a 0 y false si no.
     */
    public static boolean negativoInt(int n)
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
}
