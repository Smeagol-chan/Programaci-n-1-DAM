package org.example.ejercicios;

import java.io.Serializable;

public class Empleado implements Serializable
{
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario)
    {
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public String toString()
    {
        return "Nombre: "+ nombre +
                "\nSalario: "+ salario +"€";
    }
}
