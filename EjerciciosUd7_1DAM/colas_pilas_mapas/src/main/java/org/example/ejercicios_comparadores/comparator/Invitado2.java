package org.example.ejercicios_comparadores.comparator;

import java.time.LocalTime;

public class Invitado2
{
    private LocalTime hora;
    private Integer edad;
    private String nombre;

    public Invitado2(int edad, String nombre)
    {
        hora = LocalTime.now();
        this.edad = edad;
        this.nombre = nombre;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Invitado{" +
                "hora=" + hora +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}