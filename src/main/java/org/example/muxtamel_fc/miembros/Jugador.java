package org.example.muxtamel_fc.miembros;
import org.example.muxtamel_fc.MutxamelFC;
import org.example.muxtamel_fc.enums.Equipos;
import org.example.muxtamel_fc.enums.Posiciones;
import org.example.muxtamel_fc.interfaces.AccionesDeportivas;

public class Jugador extends MutxamelFC implements AccionesDeportivas
{
    private Equipos categoria;
    private int dorsal;
    private Posiciones posicion;

    public Jugador(String nombre, int edad, Equipos categoria, int dorsal, Posiciones posicion)
    {
        super(nombre, edad);
        this.categoria = categoria;
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public Equipos getCategoria() {
        return categoria;
    }

    public void setCategoria(Equipos categoria) {
        this.categoria = categoria;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Posiciones getPosicion() {
        return posicion;
    }

    public void setPosicion(Posiciones posicion) {
        this.posicion = posicion;
    }

    public void calentar()
    {
        System.out.println(nombre +" comienza el calentamiento");
    }

    public void descansar()
    {
        System.out.println(nombre +" se toma un descanso.");
    }

    public void marcarGol()
    {
        System.out.println("¡"+ nombre +" marca un gol!");
    }

    @Override
    public void centrarse()
    {
        super.centrarse();
        System.out.println("para darlo todo en el campo.");
    }

    @Override
    public void entrenar()
    {
        System.out.println(nombre +" entrena para el pertido.");
    }

    @Override
    public void jugarPartido(String rival)
    {
        System.out.println(nombre +" está jugando contra "+ rival +".");
    }
}
