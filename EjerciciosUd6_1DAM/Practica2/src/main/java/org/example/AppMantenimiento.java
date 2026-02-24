package org.example;
import org.example.muxtamel_fc.MutxamelFC;

import java.util.ArrayList;

public class AppMantenimiento
{
    private static void menuPrincipal()
    {
        System.out.println("=== App de mantenimiento del MUTXAMEL FC ===\n");
        System.out.println("\t[1]. Mantenimiento jugadores\n" +
                "\t\tDentro podremos añadir jugadores, modificar datos y añadir acompañantes (sólo seniors).");
        System.out.println("\t[2]. Mantenimiento de entrenadores (añadir-modificar-salir)\n" +
                "\t\tDentro podremos añadir entrenadores y modificar sus datos.");
        System.out.println("\t[3]. Mantenimiento de masajistas (añadir-modificar datos-salir)\n" +
                "\t\tDentro podremos añadir masajistas y modiicar sus datos.");
        System.out.println("\t[4]. Consultar equipos\n" +
                "\t\tDentro se deben listar los tipos de equipos y elegir uno.");
        System.out.println("\t[X]. Salir\n");
        System.out.println("===========================================================================");
        System.out.print("\nSeleciona una opción --> ");
    }

    private static void menuAcciones(String tipoMiembro)
    {
        System.out.println("=== Mantenimiento de "+ tipoMiembro +" ===\n");
        System.out.println("\t[1]. Añadir nuevo "+ tipoMiembro);
        System.out.println("\t[2]. Modificar datos de "+ tipoMiembro +" existente");
        if(tipoMiembro.equals("jugador"))
            System.out.println("\t[3]. Crear acompañantes (sólo seniors)");
        System.out.println("\t[X]. Volver al menú principal");
        System.out.println("===========================================================================");
        System.out.print("\nSeleciona una opción --> ");
    }

    private static void menuModiicar(String tipoMiembro)
    {
        System.out.println("=== Mantenimiento de "+ tipoMiembro +". " +
                "Modificar datos de "+ tipoMiembro +" existente ===\n");
        System.out.println("¿De qué "+ tipoMiembro +" quieres hacer cambios?");
        System.out.print("[");
    }

    static void main()
    {
        ArrayList<MutxamelFC> miembrosClub = new ArrayList<>();

        ArrayList<MutxamelFC> equipoBenjamin = new ArrayList<>();
        ArrayList<MutxamelFC> equipoAlevin = new ArrayList<>();
        ArrayList<MutxamelFC> equipoInfantil = new ArrayList<>();
        ArrayList<MutxamelFC> equipoCadete = new ArrayList<>();
        ArrayList<MutxamelFC> equipoJuvenil = new ArrayList<>();
        ArrayList<MutxamelFC> equipoSenior = new ArrayList<>();

        menuPrincipal();
        menuAcciones("entrenador");
    }
}
