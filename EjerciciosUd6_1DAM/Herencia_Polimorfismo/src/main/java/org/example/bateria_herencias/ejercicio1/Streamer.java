package org.example.bateria_herencias.ejercicio1;
import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.synth.SynthTextAreaUI;

@Getter @Setter
public class Streamer extends Usuario
{
    private int numero_retransmisiones;
    private int horas_directo;

    public Streamer(String nombre, int edad, String nombreUsuario, int seguidores, int numero_retransmisiones, int horas_directo)
    {
        super(nombre, edad, nombreUsuario, seguidores);
        this.numero_retransmisiones = numero_retransmisiones;
        this.horas_directo = horas_directo;
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Número de retransmisiones: "+ numero_retransmisiones);
        System.out.println("Horas en directo: "+ horas_directo);
    }
}
