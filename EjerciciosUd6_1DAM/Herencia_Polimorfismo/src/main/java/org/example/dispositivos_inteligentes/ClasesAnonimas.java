package org.example.dispositivos_inteligentes;

public class ClasesAnonimas
{
    public static Dispositivo claseAnonima()
    {
        /**
         * Clase anónima
         */
        Dispositivo microondas = new Dispositivo("Microondas") {
            @Override
            public void encender() {
                if(estado) System.out.println("El microondas ya está encendido.");
                else
                {
                    estado = true;
                    System.out.println("Encendiendo microodas...");
                }
            }
        };
        return microondas;
    }

    public static Dispositivo anomProyector()
    {
        Dispositivo proyector = new Dispositivo("Proyector") {
            @Override
            public void encender() {
                if(estado) System.out.println("Encendiendo proyector con ajuste automático de brillo...");
                else
                {
                    estado = true;
                    System.out.println("El proyector ya está encendido...");
                }
            }
        };
        return proyector;
    }

    public static ControlRemoto sincProyector()
    {
        ControlRemoto proyector = new ControlRemoto()
        {
            @Override
            public void sincronizar()
            {
                System.out.println("Sincronizando proyector con contol rmeoto de presentación...");
            }
        };
        return proyector;
    }

    public static Dispositivo anomHorno()
    {
        Dispositivo horno = new Dispositivo("Proyector") {
            @Override
            public void encender() {
                if(estado) System.out.println("Calentando horno con ajuste automático de temperatura...");
                else
                {
                    estado = true;
                    System.out.println("El horno ya está encendido...");
                }
            }
        };
        return horno;
    }
}
