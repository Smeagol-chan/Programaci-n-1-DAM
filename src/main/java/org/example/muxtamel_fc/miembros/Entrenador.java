package org.example.muxtamel_fc.miembros;
import org.example.muxtamel_fc.MutxamelFC;
import org.example.muxtamel_fc.enums.Equipos;
import org.example.muxtamel_fc.excepciones.IllegalFormacionExpeccion;
import org.example.muxtamel_fc.interfaces.AccionesDeportivas;

public class Entrenador extends MutxamelFC implements AccionesDeportivas
{
    private static final String FORMAT_FORMACIONPREFERIDA = "^[0-9]-[0-9]-[0-9]$";

    private Equipos equipo;
    private String formacionPreferida;

    public Entrenador(String nombre, int edad, Equipos equipo, String formacionPreferida)
    {
        super(nombre, edad);
        this.equipo = equipo;
        setFormacionPreferida(formacionPreferida);
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public String getFormacionPreferida() {
        return formacionPreferida;
    }

    public void setFormacionPreferida(String formacionPreferida)
    {
        try
        {
            if(formacionPreferida.matches(FORMAT_FORMACIONPREFERIDA))
                this.formacionPreferida = formacionPreferida;
            else throw new IllegalFormacionExpeccion();
        }
        catch(IllegalFormacionExpeccion e)
        {
            System.out.println("ERROR\nFormato de formación preferida inválido.\n");
        }
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
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Equipo: "+ equipo);
        System.out.println("Formación preferida: "+ formacionPreferida);
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
}
