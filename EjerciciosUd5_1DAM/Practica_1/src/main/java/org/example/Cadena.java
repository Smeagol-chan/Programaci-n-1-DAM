package org.example;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase independiente.
 * @author ericr
 * @version 1.0 (06/02/2026)
 */
public class Cadena
{
    private String nombre;
    private ArrayList<Programa> listaProgramas;

    /**
     * Constructor de Cadena.
     * @param nombre - String con el nombre de la cadena.
     */
    public Cadena(String nombre)
    {
        this.nombre = nombre;
        listaProgramas = new ArrayList<>();
    }

    /**
     * Función que confirma si una persona ha sido invitada con anterioridad a cualquier programa de la cadena.
     * @param nombre - Nombre del invitado que comprobar.
     * @return True si se encuentra una coincidencia y false en caso contrario.
     */
    public boolean buscarInvitado(String nombre)
    {
        for(Programa programa : listaProgramas)
        {
            for(Invitado invitado : programa.getListaInvitados())
                if(invitado.getNombre().contains(nombre)) return true;
        }
        return false;
    }

    /**
     * Procedimiento para comprobar cuál ha sido el primer programa al que asistión un invitado.
     * @param nombre - String con el nombre del invitado a comprobar.
     */
    public void invitadoAntes(String nombre)
    {
        if(buscarInvitado(nombre))
        {
            Programa primerPrograma = null;
            LocalDate primeraInvitacion = LocalDate.now();

            for(Programa programa : listaProgramas)
            {
                for(Invitado invitado : programa.getListaInvitados())
                {
                    if(invitado.getNombre().contains(nombre)
                            && invitado.getFecha_visita().isBefore(primeraInvitacion))
                    {
                        primerPrograma = programa;
                        primeraInvitacion = invitado.getFecha_visita();
                    }
                }
            }
            System.out.println(nombre +" fue invitado por primera vez en el programa "
                    + primerPrograma.getNombre() +", el "+ primeraInvitacion +".");
        }
        else System.out.println(nombre +" nunca ha sido invitado en ningún programa de la cadena "+ this.nombre +".");
    }

    /**
     * Comprobar si el programa ya está listado en la cadena
     * @param programa - Programa comprobar.
     * @return Booleano, siento true en caso de estar presente y false en caso contrario.
     */
    private boolean presenteEnLista(Programa programa)
    {
        return listaProgramas.contains(programa);
    }

    /**
     * Recibiendo un objeto Programa, se añade a la lista de programas en la cadena.
     * @param programa - Programa a añadir.
     */
    public void anyadirPrograma(Programa programa)
    {
        if(presenteEnLista(programa)) System.out.println(programa.getNombre() + " ya está presente en la cadena.");
        else listaProgramas.add(programa);
    }

    /**
     * Recibiendo un objeto Programa, se elimina de la lista de programas en la cadena.
     * @param programa - Programa a eliminar.
     */
    public void eliminarPrograma(Programa programa)
    {
        if(presenteEnLista(programa)) listaProgramas.remove(programa);
        else System.out.println(programa.getNombre() + " no está presente en la cadena.");
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
