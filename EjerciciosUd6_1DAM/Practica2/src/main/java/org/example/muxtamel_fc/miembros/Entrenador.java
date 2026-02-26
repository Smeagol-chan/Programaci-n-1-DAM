package org.example.muxtamel_fc.miembros;
import org.example.AppMantenimiento;
import org.example.muxtamel_fc.MutxamelFC;
import org.example.muxtamel_fc.enums.Equipos;
import org.example.muxtamel_fc.excepciones.EntrenadorDuplicadoException;
import org.example.muxtamel_fc.excepciones.IllegalFormacionException;
import org.example.muxtamel_fc.interfaces.AccionesDeportivas;

public class Entrenador extends MutxamelFC implements AccionesDeportivas
{
    private static final String FORMAT_FORMACIONPREFERIDA = "^[0-9]-[0-9]-[0-9]$";

    private Equipos equipo;
    private String formacionPreferida;

    public Entrenador(String nombre, int edad, Equipos equipo, String formacionPreferida)
    {
        super(nombre, edad);
        setEquipo(equipo);
        setFormacionPreferida(formacionPreferida);
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo)
    {
        for(MutxamelFC miembro : AppMantenimiento.miembrosClub)
        {
            if(miembro instanceof Entrenador)
            {
                if(((Entrenador) miembro).equipo == equipo)
                    throw new EntrenadorDuplicadoException();
            }
        }
        this.equipo = equipo;
    }

    public String getFormacionPreferida() {
        return formacionPreferida;
    }

    public void setFormacionPreferida(String formacionPreferida)
    {
        if(formacionPreferida.matches(FORMAT_FORMACIONPREFERIDA)) this.formacionPreferida = formacionPreferida;
        else throw new IllegalFormacionException();
    }

    public void planificarEntrenamiento()
    {
        System.out.println(nombre +" está planificando la sesión de entrenamiento de hoy.");
    }

    public void hacerCambios()
    {
        System.out.println(nombre +" hace cambios en las posiciones de los jugadores.");
    }

    @Override
    public void centrarse()
    {
        super.centrarse();
        System.out.println("para liderar al equipo.");
    }

    @Override
    public void entrenar()
    {
        System.out.println(nombre +" entrena las estrategias para el partido.");
    }

    @Override
    public void jugarPartido(String rival)
    {
        System.out.println(nombre +" está supervidando a su equipo mientras juega contra "+ rival +".");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Equipo: "+ equipo +
                ", Formación preferida: "+ formacionPreferida;
    }
}
