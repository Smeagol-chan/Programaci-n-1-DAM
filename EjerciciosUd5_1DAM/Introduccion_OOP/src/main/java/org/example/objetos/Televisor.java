package org.example.objetos;

public class Televisor
{
    private static final int DEF_CANAL = 1; //Default Canal
    private static final int DEF_VOLUMEN = 5;

    private int canal;
    private int volumen;

    public Televisor()
    {
        canal = DEF_CANAL;
        volumen = DEF_VOLUMEN;
    }

    public Televisor(int valorCanal)
    {
        canal = valorCanal;
        volumen = DEF_VOLUMEN;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void subirCanal()
    {
        if(canal < 99) System.out.println("Canal: "+ (++canal));
    }

    public void bajarCanal()
    {
        if(canal > 0) System.out.println("Canal: "+ (--canal));
    }

    public void subirVolumen()
    {
        if(volumen < 99) System.out.println("Volumen: "+ (++volumen));
        {
            volumen++;
        }
    }

    public void bajarVolumen()
    {
        if(volumen > 0) System.out.println("Volumen: "+ (--volumen));
    }
}
