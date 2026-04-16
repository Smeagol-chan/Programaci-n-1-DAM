package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatosPersonas
{
    private static ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    public static void insertarPersona(Persona persona)
    {
        try
        {
            listaPersonas.add(persona);
        }
        catch(NumberFormatException e){}
    }

    public static ObservableList<Persona> getListaPersonas()
    {
        return listaPersonas;
    }
}
