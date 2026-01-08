package org.example.recursividad;

public class Ej1
{
    public static int digitos(int n)
    {
        int cont = 0;
        if(n != 0) cont = digitos(n%10);
        cont++;
        return cont;
    }
}
