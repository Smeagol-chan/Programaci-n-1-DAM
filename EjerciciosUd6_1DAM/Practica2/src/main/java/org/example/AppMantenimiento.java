package org.example;
import org.example.muxtamel_fc.MutxamelFC;
import org.example.muxtamel_fc.enums.Equipos;
import org.example.muxtamel_fc.enums.Posiciones;
import org.example.muxtamel_fc.excepciones.*;
import org.example.muxtamel_fc.miembros.Acompanante;
import org.example.muxtamel_fc.miembros.Entrenador;
import org.example.muxtamel_fc.miembros.Jugador;
import org.example.muxtamel_fc.miembros.Masajista;
import java.util.ArrayList;

public class AppMantenimiento
{
    public static ArrayList<MutxamelFC> miembrosClub = new ArrayList<>();

    private static void equiposMutxamel()
    {
        System.out.println("=== Consultar equipos ===\n");
        System.out.println("¿Qué equipo quieres ver en detalle?\n");
        for(Equipos equipo : Equipos.values()) System.out.println("\t--> "+ equipo);
        System.out.println("\t--> Masajistas");
        System.out.println("\t--> Acompañantes");
        System.out.println("\n===============================\n");
        System.out.print("Seleciona una opción --> ");
    }

    private static Acompanante agregarAcompanante(Jugador jugador)
    {
        System.out.println("=== Mantenimiento de jugadores. Agregar acompañante ===\n");
        System.out.print("Nombre: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Edad: ");
        int edad = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();
        System.out.print("Parentesco: ");
        String parentesco = FuncionesComunes.solicitarString();

        Acompanante acompanante = new Acompanante(nombre, edad, jugador, parentesco);

        if(miembrosClub.contains(acompanante)) throw new AcompanteDuplicadoException();

        return acompanante;
    }

    private static void modificarJugador(Jugador jugador)
    {
        System.out.println("=== Mantenimiento de jugadores. Modificar datos de jugadores existentes ===\n");
        System.out.println("Modificando jugador: ["+ jugador +"]\n");
        System.out.println("¿Qué quieres modificar? [nombre, edad, categoría, dorsal, posición]:\n");
        System.out.println("=================================================\n");
        System.out.print("Selecciona una opción --> ");
        switch(FuncionesComunes.solicitarString().toLowerCase())
        {
            case "nombre":
                System.out.print("Nuevo nombre --> ");
                jugador.setNombre(FuncionesComunes.solicitarString());
                break;

            case "edad":
                System.out.print("Nueva edad --> ");
                jugador.setEdad((int) FuncionesComunes.solicitudPositivosNumero());
                FuncionesComunes.key.nextLine();
                break;

            case "categoría":
            case "categoria":
                System.out.print("Nueva categoría --> ");
                jugador.setCategoria(Equipos.valueOf(FuncionesComunes.solicitarString().toUpperCase()));
                break;

            case "dorsal":
                System.out.print("Nuevo dorsal --> ");
                jugador.setEdad((int) FuncionesComunes.solicitudPositivosNumero());
                FuncionesComunes.key.nextLine();
                break;

            case "posición":
            case "posicion":
                System.out.print("Nueva posición --> ");
                jugador.setPosicion(Posiciones.valueOf(FuncionesComunes.solicitarString()));
                break;
        }
    }

    private static void modificarEntrenador(Entrenador entrenador)
    {
        System.out.println("=== Mantenimiento de entrenadores. Modificar datos de entrenadores existentes ===\n");
        System.out.println("Modificando entrenador: ["+ entrenador +"]\n");
        System.out.println("¿Qué quieres modificar? [nombre, edad, equipo, formación]:\n");
        System.out.println("=================================================\n");
        System.out.print("Selecciona una opción --> ");
        switch(FuncionesComunes.solicitarString().toLowerCase())
        {
            case "nombre":
                System.out.print("Nuevo nombre --> ");
                entrenador.setNombre(FuncionesComunes.solicitarString());
                break;

            case "edad":
                System.out.print("Nueva edad --> ");
                entrenador.setEdad((int) FuncionesComunes.solicitudPositivosNumero());
                FuncionesComunes.key.nextLine();
                break;

            case "equipo":
                System.out.print("Nuevo equipo --> ");
                entrenador.setEquipo(Equipos.valueOf(FuncionesComunes.solicitarString().toUpperCase()));
                break;

            case "formación":
            case "formacion":
                System.out.print("Nueva formación --> ");
                entrenador.setFormacionPreferida(FuncionesComunes.solicitarString());
                break;
        }
    }

