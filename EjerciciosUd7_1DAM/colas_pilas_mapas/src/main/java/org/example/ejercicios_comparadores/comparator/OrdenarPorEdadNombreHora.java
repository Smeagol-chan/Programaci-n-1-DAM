package org.example.ejercicios_comparadores.comparator;

import java.util.Comparator;

public class OrdenarPorEdadNombreHora implements Comparator<Invitado2>
{
    @Override
    public int compare(Invitado2 o1, Invitado2 o2)
    {
        int comparar = o1.getEdad().compareTo(o2.getEdad());
        if(comparar != 0) return comparar;

        return o1.getNombre().compareTo(o2.getNombre());
    }
}
