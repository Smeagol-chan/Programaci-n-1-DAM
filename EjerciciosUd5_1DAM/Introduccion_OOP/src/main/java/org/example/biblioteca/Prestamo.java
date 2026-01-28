package org.example.biblioteca;

import java.util.ArrayList;

public class Prestamo
{
    private Estudiante estudiante;
    private Libro libro;
    private ArrayList<Libro> listaLibro;

    public Prestamo (Estudiante estudiante)
    {
        this.estudiante = estudiante;
        listaLibro = new ArrayList<>();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public ArrayList<Libro> getListaLibro() {
        return listaLibro;
    }

    private void agregarLibro(Libro libro)
    {
        listaLibro.add(libro);
    }

    public void prestar(Estudiante estudiante, Libro libro)
    {
        if(libro.getDisponible() && !listaLibro.contains(libro))
        {
            System.out.println("El libro ha sido prestado con éxito.");
            libro.deactivarDisponibilidad();
            agregarLibro(libro);
        }
        else if(libro.getDisponible() && listaLibro.contains(libro))
        {
            System.out.println(estudiante.getNombre() +" ya tiene un libro en posesión. No puede recibir más.");
        }
        else
        {
            System.out.println("El libro ya ha sido prestado con anterioridad.");
        }
    }

    public void devolver()
    {
        if(!libro.getDisponible())
        {
            System.out.println("El libro ha sido devuelto con éxito.");
            libro.activarDisponobilidad();
            estudiante.setLibro(null);
        }
        else System.out.println("El libro ya ha sido devuelto con anterioridad.");
    }
}