package org.example.recursividad;

public class EjerciciosRecursivos
{
    public static int digitos(int n)
    {
        int cont = 0;
        if(n > 9) cont = digitos(n/10);
        cont++;
        return cont;
    }

    public static int potencias(int base, int exp)
    {
        int res = 1;
        if(exp > 1) res = potencias(base, exp-1);
        return res * base;
    }

    public static void invertirNum(int num)
    {
        System.out.print(num%10);
        if(num > 9) invertirNum(num/10);
    }

    public static void invertirFrase(char[] frase, int limit, int pos)
    {
        if(pos < limit) invertirFrase(frase, limit,pos+1);
        System.out.print(frase[pos]);
    }

    public static boolean comprobarBinario(int num)
    {
        if(num%10 == 0 || num%10 == 1)
        {
            if(num > 9)
            {
                return comprobarBinario(num/10);
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public static String convertirBinario(int num)
    {
        String binario = "";

        if(num > 2) binario = convertirBinario(num/2);
        else binario += num/2;

        binario += String.valueOf(num%2);
        return binario;
    }

    public static boolean fraseOrdenada(String frase, int pos)
    {
        if(frase.length()-2 > pos)
        {
            if(frase.charAt(pos) <= frase.charAt(pos+1)) return fraseOrdenada(frase, pos+1);
            else return false;
        }
        else
        {
            return true;
        }
    }

    private static String procesoSuma(int num)
    {
        String suma = String.valueOf(num);
        if(num > 1) suma = procesoSuma(num-1) + "+" + suma;
        return suma;
    }

    private static int resultadoSuma(int num)
    {
        if(num > 1) num += resultadoSuma(num-1);
        return num;
    }

    public static String calculoSuma(int num)
    {
        return procesoSuma(num) + " = " + resultadoSuma(num);
    }
}
