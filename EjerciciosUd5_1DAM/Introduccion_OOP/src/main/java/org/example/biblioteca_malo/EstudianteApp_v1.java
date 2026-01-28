package org.example.biblioteca_malo;

import java.awt.desktop.SystemEventListener;

public class EstudianteApp_v1
{
    static void main() {
        Estudiante_v1 jorge = new Estudiante_v1("jorge", "1DAM", "jorge@gmail.com");
        Estudiante_v1 raul = new Estudiante_v1("raúl");
        Estudiante_v1 eric = new Estudiante_v1("Eric", "1DAM", "erirampas@alu.edu.gva.es");

        System.out.println(jorge);
        System.out.println(raul);
        System.out.println("Hay "+ Estudiante_v1.obtenerTotalEstudiantes() +" estudiantes.");

        System.out.println("Email de "+ jorge.getNombre() +" es "
                + (Estudiante_v1.validarCorreo(jorge.getEmail()) ? "correcto" : "erróneo") +".");

        System.out.println("Email de "+ eric.getNombre() +" es "
                + (Estudiante_v1.validarCorreo(eric.getEmail()) ? "correcto" : "erróneo") +".");
        System.out.println("\n");

        Editorial_v1 nova = new Editorial_v1("Nova", "España");
        Libro_v1 tf = new Libro_v1("Trilogía Fundación", "Isaac Asimov", nova);
        tf.prestar(eric);
        System.out.println(tf);
        tf.devolver();
        System.out.println(tf);

//        SystemEventListener.
    }
}