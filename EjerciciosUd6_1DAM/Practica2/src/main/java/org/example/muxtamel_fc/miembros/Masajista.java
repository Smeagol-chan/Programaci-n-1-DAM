package org.example.muxtamel_fc.miembros;
import org.example.muxtamel_fc.MutxamelFC;

public class Masajista extends MutxamelFC
{
    private String titulacion;
    private int anosExperiencia;

    public Masajista(String nombre, int edad, String titulacion, int anosExperiencia)
    {
        this.titulacion = titulacion;
        this.anosExperiencia = anosExperiencia;
        super(nombre, edad);
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public void centrarse()
    {
        super.centrarse();
        System.out.println("para ayudar a los jugadores de su club.");
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Titulación: "+ titulacion);
        System.out.println("Años de experiencia: "+ anosExperiencia);
    }

    public void darMasaje(Jugador jugador)
    {
        System.out.println(nombre +" está dando un masaje a "+ jugador.getNombre() +".");
    }
}
