package org.example.reserva_pistas;
import org.example.FuncionesComunes;
import org.example.reserva_pistas.excepciones.UsuarioOrPistaDuplicatedException;
import org.example.reserva_pistas.pistas.*;
import org.example.reserva_pistas.usuarios.Usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class AppReserva
{
    private static HashMap<Usuario, HashSet<Reserva>> mapaUsuarioListadoReservas = new HashMap<>();

    static void eliminarReservasPorTipoPista(HashSet<Reserva> listaReservas)
    {
        System.out.println("¿Qué tipo de pista quieres eliminar?");
        System.out.println("- Tenis");
        System.out.println("- Pádel");
        System.out.println("- Cancelar");
        System.out.print("> ");
        Iterator<Reserva> iterator = listaReservas.iterator();
        String tipoPista = FuncionesComunes.solicitarString().toLowerCase();

        while(iterator.hasNext())
        {
            Reserva reserva = iterator.next();
            if(reserva.getPista() instanceof Tenis && tipoPista.equals("tenis"))
                iterator.remove();
            else if(reserva.getPista() instanceof Padel && tipoPista.equals("padel"))
                    iterator.remove();
        }
    }

    static HashSet<Reserva> reservasDelUsuario(Usuario usuario)
    {
        return mapaUsuarioListadoReservas.get(usuario);
    }

    static void anyadirReservaAlUsuario(Usuario usuario, Pista pista)
    {
        HashSet<Reserva> listaReservas = reservasDelUsuario(usuario);
        Reserva reserva = new Reserva(usuario, pista);
        if(listaReservas.contains(reserva)) throw new UsuarioOrPistaDuplicatedException();
        else
        {
            listaReservas.add(reserva);
            mapaUsuarioListadoReservas.put(usuario, listaReservas);
        }
    }
}
