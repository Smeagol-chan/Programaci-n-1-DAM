package org.example.enum_intro.ej2;

public enum Dificultad
{
    FACIL(2),
    MEDIO(4),
    DIFICIL(8),
    EXPERTO(10);

    private int multiplicador;

    Dificultad(int multiplicador)
    {
        this.multiplicador = multiplicador;
    }

    public int getMultiplicador() {
        return multiplicador;
    }
}
