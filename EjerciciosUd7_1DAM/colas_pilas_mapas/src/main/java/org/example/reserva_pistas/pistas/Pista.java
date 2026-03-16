package org.example.reserva_pistas.pistas;

import org.example.reserva_pistas.enums.TipoTechado;

import java.util.Objects;

public abstract class Pista
{
    private static int totalPistas = 0;

    protected TipoTechado techado;
    protected int id;

    public Pista(TipoTechado tipo)
    {
        this.techado = tipo;
        setId();
    }

    public TipoTechado getTechado() {
        return techado;
    }

    public void setTechado(TipoTechado techado) {
        this.techado = techado;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        id = ++totalPistas;
    }

    @Override
    public abstract String toString();
}
