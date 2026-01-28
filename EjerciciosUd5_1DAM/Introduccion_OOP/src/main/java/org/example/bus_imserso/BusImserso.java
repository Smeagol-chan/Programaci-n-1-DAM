package org.example.bus_imserso;
import java.util.ArrayList;

public class BusImserso
{
    private static ArrayList<Abuelo> listado = new ArrayList<>();

    private String matricula;
    private String destino;

    public BusImserso(String matricula, String destino)
    {
        this.matricula = matricula;
        this.destino = destino;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public
}
