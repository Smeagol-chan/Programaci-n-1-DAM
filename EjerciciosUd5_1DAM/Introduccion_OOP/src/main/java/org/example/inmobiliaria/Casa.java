package org.example.inmobiliaria;
import org.example.FuncionesComunes;

import java.util.ArrayList;

public class Casa
{
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones;
    private Propietario propietario;

    public Casa (String direccion)
    {
        this.direccion = direccion;
        listaHabitaciones = new ArrayList<>();
        setPropietario();
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
        System.out.println("Habitación "+ nombre +" creada.");
    }

    public void eliminarHabitacion(String nombre)
    {
        for(Habitacion habitacion : listaHabitaciones)
        {
            if(habitacion.getNombre().equals(nombre))
            {
                listaHabitaciones.remove(habitacion);
                System.out.println("Habitación eliminada.");
                return;
            }
        }
        System.out.println("La habitación no existe.");
    }

    public void mostrarHabitaciones()
    {
        System.out.println("Casa en "+ direccion +", de propietario " + propietario.getNombre() +
                ", tiene "+ listaHabitaciones.size() +" habitaciomes:");
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

    public void mostrarConsumoMayor()
    {
        Habitacion habitacionMayorConsumo = new Habitacion();
        double consumoHabitacionActual = habitacionMayorConsumo.calcularConsumo();
        double consumoHabitacionComprobar;
        for(Habitacion habitacion : listaHabitaciones)
        {
            consumoHabitacionComprobar = habitacion.calcularConsumo();
            if(consumoHabitacionActual < consumoHabitacionComprobar)
            {
                consumoHabitacionActual = consumoHabitacionComprobar;
                habitacionMayorConsumo = habitacion;
            }
        }
        System.out.println("La "+ habitacionMayorConsumo.getNombre() +" es la habitación que más consume.");
    }

    public double calcularConsumoGeneral()
    {
        double consumoTotal = 0;
        for(Habitacion habitacion : listaHabitaciones) consumoTotal += habitacion.calcularConsumo();
        return consumoTotal;
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

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario()
    {
        propietario = new Propietario(FuncionesComunes.solicitarString(), FuncionesComunes.solicitudInt());
    }

    @Override
    public String
    toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", listaHabitaciones=" + listaHabitaciones +
                ", propietario=" + propietario +
                '}';
    }
}

