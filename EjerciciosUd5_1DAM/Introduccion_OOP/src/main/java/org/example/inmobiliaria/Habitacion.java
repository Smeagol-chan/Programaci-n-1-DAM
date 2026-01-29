package org.example.inmobiliaria;

import org.example.FuncionesComunes;

import java.util.ArrayList;

public class Habitacion
{
    private String nombre;
    private double metros;
    private ArrayList<Electrodomestico> listaElectrodomesticos;

    public Habitacion (String nombre, double metros)
    {
        this.nombre = nombre;
        this.metros = metros;
        listaElectrodomesticos = new ArrayList<>();
    }

    public Habitacion()
    {
        this(null, 0);
    }

    public void crearElectrodomestico(String nombre, double consumo)
    {
        for(Electrodomestico electrodomestico : listaElectrodomesticos)
        {
            if(electrodomestico.getNombre().equals(nombre))
            {
                System.out.println("El electrodoméstico ya está presente.");
                return;
            }
        }
        listaElectrodomesticos.add(new Electrodomestico(nombre, consumo));
        System.out.println("Electrodoméstico "+ nombre +" creado.");
    }

    public void eliminarElectrodomestico(String nombre)
    {
        for(Electrodomestico electrodomestico : listaElectrodomesticos)
        {
            if(electrodomestico.getNombre().equals(nombre))
            {
                System.out.println("Electrodoméstico eliminado.");
                listaElectrodomesticos.remove(electrodomestico);
                return;
            }
        }
        System.out.println("El electrodoméstico no se encuentra en la habitación.");
    }

    public void mostrarElectrodomesticos()
    {
        System.out.println("Electrodomésticos en "+ nombre +":");
        for(Electrodomestico electrodomestico : listaElectrodomesticos)
        {
            System.out.println("- "+ electrodomestico.getNombre()
                    +" ("+ electrodomestico.getConsumo() +"kWh)");
        }
    }

    public double calcularConsumo()
    {
        double consumoTotal = 0;
        for(Electrodomestico electrodomestico : listaElectrodomesticos) consumoTotal += electrodomestico.getConsumo();
        return consumoTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "nombre='" + nombre + '\'' +
                ", metros=" + metros +
                '}';
    }
}
