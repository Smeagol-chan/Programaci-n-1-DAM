package org.example.biblioteca;

import java.awt.desktop.SystemEventListener;

public class EstudianteApp
{
    static void main() {
        Estudiante jorge = new Estudiante("jorge", "1DAM", "jorge@gmail.com");
        Estudiante raul = new Estudiante("raúl");
        Estudiante eric = new Estudiante("Eric", "1DAM", "erirampas@alu.edu.gva.es");

        System.out.println(jorge);
        System.out.println(raul);
        System.out.println("Hay "+ Estudiante.obtenerTotalEstudiantes() +" estudiantes.");

        System.out.println("Email de "+ jorge.getNombre() +" es "
                + (Estudiante.validarCorreo(jorge.getEmail()) ? "correcto" : "erróneo") +".");

        System.out.println("Email de "+ eric.getNombre() +" es "
                + (Estudiante.validarCorreo(eric.getEmail()) ? "correcto" : "erróneo") +".");
        System.out.println("\n");

        Editorial nova = new Editorial("Nova", "España");
        Libro tf = new Libro("Trilogía Fundación", "Isaac Asimov", nova);
        tf.prestar(eric);
        System.out.println(tf);
        tf.devolver();
        System.out.println(tf);

        SystemEventListener.
    }
}