package org.example.reserva_pistas.usuarios;

public class Usuario
{
    private static int totalUsuarios = 0;

    private String nombre;
    private int id;

    public Usuario(String nombre)
    {
        this.nombre = nombre;
        setId();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        id = ++totalUsuarios;
    }

    @Override
    public String toString() {
        return "Nombre: "+ getNombre() +
                ", Id: "+ getId();
    }
}
