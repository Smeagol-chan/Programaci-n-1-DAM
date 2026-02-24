package org.example.muxtamel_fc;
import org.example.muxtamel_fc.interfaces.FuncionesIntegradas;

public abstract class MutxamelFC implements FuncionesIntegradas
{
    protected String nombre;
    protected int edad;

    public MutxamelFC(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void centrarse()
    {
        System.out.print(nombre +" está centrándose... ");
    }

    @Override
    public void viajar(String ciudad)
    {
        System.out.println(nombre +" está viajando a "+ ciudad);
    }

    @Override
    public void celebrarGol()
    {
        System.out.println("GOOOOOOOOOOOOOOOOOOOOOOOOOOOL");
    }

    public void mostrarInfo()
    {
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: "+ edad);
    }
}
