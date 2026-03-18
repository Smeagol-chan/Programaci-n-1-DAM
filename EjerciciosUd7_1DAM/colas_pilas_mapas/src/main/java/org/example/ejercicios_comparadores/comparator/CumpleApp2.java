package org.example.ejercicios_comparadores.comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CumpleApp2
{
    static void main()
    {
        List<Invitado2> listaInvitados = new ArrayList<>();
        listaInvitados.add(new Invitado2(25, "Eric"));
        listaInvitados.add(new Invitado2(12, "Álvaro"));
        listaInvitados.add(new Invitado2(53, "Carla"));

        Collections.sort(listaInvitados, new OrdenarPorEdadNombreHora());

        System.out.println(listaInvitados);
    }
}
