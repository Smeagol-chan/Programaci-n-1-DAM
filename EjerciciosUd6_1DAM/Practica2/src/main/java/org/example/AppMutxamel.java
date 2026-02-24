package org.example;

import org.example.muxtamel_fc.MutxamelFC;
import org.example.muxtamel_fc.enums.Equipos;
import org.example.muxtamel_fc.enums.Posiciones;
import org.example.muxtamel_fc.interfaces.AccionesDeportivas;
import org.example.muxtamel_fc.miembros.Acompanante;
import org.example.muxtamel_fc.miembros.Entrenador;
import org.example.muxtamel_fc.miembros.Jugador;
import org.example.muxtamel_fc.miembros.Masajista;

import java.util.ArrayList;

public class AppMutxamel
{
    static void main()
    {
        Jugador j1 = new Jugador("Paco", 24, Equipos.SENIOR, 8, Posiciones.DEFENSA);
        Jugador j2 = new Jugador("Gregorio", 28, Equipos.SENIOR, 7, Posiciones.CENTROCAMPISTA);
        Jugador j3 = new Jugador("Pascual", 20, Equipos.SENIOR, 6, Posiciones.PORTERO);

        Entrenador entrenador = new Entrenador("Cristina", 42, Equipos.SENIOR, "4-5-7");

        Masajista masaj1 = new Masajista("Pere", 32, "Masajista pro", 11);
        Masajista masaj2 = new Masajista("Luisa", 22, "Masajista fesional", 2);

        Acompanante acom1 = new Acompanante("Mariano", 65, j3, "padre");
        Acompanante acom2 = new Acompanante("Eugenio", 63, j3, "padre");
        Acompanante acom3 = new Acompanante("Paula", 28, j1, "pareja");
        Acompanante acom4 = new Acompanante("Juan", 4, j2, "hijo");

        ArrayList<MutxamelFC> listaMiembros = new ArrayList<>();
        listaMiembros.add(j1);
        listaMiembros.add(j2);
        listaMiembros.add(j3);
        listaMiembros.add(entrenador);
        listaMiembros.add(masaj1);
        listaMiembros.add(masaj2);
        listaMiembros.add(acom1);
        listaMiembros.add(acom2);
        listaMiembros.add(acom3);
        listaMiembros.add(acom4);

        for(MutxamelFC miembro : listaMiembros)
            miembro.centrarse();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador  || miembro instanceof Entrenador)
                ((AccionesDeportivas) miembro).entrenar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Masajista)
                ((Masajista) miembro).darMasaje(j2);

        for(MutxamelFC miembro : listaMiembros)
            miembro.viajar("Madrid");

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Entrenador)
                ((Entrenador) miembro).planificarEntrenamiento();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador  || miembro instanceof Entrenador)
                ((AccionesDeportivas) miembro).entrenar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).descansar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).calentar();

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador  || miembro instanceof Entrenador)
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

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Masajista)
            {
                ((Masajista) miembro).darMasaje(j1);
                ((Masajista) miembro).darMasaje(j2);
                ((Masajista) miembro).darMasaje(j3);
            }

        for(MutxamelFC miembro : listaMiembros)
            miembro.viajar("Mutxamel");

        for(MutxamelFC miembro : listaMiembros)
            if(miembro instanceof Jugador)
                ((Jugador) miembro).descansar();
    }
}
