package org.example;
import java.util.ArrayList;

/**
 * Clase independiente.
 * @author ericr
 * @version 1.0 (06/02/2026)
 */
public class Programa
{
    private static final int DEFAULT_TEMPORADAS = 0;
    private static final int NUM_DIRECTOR = 1;
    private static final String CARGO_DIRECTOR = "director";

    private String nombre;
    private Cadena cadena;
    private int temporadas;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Invitado> listaInvitados;
    private Empleado director;

    /**
     * Constructor de Programa. Las temporadas se inicializan con su valor por defecto y director se añade invocando a setDirector().
     * @param nombre - String con el nombre del programa.
     * @param cadena - Cadena con la cadena a la que pertenece.
     */
    public Programa(String nombre, Cadena cadena)
    {
        this.nombre = nombre;
        this.cadena = cadena;
        temporadas = DEFAULT_TEMPORADAS;
        listaEmpleados = new ArrayList<>();
        listaInvitados = new ArrayList<>();
        setDirector();
    }

    /**
     * Procedimiento para mostrar a los invitado de una temporada particular.
     * @param temporada - Entero con la temporada a analizar.
     */
    public void invitadosTemporada(int temporada)
    {
        int cantidad = 0;
        System.out.println("Invitados de la temporada "+ temporada +" de "+ nombre +":");
        for(Invitado invitado : listaInvitados)
        {
            if(invitado.getTemporada() == temporada)
            {
                cantidad++;
                System.out.println(" > "+ invitado.getNombre() +", " + invitado.getProfesion());
            }
        }
        System.out.println("Total de invitados: "+ cantidad);
    }

    /**
     * Función para determinar la cantidad de veces que una persona ha sido invitada en un programa.
     * @param nombre - String con el nombre del invitado.
     * @return Entero con la cantidad de veces en el programa.
     */
    public int vecesInvitado(String nombre)
    {
        int cantidad = 0;
        for(Invitado invitado : listaInvitados)
            if(invitado.getNombre().contains(nombre)) cantidad++;

        return cantidad;
    }

    /**
     * Procedimiento para mostrar todas las apariciones de un invitado en el programa.
     * @param nombre - Invitado que mostrar.
     */
    public void rastrearInvitado(String nombre)
    {
        System.out.println(nombre +" ha sido invitado "+ vecesInvitado(nombre) +" veces:");

        for(Invitado invitado : listaInvitados)
            if(invitado.getNombre().contains(nombre))
                System.out.println(" > "+ invitado.getTemporada() +", " + invitado.getFecha_visita());

    }

    /**
     * Procedimiento para mostrar a todos los empleados del programa en orden de aparición en la lista.
     */
    public void mostrarEmpleadosListados()
    {
        System.out.println("  Empleados en "+ nombre +":");
        for (int i = 0; i < listaEmpleados.size(); i++)
            System.out.print("\t"+ (i+1) +". "+ listaEmpleados.get(i).getNombre() +", "+ listaEmpleados.get(i).getCargo());
    }

    /**
     * Función para seleccionar a un empleado particular de la lista.
     * @return Entero con la posición que el empleado ocupa en la lista.
     */
    private Empleado seleccionarEmpleado()
    {
        System.out.println("Seleccione un empleado de la lista:");
        mostrarEmpleadosListados();
        int numEmpleado = FuncionesComunes.filtroLimitesInt(1, listaEmpleados.size())-1;
        return listaEmpleados.get(numEmpleado-1);
    }

    /**
     * Procedimiento para cambiar el director de todos los empleados del programa.
     */
    private void cambiarDirectorEmpleados()
    {
        for(Empleado empleado : listaEmpleados)
        {
            if(!empleado.getCargo().contains(CARGO_DIRECTOR)) empleado.setDirector(director);
        }
    }

    /**
     * Procedimiento para eliminar un empleado que el usuario haya seleccionado.
     */
    public void eliminarEmpleado()
    {
        Empleado empleado = seleccionarEmpleado();
        if(empleado.getCargo().contains(CARGO_DIRECTOR))
        {
            System.out.println("El programa no puede estar sin director. Si quieres proceder, deberás introducir un nuevo director.");
            System.out.print("¿Quieres continuar? (s/n)");
            if(FuncionesComunes.solicitarSNChar())
            {
                listaEmpleados.remove(empleado);
                setDirector();
                cambiarDirectorEmpleados();
            }
            else System.out.println("Cancelando proceso.");
        }
        else listaEmpleados.remove(empleado);
    }

    /**
     * Procedimiento para mostrar a todos los invitados del programa en orden de aparición en la lista.
     */
    public void mostrarInvitadosListados()
    {
        System.out.println("  Invitados en "+ nombre +":");
        for (int i = 0; i < listaInvitados.size(); i++)
            System.out.println("\t"+ (i+1) +". "+ listaInvitados.get(i).getNombre() +", temporada "+ listaInvitados.get(i).getTemporada());
    }

    /**
     * Función para seleccionar a un invitado particular de la lista.
     * @return Entero con la posición que el invitado ocupa en la lista.
     */
    private Invitado seleccionarInvitado()
    {
        System.out.println("Seleccione un invitado de la lista:");
        mostrarInvitadosListados();
        int numInvitado = FuncionesComunes.filtroLimitesInt(1, listaInvitados.size())-1;
        return listaInvitados.get(numInvitado-1);
    }

    /**
     * Procedimiento para eliminar un invitado que el usuario haya seleccionado.
     */
    public void eliminarInvitado()
    {
        if(listaInvitados.size() == 0) System.out.println("No han habido invitados en "+ nombre +".");
        else listaInvitados.remove(seleccionarInvitado());
    }

    /**
     * Procedimiento para crear un empleado para el programa. No se puede crear un director.
     */
    public void crearEmpleado()
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

    /**
     * Procedimiento para crear un invitado para el programa.
     */
    public void crearInvitado()
    {
        System.out.print("Introduzca el nombre del invitado: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Introduzca la profesion: ");
        String profesion = FuncionesComunes.solicitarString();
        System.out.print("Introduzca la temporada: ");
        int temporada = FuncionesComunes.solicitudPositivosInt();

        Invitado invitado = new Invitado(nombre, profesion, temporada);
        listaInvitados.add(invitado);
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

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
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

    /**
     * Modificación de setDirector para solicitar al usuario el nombre del director. Solo se invoca desde el contructor o al haber eliminado a el director anterior.
     */
    private void setDirector() {
        System.out.print("Introduzca el nombre del director: ");
        Empleado director = new Empleado(FuncionesComunes.solicitarString()
                                        , CARGO_DIRECTOR
                                        , null
                                        , NUM_DIRECTOR);

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
