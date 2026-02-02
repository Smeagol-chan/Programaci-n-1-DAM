package org.example;
import java.util.ArrayList;

public class Cadena
{
    private String nombre;
    private ArrayList<Programa> listaProgramas;

    public Cadena(String nombre)
    {
        this.nombre = nombre;
        listaProgramas = new ArrayList<>();
    }

    public void anyadirPrograma(Programa programa)
    {
        listaProgramas.add(programa);
    }

    public void eliminarPrograma(Programa programa)
    {
        listaProgramas.remove(programa);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }

    @Override
    public String toString() {
        return "Cadena{" +
                "nombre='" + nombre + '\'' +
                ", listaProgramas=" + listaProgramas +
                '}';
    }
}
