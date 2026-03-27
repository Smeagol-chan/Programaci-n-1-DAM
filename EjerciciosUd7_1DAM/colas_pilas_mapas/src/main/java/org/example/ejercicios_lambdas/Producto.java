package org.example.ejercicios_lambdas;

public class Producto
{
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }
}
