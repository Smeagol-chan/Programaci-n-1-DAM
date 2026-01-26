package org.example.prestamo_estudiante_libro;

public class Prestamo
{
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo (Estudiante estudiante, Libro libro)
    {
        this.estudiante = estudiante;
        this.libro = libro;
    }
}