    private static void modificarMasajista(Masajista masajista)
    {
        Masajista masajistaTest = masajista;
        System.out.println("=== Mantenimiento de masajistas. Modificar datos de masajistas existentes ===\n");
        System.out.println("Modificando masajista: ["+ masajista +"]\n");
        System.out.println("¿Qué quieres modificar? [nombre, edad, titulación, experiencia]:\n");
        System.out.println("=================================================\n");
        System.out.print("Selecciona una opción --> ");
        switch(FuncionesComunes.solicitarString().toLowerCase())
        {
            case "nombre":
                System.out.print("Nuevo nombre --> ");
                masajistaTest.setNombre(FuncionesComunes.solicitarString());

                if(miembrosClub.contains(masajistaTest)) throw new MasajistaDuplicadoException();
                else masajista.setNombre(masajistaTest.getNombre());
                break;

            case "edad":
                System.out.print("Nueva edad --> ");
                masajistaTest.setEdad((int) FuncionesComunes.solicitudPositivosNumero());
                FuncionesComunes.key.nextLine();

                if(miembrosClub.contains(masajistaTest)) throw new MasajistaDuplicadoException();
                else masajista.setEdad(masajistaTest.getEdad());
                break;

            case "titulación":
            case "titulacion":
                System.out.print("Nueva titulación --> ");
                masajistaTest.setTitulacion(FuncionesComunes.solicitarString());

                if(miembrosClub.contains(masajistaTest)) throw new MasajistaDuplicadoException();
                else masajista.setTitulacion(masajistaTest.getTitulacion());
                break;

            case "experiencia":
                System.out.print("Nuevos años de experiencia --> ");
                masajistaTest.setEdad((int) FuncionesComunes.solicitudPositivosNumero());
                FuncionesComunes.key.nextLine();

                if(miembrosClub.contains(masajistaTest)) throw new MasajistaDuplicadoException();
                else masajista.setAnosExperiencia(masajistaTest.getAnosExperiencia());
                break;
        }
    }

    private static ArrayList<Jugador> mostrarJugador(boolean mostrarSeniors)
    {
        ArrayList<Jugador> listaMiembros = new ArrayList<>();
        int contador = 0;
        for(MutxamelFC miembro : miembrosClub)
        {
            if(miembro instanceof Jugador)
            {
                if(mostrarSeniors ? ((Jugador) miembro).getCategoria() == Equipos.SENIOR : true)
                {
                    System.out.println("[" + contador++ + ", " + miembro + "]");
                    listaMiembros.add((Jugador) miembro);
                }
            }
        }
        return listaMiembros;
    }

    private static ArrayList<Entrenador> mostrarEntrenador()
    {
        ArrayList<Entrenador> listaMiembros = new ArrayList<>();
        int contador = 0;
        for(MutxamelFC miembro : miembrosClub)
        {
            if(miembro instanceof Entrenador)
            {
                System.out.println("["+ contador++ +", "+ miembro +"]");
                listaMiembros.add((Entrenador) miembro);
            }
        }
        return listaMiembros;
    }

    private static ArrayList<Masajista> mostrarMasajista()
    {
        ArrayList<Masajista> listaMiembros = new ArrayList<>();
        int contador = 0;
        for(MutxamelFC miembro : miembrosClub)
        {
            if(miembro instanceof Masajista)
            {
                System.out.println("["+ contador++ +", "+ miembro +"]");
                listaMiembros.add((Masajista) miembro);
            }
        }
        return listaMiembros;
    }

    private static void menuModificar(String tipoMiembro)
    {
        System.out.println("=== Mantenimiento de "+ tipoMiembro +". " +
                "Modificar datos de "+ tipoMiembro +" existente ===\n");
        System.out.println("¿De qué "+ tipoMiembro +" quieres hacer cambios?\n");
    }

    private static Jugador anyadirJugador()
    {
        System.out.println("=== Mantenimiento de jugador. Añadir jugador nuevo ===\n");
        System.out.print("Nombre: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Edad: ");
        int edad = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();
        System.out.print("Categoría: ");
        Equipos categoria = Equipos.valueOf(FuncionesComunes.solicitarString().toUpperCase());
        System.out.print("Dorsal: ");
        int dorsal = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();
        System.out.print("Posicion: ");
        Posiciones posicion = Posiciones.valueOf(FuncionesComunes.solicitarString().toUpperCase());

        return new Jugador(nombre, edad, categoria, dorsal, posicion);
    }

