package org.example.muxtamel_fc;
import org.example.FuncionesComunes;
import org.example.muxtamel_fc.acciones.AccionesDeportivas;
import org.example.muxtamel_fc.miembros.*;

import java.util.ArrayList;

/**
 * Clase que activa las acciones de cada miembro del club.
 * Es el primer main que aparece en la práctica.
 */
public class AccionesMiembros
{
    public static void accionesMiembros()
    {
        ArrayList<MutxamelFC> listaMiembros = Mantenimiento.miembrosClub;
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador) listaJugadores.add((Jugador) miembro);

        for(MutxamelFC miembro : listaMiembros)
            miembro.centrarse();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador || miembro instanceof Entrenador)
                ((AccionesDeportivas) miembro).entrenar();

        if(listaJugadores.isEmpty()) System.out.println("No hay jugadores a los que masajear.");
        else
        {
            for(MutxamelFC miembro : listaMiembros)
                if(miembro instanceof Masajista)
                    ((Masajista) miembro).darMasaje(listaJugadores.get(FuncionesComunes.random.nextInt(listaJugadores.size())));
        }

        for(MutxamelFC miembro : listaMiembros)
            miembro.viajar("Madrid");

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Entrenador)
                ((Entrenador) miembro).planificarEntrenamiento();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador || miembro instanceof Entrenador)
                ((AccionesDeportivas) miembro).entrenar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).descansar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).calentar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador || miembro instanceof Entrenador)
                ((AccionesDeportivas) miembro).jugarPartido("Los malos");

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Acompanante)
                ((Acompanante) miembro).animarEquipo();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Entrenador)
                ((Entrenador) miembro).hacerCambios();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).marcarGol();

        for(MutxamelFC miembro : listaMiembros)
            miembro.celebrarGol();

        if(listaJugadores.isEmpty()) System.out.println("No hay jugadores a los que masajear.");
        else
        {
            for(MutxamelFC miembro : listaMiembros)
            {
                if(miembro instanceof Masajista)
                {
                    for(Jugador jugador : listaJugadores)
                        ((Masajista) miembro).darMasaje(jugador);
                }
            }
        }

        for(MutxamelFC miembro : listaMiembros)
            miembro.viajar("Mutxamel");

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).descansar();
    }
}
