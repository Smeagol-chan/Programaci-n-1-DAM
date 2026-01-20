package org.example.app;

import org.example.objetos.Estudiante;

public class EstudianteApp
{
    static void main() {
        Estudiante jorge = new Estudiante("jorge", "1DAM", "jorge@gmail.com");
        Estudiante raul = new Estudiante("raúl");

        System.out.println(jorge);
        System.out.println(raul);
    }
}
