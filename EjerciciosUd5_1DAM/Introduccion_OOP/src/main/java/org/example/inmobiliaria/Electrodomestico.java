package org.example.inmobiliaria;

public class Electrodomestico
{
    private String nombre;
    private double consumo;

    public Electrodomestico(String nombre, double consumo)
    {
        this.nombre = nombre;
        this.consumo = consumo;
    }

    public Electrodomestico(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "nombre='" + nombre + '\'' +
                ", consumo=" + consumo +
                '}';
    }
}
