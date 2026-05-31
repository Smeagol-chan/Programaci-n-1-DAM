package org.example.practica4.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Videojuego
{
    private String nombre;
    private Plataforma plataforma;
    private double precio;
    private boolean disponible;
    private ArrayList<String> listaGeneros;

    public Videojuego(){}

    public Videojuego(String nombre, Plataforma plataforma, double precio, boolean disponible, List<String> listaGeneros)
    {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.listaGeneros = new ArrayList<>(listaGeneros);
    }

    public String getNombre() {
        return nombre;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public ArrayList<String> getListaGeneros() {
        return listaGeneros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Objects.equals(nombre, that.nombre) && plataforma == that.plataforma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, plataforma);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "nombre='" + nombre + '\'' +
                ", plataforma=" + plataforma +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", listaGeneros=" + listaGeneros +
                '}';
    }
}
