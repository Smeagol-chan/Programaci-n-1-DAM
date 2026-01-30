package org.example.partido_tenis;

import org.example.FuncionesComunes;

public class Set
{
    private static final int PUNTUACION_MINIMA = 0;
    private static final int PUNTUACION_MAXIMA = 7;
    private static final int PUNTUACION_VICTORIA = 6;

    private int puntosJ1;
    private int puntosJ2;

    public Set()
    {
        anyadirPuntuacion();
    }

    private void anyadirPuntuacion()
    {
        int puntosJ1, puntosJ2;
        do
        {
            System.out.print("Introduce la puntuación del primer y segundo jugador: ");
            puntosJ1 = FuncionesComunes.filtroLimitesInt(PUNTUACION_MINIMA, PUNTUACION_MAXIMA);
            puntosJ2 = FuncionesComunes.filtroLimitesInt(PUNTUACION_MINIMA, PUNTUACION_MAXIMA);

        }while(puntuacionInvalida(puntosJ1, puntosJ2));
        setPuntosJ1(puntosJ1);
        setPuntosJ2(puntosJ2);
    }

    private boolean puntuacionInvalida(int puntosJ1, int puntosJ2)
    {
        if(puntosJ2 >= PUNTUACION_VICTORIA || puntosJ1 >= PUNTUACION_VICTORIA)
        {
            switch(puntosJ1)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                    if(puntosJ2 == PUNTUACION_VICTORIA) return false;
                    break;
                case 5:
                    if(puntosJ2 == PUNTUACION_MAXIMA) return false;
                    break;
                case 6:
                    if(puntosJ2 == PUNTUACION_MAXIMA || puntosJ2 < PUNTUACION_VICTORIA-1) return false;
                    break;
                case 7:
                    if(puntosJ2 == PUNTUACION_VICTORIA || puntosJ2 == PUNTUACION_VICTORIA-1) return false;
                    break;
            }
        }
        return true;
    }

    public int getPuntosJ1() {
        return puntosJ1;
    }

    private void setPuntosJ1(int puntosJ1) {
        this.puntosJ1 = puntosJ1;
    }

    public int getPuntosJ2() {
        return puntosJ2;
    }

    private void setPuntosJ2(int puntosJ2) {
        this.puntosJ2 = puntosJ2;
    }

    @Override
    public String toString() {
        return "Set{" +
                "puntosJ1=" + puntosJ1 +
                ", puntosJ2=" + puntosJ2 +
                '}';
    }
}
