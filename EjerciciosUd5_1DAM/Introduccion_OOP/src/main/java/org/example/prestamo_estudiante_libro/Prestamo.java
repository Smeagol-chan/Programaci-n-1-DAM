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

    public void prestar()
    {
        if(disponible && estudianteV1.getLibro() == null)
        {
            System.out.println("El libro ha sido prestado con éxito.");
            setDisponible(false);
            cantidadLibrosDisponibles--;
            estudianteV1Prestado = estudianteV1;
            estudianteV1Prestado.setLibro(this);
        }
        else if(disponible && estudianteV1.getLibro() != null)
        {
            System.out.println(estudianteV1.getNombre() +" ya tiene un libro en posesión. No puede recibir más.");
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