    private static Entrenador anyadirEntrenador()
    {
        System.out.println("=== Mantenimiento de entrenador. Añadir entrenador nuevo ===\n");
        System.out.print("Nombre: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Edad: ");
        int edad = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();
        System.out.print("Equipo: ");
        Equipos equipo = Equipos.valueOf(FuncionesComunes.solicitarString().toUpperCase());
        System.out.print("Formación preferida: ");
        String formacionPreferida = FuncionesComunes.solicitarString();

        return new Entrenador(nombre, edad, equipo, formacionPreferida);
    }

    private static Masajista anyadirMasajista()
    {
        System.out.println("=== Mantenimiento de masajista. Añadir masajista nuevo ===\n");
        System.out.print("Nombre: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Edad: ");
        int edad = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();
        System.out.print("Titulación: ");
        String titulacion = FuncionesComunes.solicitarString();
        System.out.print("Años de experiencia: ");
        int experiencia = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();

        Masajista masajista = new Masajista(nombre, edad, titulacion, experiencia);

        if(miembrosClub.contains(masajista)) throw new MasajistaDuplicadoException();

        return masajista;
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

    private static void opcionesMenuAcciones(String tipoMiembro)
    {
        boolean vuelta = true;
        do
        {
            menuAcciones(tipoMiembro);
            switch(FuncionesComunes.solicitudChar())
            {
                case '1':
                    switch (tipoMiembro)
                    {
                        case "jugador":
                            try
                            {
                                miembrosClub.add(anyadirJugador());
                            }
                            catch(DorsalDuplicadoExcepcion e)
                            {
                                System.out.println("No se pudo añadir al jugador. El dorsal está duplicado.");
                            }
                            catch(IllegalArgumentException e)
                            {
                                System.out.println("No se pudo añadir al jugador. El equipo no es válido.");
                            }
                            break;

                        case "entrenador":
                            try
                            {
                                miembrosClub.add(anyadirEntrenador());
                            }
                            catch(IllegalFormacionException e)
                            {
                                System.out.println("No se pudo añadir al entrenador. La formación no cumple el formato.");
                            }
                            catch(EntrenadorDuplicadoException e)
                            {
                                System.out.println("No se pudo añadir al entrenador. Ya existe un entrenador para este equipo.");
                            }
                            catch(IllegalArgumentException e)
                            {
                                System.out.println("No se pudo añadir al entrenador. El equipo no es válido.");
                            }
                            break;

                        case "masajista":
                            try
                            {
                                miembrosClub.add(anyadirMasajista());
                            }
                            catch(MasajistaDuplicadoException e)
                            {
                                System.out.println("No se pude añadir al masajista");
                            }
                            break;
                    }
                    break;

                case '2':
                    menuModificar(tipoMiembro);
                    switch (tipoMiembro)
                    {
                        case "jugador":
                            try
                            {
                                ArrayList<Jugador> listaJugadores = mostrarJugador(false);
                                System.out.println("\n=====================================================\n");
                                System.out.print("Selecciona una opción --> ");
                                modificarJugador(listaJugadores.get((int) FuncionesComunes.solicitudPositivosNumero()));
                            }
                            catch(DorsalDuplicadoExcepcion e)
                            {
                                System.out.println("No se pudo modificar al jugador. El dorsal está duplicado.");
                            }
                            catch(IllegalArgumentException e)
                            {
                                System.out.println("No se pudo modificar al jugador. El equipo no es válido.");
                            }
                            catch(IndexOutOfBoundsException e)
                            {
                                System.out.println("Opción inválida.");
                            }
                            break;

                        case "entrenador":
                            try
                            {
                                ArrayList<Entrenador> listaEntrendor = mostrarEntrenador();
                                System.out.println("\n=====================================================\n");
                                System.out.print("Selecciona una opción --> ");
                                modificarEntrenador(listaEntrendor.get((int) FuncionesComunes.solicitudPositivosNumero()));
                            }
                            catch(IllegalFormacionException e)
                            {
                                System.out.println("No se pudo modificar al entrenador. La formación no cumple el formato.");
                            }
                            catch(EntrenadorDuplicadoException e)
                            {
                                System.out.println("No se pudo modificar al entrenador. Ya existe un entrenador para este equipo.");
                            }
                            catch(IllegalArgumentException e)
                            {
                                System.out.println("No se pudo modificar al entrenador. El equipo no es válido.");
                            }
                            catch(IndexOutOfBoundsException e)
                            {
                                System.out.println("Opción inválida.");
                            }
                            break;

                        case "masajista":
                            try
                            {
                                ArrayList<Masajista> listaMasajistas = mostrarMasajista();
                                System.out.println("\n=====================================================\n");
                                System.out.print("Selecciona una opción --> ");
                                modificarMasajista(listaMasajistas.get((int) FuncionesComunes.solicitudPositivosNumero()));
                            }
                            catch(MasajistaDuplicadoException e)
                            {
                                System.out.println("No se pude modificar al masajista");
                            }
                            catch(IndexOutOfBoundsException e)
                            {
                                System.out.println("Opción inválida.");
                            }
                            break;
                    }
                    break;

                case 'X':
                    System.out.println("Volviendo al menú principal.");
                    vuelta = false;
                    break;

                case '3':
                    if(tipoMiembro.equals("jugador"))
                    {
                        System.out.println("=== Mantenimiento de jugadores. Agregar acompañante ===\n");
                        System.out.println("¿A qué jugador le quieres añadir un acompañante?\n");
                        ArrayList<Jugador> listaSeniors = mostrarJugador(true);
                        System.out.println("\n=====================================================\n");
                        System.out.print("Selecciona una opción --> ");
                        try
                        {
                            miembrosClub.add(agregarAcompanante(listaSeniors.get((int) FuncionesComunes.solicitudPositivosNumero())));
                        }
                        catch(IndexOutOfBoundsException e)
                        {
                            System.out.println("Opción inválida.");
                        }
                        catch(AcompanteDuplicadoException e)
                        {
                            System.out.println("No se pudo añadir al acompañante. Ya está presente en la lista.");
                        }
                        break;
                    }

                default:
                    System.out.println("ERROR\nOpción inválida.");
                    break;
            }
        }while(vuelta);
    }

    private static void mostrarEquipos(String opcion)
    {
        System.out.print("=== Consultar equipos. ");
        if(opcion.equals("MASAJISTAS"))
        {
            System.out.println("Masajistas del MutxamelFC ===\n");
            for(MutxamelFC miembro : miembrosClub)
            {
                if(miembro instanceof Masajista) System.out.println("\t["+ miembro +"]");
            }
        }
        else if(opcion.equals("ACOMPAÑANTES"))
        {
            System.out.println("Acompañantes del MutxamelFC ===\n");
            for(MutxamelFC miembro : miembrosClub)
            {
                if(miembro instanceof Acompanante) System.out.println("\t["+ miembro +"]");
            }
        }
        else
        {
            Equipos equipo = Equipos.valueOf(opcion);
            System.out.println("Equipo "+ equipo +" del MutxamelFC ===\n");
            System.out.println("Jugadores:");
            for(MutxamelFC miembro : miembrosClub)
            {
                if(miembro instanceof Jugador && ((Jugador) miembro).getCategoria() == equipo)
                {
                    System.out.println("\t["+ miembro +"]");
                }
            }
            System.out.println("\nEntrenador:");
            for(MutxamelFC miembro : miembrosClub)
            {
                if(miembro instanceof Entrenador && ((Entrenador) miembro).getEquipo() == equipo)
                {
                    System.out.println("\t["+ miembro +"]");
                }
            }
        }
    }

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

    private static void opcionMenuPrincipal()
    {
        boolean vuelta = true;
        do
        {
            menuPrincipal();
            switch (FuncionesComunes.solicitudChar())
            {
                case '1':
                    opcionesMenuAcciones("jugador");
                    break;

                case '2':
                    opcionesMenuAcciones("entrenador");
                    break;

                case '3':
                    opcionesMenuAcciones("masajista");
                    break;

                case '4':
                    equiposMutxamel();
                    try
                    {
                        mostrarEquipos(FuncionesComunes.solicitarString().toUpperCase());
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 'X':
                    vuelta = false;
                    break;

                default:
                    System.out.println("ERROR\nOpción inválida.");
                    break;
            }
        }while(vuelta);
    }

    static void main()
    {
        opcionMenuPrincipal();
    }
}
