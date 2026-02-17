package org.example.dispositivos_inteligentes;

public class AireAcondicionado extends Dispositivo implements ControlRemoto
{
    public AireAcondicionado(String nombre)
    {
        super(nombre);
    }

    @Override
    public void encender()
    {
        if(estado) System.out.println("El aire acondicionado ya está encendido.");
        else
        {
            estado = true;
            System.out.println("Encendiendo aire acondicionado...");
        }
    }

    @Override
    public void sincronizar()
    {
        System.out.println("Sincronizando aire acondicionado con el control remoto...");
    }
}
