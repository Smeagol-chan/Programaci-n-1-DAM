package org.example.enum_intro.ej1;

public enum Semaforo
{
    ROJO, VERDE, AMARILLO;

    public Semaforo siguiente()
    {
        switch (ordinal())
        {
            case 0:
                return VERDE;
            case 1:
                return AMARILLO;
            default:
                return ROJO;
        }
    }
}
