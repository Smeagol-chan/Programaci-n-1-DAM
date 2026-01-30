package org.example.partido_tenis;

import java.util.ArrayList;

public class Partido
{
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Set> listaSet;

    public Partido(Jugador jugador1, Jugador jugador2)
    {
        asignarJugadores(jugador1, jugador2);
        listaSet = new ArrayList<>();
    }

    public void crearSet()
    {
        Set set = new Set();
        listaSet.add(set);
    }

    public void asignarJugadores(Jugador jugador1, Jugador jugador2)
    {
        setJugador1(jugador1, jugador2);
        setJugador2(jugador1, jugador2);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    private void setJugador1(Jugador jugador1, Jugador jugador2) {
        jugador1.setRival(jugador2);
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    private void setJugador2(Jugador jugador1, Jugador jugador2) {
        jugador2.setRival(jugador1);
        this.jugador2 = jugador2;
    }

    public ArrayList<Set> getListaSet() {
        return listaSet;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "jugador1=" + jugador1 +
                ", jugador2=" + jugador2 +
                ", listaSet=" + listaSet +
                '}';
    }
}
