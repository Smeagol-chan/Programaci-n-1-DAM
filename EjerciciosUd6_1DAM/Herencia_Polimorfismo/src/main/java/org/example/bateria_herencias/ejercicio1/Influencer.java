package org.example.bateria_herencias.ejercicio1;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Influencer extends Usuario
{
    private ArrayList<String> colaboraciones;

    public Influencer(String nombre, int edad, String nombreUsuario, int seguidores)
    {
        super(nombre, edad, nombreUsuario, seguidores);
    }

    public void anyadirColaboracion(String colaboracion)
    {
        colaboraciones.add(colaboracion);
    }

    public void eliminarColaboracion(String colaboracion)
    {
        colaboraciones.remove(colaboracion);
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Colaboraciones: ");
        for(String colaboracion : colaboraciones)
            System.out.println("> "+ colaboracion);
    }
}
