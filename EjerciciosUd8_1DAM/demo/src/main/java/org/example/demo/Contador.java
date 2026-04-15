package org.example.demo;

public class Contador
{
    private int numero;

    public Contador()
    {
        numero = 0;
    }

    public void contar()
    {
        ++numero;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
