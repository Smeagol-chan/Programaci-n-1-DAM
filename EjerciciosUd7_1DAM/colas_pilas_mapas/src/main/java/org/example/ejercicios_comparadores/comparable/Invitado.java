package org.example.ejercicios_comparadores.comparable;

import java.time.LocalTime;

public class Invitado implements Comparable<Invitado>
{
    private LocalTime hora;
    private Integer edad;
    private String nombre;

    public Invitado(int edad, String nombre)
    {
        hora = LocalTime.now();
        this.edad = edad;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Invitado invitado)
    {
        int comparable = edad.compareTo(invitado.getEdad());
        if(comparable != 0) return comparable;

        comparable = nombre.compareTo(invitado.getNombre());
        if(comparable != 0) return comparable;

        return hora.compareTo(invitado.getHora());
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