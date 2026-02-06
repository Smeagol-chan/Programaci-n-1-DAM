package org.example;
import java.util.Arrays;

/**
 * Clase dependiente de Programa.
 * @author ericr
 * @version 1.0 (06/02/2026)
 */
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

    /**
     * Constructor de Empleado.
     * Valida que no hayan más de MAXIMO_EMPLEADOS.
     * Los parámetros id y cargo se inicializan invocando a setId y setCargo respectivamente.
     * @param nombre
     * @param cargo
     * @param director
     * @param numeroEmpleado
     */
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

    /**
     * Función invocada por el constructor para generar un id al empleado utilizando su posición en la lista de empleados del programa donde trabaja y la cabecera de CABECERA_ID.
     * Se convierten los enteros a String para ver la cantidad de cifras con .length().
     * @param numeroEmpleado - Entero con su posición en el ArrayList +1.
     * @return String con el id generado.
     */
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

    /**
     * Modificación de setCargo. Se valida que el cargo sea válido, volcando DEFAULT_CARGO de no serlo.
     * @param cargo - String con el cargo del empleado.
     */
    private void setCargo(String cargo) {
        this.cargo = Arrays.asList(CARGOS_VALIDOS).contains(cargo) ? cargo : DEFAULT_CARGO;
    }

    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", cargo='" + cargo + '\'' +
                ", director=" + (director == null ? "null" : director.getNombre()) +
                '}';
    }
}
