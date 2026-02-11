package org.example.bateria_herencias.ejercicio2;
import java.util.ArrayList;

public class Main
{
    public static void asignarTarea(ArrayList<Empleado> listaEmpleados)
    {
        System.out.println("=== Usando el método asignarTarea() ===");
        for(Empleado empleado : listaEmpleados)
        {
            System.out.println("Asignando tarea al empleado...");
            empleado.realizarTarea();
        }
    }

    static void main()
    {
        Disenyador di1 = new Disenyador();
        Gerente g1 = new Gerente();
        Desarrollador de1 = new Desarrollador();

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(de1);
        listaEmpleados.add(di1);
        listaEmpleados.add(g1);

        asignarTarea(listaEmpleados);
    }
}
