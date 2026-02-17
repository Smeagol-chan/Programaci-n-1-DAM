package org.example.dispositivos_inteligentes;

public class Televisor extends Dispositivo implements ControlRemoto
{
    public Televisor(String nombre)
    {
        super(nombre);
    }

    @Override
    public void encender()
    {
        if(estado) System.out.println("El televisor ya está encendido.");
        else
        {
            estado = true;
            System.out.println("Encendiendo televisor...");
        }
    }

    @Override
    public void sincronizar()
    {
        System.out.println("Sincronizando televisor con el control remoto...");
    }
}
