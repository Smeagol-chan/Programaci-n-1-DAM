package org.example.bus_imserso;
import java.util.ArrayList;

public class BusImserso
{
    private String matricula;
    private String destino;
    private ArrayList<Abuelo> listado;

    public BusImserso(String matricula, String destino)
    {
        this.matricula = matricula;
        this.destino = destino;
        listado = new ArrayList<>();
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

    public ArrayList<Abuelo> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Abuelo> listado) {
        this.listado = listado;
    }

    public void anyadirAbuelo(Abuelo abuelo)
    {
        listado.add(abuelo);
    }

    public void eliminarAbuelo(Abuelo abuelo)
    {
        listado.remove(abuelo);
    }

    public void mostrarAbuelos()
    {
        System.out.println("Abuelos del bus "+ matricula +":");
        for(Abuelo abuelo : listado) System.out.println("> "+ abuelo.getNombre());
    }

    public void mostrarMayores(int edad)
    {
        System.out.println("Abuelos mayores a "+ edad +" años:");
        for(Abuelo abuelo : listado)
        {
            if(abuelo.getEdad() >= edad) System.out.println("> "+ abuelo.getNombre());
        }
    }

    @Override
    public String toString() {
        return "BusImserso{" +
                "matricula='" + matricula + '\'' +
                ", destino='" + destino + '\'' +
                ", listado=" + listado +
                '}';
    }
}
