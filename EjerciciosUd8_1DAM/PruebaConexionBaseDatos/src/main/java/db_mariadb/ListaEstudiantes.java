package db_mariadb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaEstudiantes
{
    private static ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    public static void insertarEstudiante(Estudiante estudiante)
    {
        listaEstudiantes.add(estudiante);
    }

    public static void eliminarEstudiante(Estudiante estudiante)
    {
        listaEstudiantes.remove(estudiante);
    }

    public static ObservableList<Estudiante> getListaEstudiantes()
    {
        return listaEstudiantes;
    }
}