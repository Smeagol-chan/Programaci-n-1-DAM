package org.example.reserva_pistas.pistas;

import org.example.reserva_pistas.enums.TipoSuperficie;
import org.example.reserva_pistas.enums.TipoTechado;

public class Tenis extends Pista
{
    private TipoSuperficie superficie;

    public Tenis(TipoTechado techado, TipoSuperficie superficie)
    {
        super(techado);
        this.superficie = superficie;
    }

    public TipoSuperficie getSuperficie() {
        return superficie;
    }

    public void setSuperficie(TipoSuperficie superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString()
    {
        return "Pista: Tenis"+
                ", Id: "+ getId() +
                ", Tipo de techado: "+ getTechado() +
                ", Tipo de superficie: "+ getSuperficie();
    }
}
