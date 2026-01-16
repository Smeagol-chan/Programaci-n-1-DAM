package org.example.app;

import org.example.objetos.Paciente;

public class PacientesApp
{
    static void main()
    {
        Paciente pedro = new Paciente("Pedro", 18, 'H', 10, 185);
        Paciente desconocido = new Paciente();
        Paciente carla = new Paciente("Carla", 36, 'M');

        pedro.datosPacientes();
//        desconocido.datosPacientes();
//        carla.datosPacientes();

        System.out.println(pedro.calcularMC());
    }
}
