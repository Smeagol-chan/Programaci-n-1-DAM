package org.example.ejercicios;

import java.io.Serializable;

public class Persona implements Serializable
{
    private String nombre;
    private int edad;
    private transient String provincia;

    public Persona(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, String provincia)
    {
        this(nombre, edad);
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        return nombre +" de "+ edad +" años.";
    }
}
