package org.example.ejercicios_lambdas;

@FunctionalInterface
public interface VerificadorVoto
{
    boolean puedeVotar(String nombre, int edad);
}
