package org.example.ejercicios;

import java.io.Serializable;

public class Mascota implements Serializable
{
    private int edad;
    private String especie;

    public Mascota(int edad, String especie)
    {
        this.edad = edad;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return especie +" de "+ edad +" años.";
    }
}
