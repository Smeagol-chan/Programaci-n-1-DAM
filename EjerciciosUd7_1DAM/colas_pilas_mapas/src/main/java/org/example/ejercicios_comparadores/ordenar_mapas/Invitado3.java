package org.example.ejercicios_comparadores.ordenar_mapas;

import java.time.LocalTime;

public class Invitado3
{
    private LocalTime hora;
    private Integer edad;
    private String nombre;

    public Invitado3(int edad, String nombre)
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