package org.example.enum_intro.ej1;

public class SemaforoApp
{
    static void main()
    {
        Semaforo semaforo = Semaforo.ROJO;

        for (int i = 0; i < 10; i++)
        {
            semaforo = semaforo.siguiente();
            System.out.println(semaforo);
        }
    }
}
