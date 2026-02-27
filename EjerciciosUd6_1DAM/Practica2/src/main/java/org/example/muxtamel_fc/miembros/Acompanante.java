package org.example.muxtamel_fc.miembros;

/**
 * Clase hija de MutxamelFC.
 * Sus atributos adicionales son integrante, que almacena el Jugador al que acompaña, y parentesco.
 */
public class Acompanante extends MutxamelFC
{
    private Jugador integrante;
    private String parentesco;

    public Acompanante(String nombre, int edad, Jugador integrante, String parentesco)
    {
        super(nombre, edad);
        this.integrante = integrante;
        this.parentesco = parentesco;
    }

    public Jugador getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Jugador integrante) {
        this.integrante = integrante;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public void animarEquipo()
    {
        System.out.println(nombre +" anima a "+ integrante.getNombre() +" para que gane.");
    }

    @Override
    public void centrarse()
    {
        super.centrarse();
        System.out.println("para reunirse con su equipo en las gradas.");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Acompañante: "+ integrante +
                ", Parentesco: "+ parentesco;
    }
}
