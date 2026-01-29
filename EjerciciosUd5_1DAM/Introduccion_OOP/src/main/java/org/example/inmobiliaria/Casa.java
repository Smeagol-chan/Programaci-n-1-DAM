package org.example.inmobiliaria;
import java.util.ArrayList;

public class Casa
{
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones;

    public Casa (String direccion)
    {
        this.direccion = direccion;
        listaHabitaciones = new ArrayList<>();
    }

    public void crearHabitacion(String nombre, double metros)
    {
        for(Habitacion habitacion : listaHabitaciones)
        {
            if(habitacion.getNombre().equals(nombre))
            {
                System.out.println("La habitación ya existe.");
                return;
            }
        }
        listaHabitaciones.add(new Habitacion(nombre, metros));
        System.out.println("Habitación creada.");
    }

    public void mostrarHabitaciones()
    {
        System.out.println("Casa en "+ direccion +" tiene "+ listaHabitaciones.size() +" habitaciomes:");
        for(Habitacion habitacion : listaHabitaciones)
        {
            System.out.println("- "+ habitacion.getNombre() +" ("+ habitacion.getMetros() +" m2)");
        }
    }

    public Habitacion habitacionMasGrande()
    {
        Habitacion cuartoMayor = listaHabitaciones.get(0);
        for (Habitacion habitacion : listaHabitaciones)
        {
            if(cuartoMayor.getMetros() < habitacion.getMetros()) cuartoMayor = habitacion;
        }
        return cuartoMayor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", listaHabitaciones=" + listaHabitaciones +
                '}';
    }
}
