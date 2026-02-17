package org.example.dispositivos_inteligentes;

public abstract class Dispositivo
{
    private static final boolean DEFAULT_ESTADO = false;

    protected String nombre;
    protected boolean estado;

    public Dispositivo(String nombre)
    {
        this.nombre = nombre;
        estado = DEFAULT_ESTADO;
    }

    public abstract void encender();

    public void apagar()
    {
        if(estado)
        {
            estado = false;
            System.out.println(nombre +" apagado.");
        }
        else System.out.println(nombre +" ya sestá apagado.");
    }

    public void mostrarEstado()
    {
        System.out.println(estado ? "Encendido" : "Apagado");
    }

    public String getNombre() {
        return nombre;
    }
}
