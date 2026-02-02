package org.example;

import java.util.Arrays;

public class Empleado
{
    private static final String CABECERA_ID = "EP";
    private static final int MAXIMO_EMPLEADOS = 999;
    private static final String DEFAULT_CARGO = "pte";
    private static final String[] CARGOS_VALIDOS = {"director", "técnico", "presentador", "colaborador"};

    private String nombre;
    private String id;
    private String cargo;
    private Empleado director;

    public Empleado(String nombre, String cargo, Empleado director, int numeroEmpleado)
    {
        if(numeroEmpleado <= MAXIMO_EMPLEADOS)
        {
            this.nombre = nombre;
            setId(generarId(numeroEmpleado));
            setCargo(cargo);
            this.director = director;
        }
        else
        {
            System.out.println("Número máximo de empleados alcanzado.");
        }
    }

    private String generarId(int numeroEmpleado)
    {
        String id = String.valueOf(numeroEmpleado);

        for(int i = id.length(); i < String.valueOf(MAXIMO_EMPLEADOS).length(); i++)
            id = "0" + id;

        return CABECERA_ID + id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    private void setId(String id)
    {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    private void setCargo(String cargo) {
        this.cargo = Arrays.asList(CARGOS_VALIDOS).contains(cargo) ? cargo : DEFAULT_CARGO;
    }

    public Empleado getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", cargo='" + cargo + '\'' +
                ", director=" + director.getNombre() +
                '}';
    }
}
