package org.example.ejercicios_comparadores.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CumpleApp
{
    static void main()
    {
        List<Invitado> listaInvitados = new ArrayList<>();
        listaInvitados.add(new Invitado(25, "Eric"));
        listaInvitados.add(new Invitado(12, "Álvaro"));
        listaInvitados.add(new Invitado(53, "Carla"));

        Collections.sort(listaInvitados);

        System.out.println(listaInvitados);
    }
}
