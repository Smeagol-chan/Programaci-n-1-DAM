package org.example.biblioteca;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prestamo
{
    private static final LocalDateTime DEF_FECHA = null;

    private Libro libro;
    private Estudiante estudiante;
    private LocalDateTime fecha;

    public Prestamo(Libro libro, Estudiante estudiante)
    {
        this.libro = libro;
        this.estudiante = estudiante;
        fecha = LocalDateTime.now();
    }
}
