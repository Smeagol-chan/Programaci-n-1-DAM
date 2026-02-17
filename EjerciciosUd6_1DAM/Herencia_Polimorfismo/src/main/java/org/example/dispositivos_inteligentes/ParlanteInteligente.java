package org.example.dispositivos_inteligentes;

public class ParlanteInteligente extends Dispositivo
{
    public ParlanteInteligente(String nombre)
    {
        super(nombre);
    }

    @Override
    public void encender()
    {
        if(estado) System.out.println("El parlante ya está encendido.");
        else
        {
            estado = true;
            System.out.println("Activando parlante con comando de voz...");
        }
    }
}
