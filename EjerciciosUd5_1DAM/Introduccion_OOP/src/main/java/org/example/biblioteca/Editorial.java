package org.example.biblioteca;

import java.util.ArrayList;

public class Editorial
{
    private String nombre;
    private String pais;
    private ArrayList<Libro> librosPublicados;

    public Editorial(String nombre, String pais)
    {
        this.nombre = nombre;
        this.pais = pais;
        librosPublicados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Libro> getLibrosPublicados() {
        return librosPublicados;
    }

    public void setLibrosPublicados(ArrayList<Libro> librosPublicados) {
        this.librosPublicados = librosPublicados;
    }

    public void publicarLibro(Libro libro)
    {
        librosPublicados.add(libro);
    }

    public void descatalogarLibro(Libro libro)
    {
        librosPublicados.remove(libro);
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
