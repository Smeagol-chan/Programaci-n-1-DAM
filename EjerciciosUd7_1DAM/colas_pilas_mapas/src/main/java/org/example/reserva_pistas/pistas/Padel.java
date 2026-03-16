package org.example.reserva_pistas.pistas;

import org.example.reserva_pistas.enums.TipoParedes;
import org.example.reserva_pistas.enums.TipoTechado;

public class Padel extends Pista
{
    private TipoParedes paredes;

    public Padel(TipoTechado techado, TipoParedes paredes)
    {
        super(techado);
        this.paredes = paredes;
    }

    public TipoParedes getParedes() {
        return paredes;
    }

    public void setParedes(TipoParedes paredes) {
        this.paredes = paredes;
    }

    @Override
    public String toString()
    {
        return "Pista: Pádel"+
                ", Id: "+ id +
                ", Tipo de techado: "+ techado +
                ", Tipo de paredes: "+ paredes;
    }
}