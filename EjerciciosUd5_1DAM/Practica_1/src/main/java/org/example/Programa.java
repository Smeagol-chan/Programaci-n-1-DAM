package org.example;

import java.util.ArrayList;

public class Programa
{
    private static final int DEFAULT_TEMPORADAS = 0;
    private static final String CARGO_DIRECTOR = "director";

    private String nombre;
    private Cadena cadena;
    private int temporadas;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Invitado> listaInvitados;
    private Empleado director;

    public Programa(String nombre, Cadena cadena, Empleado director)
    {
        this.nombre = nombre;
        this.cadena = cadena;
        temporadas = DEFAULT_TEMPORADAS;
        setDirector();
        listaEmpleados = new ArrayList<>();
        listaInvitados = new ArrayList<>();
    }

    public void crearEmpelado()
    {
        System.out.print("Introduzca el nombre del empleado: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Introduzca el cargo: ");
        String cargo = FuncionesComunes.solicitarString();
        if(cargo.equals(CARGO_DIRECTOR))
        {
            System.out.println("Ya existe un director. Cancelando creación de empleado...");
        }
        else
        {
            Empleado empleado = new Empleado(nombre, cargo, director, listaEmpleados.size()+1);
            listaEmpleados.add(empleado);
        }
    }

    public void anyadirTemporada()
    {
        temporadas++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cadena getCadena() {
        return cadena;
    }

    public void setCadena(Cadena cadena) {
        this.cadena = cadena;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Invitado> getListaInvitados() {
        return listaInvitados;
    }

    public Empleado getDirector() {
        return director;
    }

    private void setDirector() {
        System.out.print("Introduzca el nombre del director: ");
        Empleado director = new Empleado(FuncionesComunes.solicitarString()
                                        , CARGO_DIRECTOR
                                        , null
                                        , listaEmpleados.size()+1);

        listaEmpleados.add(director);
        this.director = director;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "nombre='" + nombre + '\'' +
                ", cadena=" + cadena.getNombre() +
                ", temporadas=" + temporadas +
                ", listaEmpleados=" + listaEmpleados +
                ", listaInvitados=" + listaInvitados +
                ", director=" + director +
                '}';
    }
}
