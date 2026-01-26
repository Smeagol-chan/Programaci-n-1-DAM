package org.example.prestamo_estudiante_libro;

public class Prestamo extends Estudiante
{
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo (Estudiante estudiante, Libro libro)
    {
        this.estudiante = estudiante;
        this.libro = libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void prestar(Estudiante estudiante)
    {
        if(libro.getDisponible() && estudiante.getLibro() == null)
        {
            System.out.println("El libro ha sido prestado con éxito.");
            libro.deactivarDisponibilidad();
            estudiante.setLibro(libro);
        }
        else if(libro.getDisponible() && estudiante.getLibro() != null)
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

    }
}