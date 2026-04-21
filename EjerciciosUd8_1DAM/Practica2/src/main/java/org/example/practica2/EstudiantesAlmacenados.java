package org.example.practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

public class EstudiantesAlmacenados
{
    private static ObservableSet<Estudiante> listadoEstudiantes = FXCollections.observableSet();

    public static void insertStudent(Estudiante estudiante)
    {
        if(listadoEstudiantes.contains(estudiante)) throw new RuntimeException("El estudiante ya está en la lista.");
        else listadoEstudiantes.add(estudiante);
    }

    public static void deleteStudent(Estudiante estudiante)
    {
        if(!listadoEstudiantes.contains(estudiante)) throw new RuntimeException("El estudiante no está en la lista.");
        else listadoEstudiantes.remove(estudiante);
    }

    public static void modifyStudent(Estudiante estudiante)
    {
    }
}
