package org.example.inmobiliaria;

import org.example.biblioteca.Prestamo;

import java.awt.desktop.AppReopenedEvent;

public class Propietario
{
    private String nombre;
    private int edad;

    public Propietario(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
