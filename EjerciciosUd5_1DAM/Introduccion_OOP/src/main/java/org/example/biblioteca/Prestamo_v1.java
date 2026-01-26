package org.example.biblioteca;

import java.time.LocalDateTime;

public class Prestamo_v1
{
    private static final LocalDateTime DEF_FECHA = null;

    private Libro_v1 libroV1;
    private Estudiante_v1 estudianteV1;
    private LocalDateTime fecha;

    public Prestamo_v1(Libro_v1 libroV1, Estudiante_v1 estudianteV1)
    {
        this.libroV1 = libroV1;
        this.estudianteV1 = estudianteV1;
        fecha = LocalDateTime.now();
    }
}
