package org.example.muxtamel_fc;
import org.example.FuncionesComunes;
import org.example.muxtamel_fc.enums.Equipos;
import org.example.muxtamel_fc.enums.Posiciones;
import org.example.muxtamel_fc.excepciones.*;
import org.example.muxtamel_fc.miembros.*;

import java.util.ArrayList;

/**
 * Clase que contiene toda la lógica y funcionalidades el programa.
 * Todas las funciones para solicitar datos al usuario por teclado está en la clase FuncionesComunes.
 * Todos los métodos son privados excepto los necesarios para arrancar el proceso e inicializar la lista de miembros. Como no necesito
 * poder acceder a ellos desde ningún otro lado pero sí que necesito poder llamar a miembrosClub. Cuantos menos métodos puedan
 * ver otras clases, menos aparecen en el pop-up de autocompletar.
 */
public class Mantenimiento
{
    /**
     * ArrayList de objetos MutxamelFC.
     * Estática y pública para que los objetos puedan llamarla desde sus respectivas clases.
     */
    public static ArrayList<MutxamelFC> miembrosClub = new ArrayList<>();

    /**
     * Pricedimiento.
     * Modifica el dato elegido por el usuario del Jugador que previamente ha seleccionado.
     * @param jugador Jugador que modificar.
     */
    private static void modificarJugador(Jugador jugador)
    {
        FuncionesComunes.key.nextLine();
        System.out.println("\n=== Mantenimiento de jugadores. Modificar datos de jugadores existentes ===\n");
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
                Equipos categoria = Equipos.valueOf(FuncionesComunes.solicitarString().toUpperCase());

                //Hay que comprobar que al cambiar de categoría su dorsal no coincida con el de otro ya presente en el equipo objetivo.
                for(MutxamelFC miembro : miembrosClub)
                {
                    if (miembro instanceof Jugador)
                        if (((Jugador) miembro).getCategoria() == categoria && ((Jugador) miembro).getDorsal() == jugador.getDorsal())
                            throw new DorsalDuplicadoExcepcion();
                }

                //No se permiten acompañantes de jugadores que NO sean SENIOR. Si un jugador SENIOR con acompañantes previos cambia de equipo,
                //se deben eliminar dichos acompañantes.
                if(categoria != Equipos.SENIOR)
                {
                    for(MutxamelFC miembro : miembrosClub)
                        if(miembro instanceof Acompanante && ((Acompanante) miembro).getIntegrante() == jugador)
                            miembrosClub.remove(miembro);
                }
                jugador.setCategoria(categoria);
                break;

            case "dorsal":
                System.out.print("Nuevo dorsal --> ");
                jugador.setDorsal((int) FuncionesComunes.solicitudPositivosNumero());
                FuncionesComunes.key.nextLine();
                break;

            case "posición":
            case "posicion":
                System.out.print("Nueva posición --> ");
                jugador.setPosicion(Posiciones.valueOf(FuncionesComunes.solicitarString()));
                break;

            default:
                System.out.println("Atributo inválido.");
                break;
        }
    }

    /**
     * Pricedimiento.
     * Modifica el dato elegido por el usuario del Entrenador que previamente ha seleccionado.
     * @param entrenador Entrenador que modificar.
     */
    private static void modificarEntrenador(Entrenador entrenador)
    {
        FuncionesComunes.key.nextLine();
        System.out.println("\n=== Mantenimiento de entrenadores. Modificar datos de entrenadores existentes ===\n");
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

            default:
                System.out.println("Atributo inválido.");
                break;
        }
    }

    /**
     * Pricedimiento.
     * Modifica el dato elegido por el usuario del Masajista que previamente ha seleccionado.
     * A diferencia de Entrenador y Jugador que por naturaleza no permiten objetos duplicados (no más de un entrenador por equipo y
     * no se pueden repetir dorsales dentro de la misma categoría), Masajista sí que puede duplicarse si no se controla.
     * Antes de realizar ningún cambio, se comprueba si el Masajista con los datos nuevos ya está presente en miembrosClub,
     * lanzando excepción de ser así.
     * @param masajista Masajista que modificar.
     */
    private static void modificarMasajista(Masajista masajista)
    {
        FuncionesComunes.key.nextLine();
        Masajista masajistaTest = masajista;
        System.out.println("\n=== Mantenimiento de masajistas. Modificar datos de masajistas existentes ===\n");
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

            default:
                System.out.println("Atributo inválido.");
                break;
        }
    }

    /**
     * Función.
     * Recorre miembrosClub imprimiendo los datos de cada Jugador junto con su número de posición en la lista.
     * @param mostrarSeniors Booleano para activar (es true) o desactivar (es false) el filtro para jugadores SENIOR.
     * @return ArrayList de los Jugadores mostrados.
     */
    private static ArrayList<Jugador> mostrarJugador(boolean mostrarSeniors)
    {
        ArrayList<Jugador> listaMiembros = new ArrayList<>();
        int contador = 0;
        for(MutxamelFC miembro : miembrosClub)
        {
            if(miembro instanceof Jugador)
            {
                //Si mostrarSeniors es true, se activa un filtro extra para permitir el paso solo a los SENIOR.
                //Si mostrarSeniors es false, este if tiene de condición true, por lo que siempre se activa.
                if(mostrarSeniors ? ((Jugador) miembro).getCategoria() == Equipos.SENIOR : true)
                {
                    System.out.println("[" + contador++ + ", " + miembro + "]");
                    listaMiembros.add((Jugador) miembro);
                }
            }
        }
        return listaMiembros;
    }

    /**
     * Función.
     * Recorre miembrosClub imprimiendo los datos de cada Entrenador junto con su número de posición en la lista.
     * @return ArrayList de los Entrenadores mostrados.
     */
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

    /**
     * Función.
     * Recorre miembrosClub imprimiendo los datos de cada Masajista junto con su número de posición en la lista.
     * @return ArrayList de los Masajistas mostrados.
     */
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

    /**
     * Procedimiento.
     * Cabecera del menú para modificar un miembro del club. Altera el contenido dependiedo
     * de la opción seleccionada en menuAcciones().
     * @param tipoMiembro String con el tipo de miembro a modificar.
     */
    private static void menuModificar(String tipoMiembro)
    {
        System.out.println("\n=== Mantenimiento de "+ tipoMiembro +". " +
                "Modificar datos de "+ tipoMiembro +" existente ===\n");
        System.out.println("¿De qué "+ tipoMiembro +" quieres hacer cambios?\n");
    }

    /**
     * Función.
     * Se solicitan los datos necesarios para contruir un Acompanante.
     * El dato de Jugador no se introduce manualmente, se selecciona en menuAcciones().
     * @param jugador Jugador que se asignará al acompañante.
     * @return Acompanante construido con los datos del usuario.
     */
    private static Acompanante agregarAcompanante(Jugador jugador)
    {
        FuncionesComunes.key.nextLine();
        System.out.println("\n=== Mantenimiento de jugadores. Agregar acompañante ===\n");
        System.out.print("Nombre: ");
        String nombre = FuncionesComunes.solicitarString();
        System.out.print("Edad: ");
        int edad = (int) FuncionesComunes.solicitudNumero();
        FuncionesComunes.key.nextLine();
        System.out.print("Parentesco: ");
        String parentesco = FuncionesComunes.solicitarString();

        Acompanante acompanante = new Acompanante(nombre, edad, jugador, parentesco);

        //Si ya está presente en la lista, se lanza una excepción.
        if(miembrosClub.contains(acompanante)) throw new AcompanteDuplicadoException();

        return acompanante;
    }

    /**
     * Función.
     * Se solicitan los datos necesarios para construir un Jugador.
     * @return Jugador construido con los datos del usuario.
     */
    private static Jugador anyadirJugador()
    {
        System.out.println("\n=== Mantenimiento de jugador. Añadir jugador nuevo ===\n");
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

    /**
     * Función.
     * Se solicitan los datos necesarios para construir un Entrenador.
     * @return Entrenador construido con los datos del usuario.
     */
    private static Entrenador anyadirEntrenador()
    {
        System.out.println("\n=== Mantenimiento de entrenador. Añadir entrenador nuevo ===\n");
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

    /**
     * Función.
     * Solicita al usuario todos los datos necesarios para construir un Masajista.
     * @return Masajista con datos introducidos.
     */
    private static Masajista anyadirMasajista()
    {
        System.out.println("\n=== Mantenimiento de masajista. Añadir masajista nuevo ===\n");
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

        //Se comprueba que no exista previemente en la lista, lanzando una excepción en caso afirmativo.
        if(miembrosClub.contains(masajista)) throw new MasajistaDuplicadoException();

        return masajista;
    }

    /**
     * Procedimiento.
     * Muestra las opciones de menuAcciones dependiendo de lo seleccionado en menuPrincipal
     * @param tipoMiembro String dado por menuPrincipal() para modificar el menu.
     */
    private static void mostrarMenuAcciones(String tipoMiembro)
    {
        System.out.println("\n=== Mantenimiento de "+ tipoMiembro +" ===\n");
        System.out.println("\t[1]. Añadir nuevo "+ tipoMiembro);
        System.out.println("\t[2]. Modificar datos de "+ tipoMiembro +" existente");
        if(tipoMiembro.equals("jugador"))
            System.out.println("\t[3]. Crear acompañantes (sólo seniors)");
        System.out.println("\t[X]. Volver al menú principal");
        System.out.println("===========================================================================");
        System.out.print("\nSeleciona una opción --> ");
    }

    /**
     * Procedimiento.
     * Está contenido en un do_while, al igual que menuPrincipal().
     * Contiene un switch para selecionar una opción: Agrenar, Modificar, Agregar acompañante (solo si en menuPrincipal() se
     * ha seleccionado la opción de jugador) y Salir. Esta última devuelve a menuPrincipal().
     * No se han filtrado los datos, con excepción de los que ya habían presentes en FuncionesComunes. No es necesario dado a
     * la implementación de try_catch en todos los llamamientos.
     * Dentro de las opciones de añadir o modificar un miembro se desglosan sendos switch. El exterior sirve para seleccionar
     * entre las opciones previamente dichas, mientras que los interiores son para discernir entre los tipos de objetos (Jugador,
     * Entrenador, Masajista). Cada uno de estos requiere una función individual para solicitar o modificar datos.
     * @param tipoMiembro String dado por menuPrincipal() para modificar el funcionamiento y opciones disponibles.
     */
    private static void menuAcciones(String tipoMiembro)
    {
        boolean vuelta = true;
        do
        {
            mostrarMenuAcciones(tipoMiembro);
            switch(FuncionesComunes.solicitudChar())
            {
                case '1':   //Agregar miembro del club
                    switch (tipoMiembro)
                    {
                        case "jugador":
                            try
                            {
                                //Los try_catch están todos localizados al inicio de las funciones. Si se da el caso de error, no se llegaría
                                //ni a modificar ni a añadir el objeto problemático.
                                miembrosClub.add(anyadirJugador());
                            }
                            catch(DorsalDuplicadoExcepcion e)
                            {
                                System.out.println("No se pudo añadir al jugador. El dorsal está duplicado.");
                            }
                            catch(IllegalArgumentException e)   //Los catch anidados me permiten controlar diversas excepciones en un solo try. Lo usaba mucho en C#.
                            {
                                System.out.println("No se pudo añadir al jugador. La categoría no es válido.");
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
                                System.out.println("No se pude añadir al masajista. Ya está presente en el club.");
                            }
                            break;
                    }
                    break;

                case '2':   //Modificar miembro del club
                    menuModificar(tipoMiembro);
                    switch (tipoMiembro)
                    {
                        case "jugador":
                            //Las funciones para mostrar miembros de MuxtamelFC por tipo de objeto devuelve un
                            //ArrayList filtrado para poder seleccionar uno específico por su posición en la lista.
                            ArrayList<Jugador> listaJugadores = mostrarJugador(false);  //El booleano es para deshabilitar la función de seleccionar únicamente a los SENIORS
                            System.out.println("\n=====================================================\n");

                            if(listaJugadores.isEmpty()) System.out.println("No hay jugadores en el club.");
                            else
                            {
                                try
                                {
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
                            }
                            break;

                        case "entrenador":
                            ArrayList<Entrenador> listaEntrendor = mostrarEntrenador();
                            System.out.println("\n=====================================================\n");

                            if(listaEntrendor.isEmpty()) System.out.println("No hay entrenadores en el club.");
                            else
                            {
                                try
                                {
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
                            }
                            break;

                        case "masajista":
                            ArrayList<Masajista> listaMasajistas = mostrarMasajista();
                            System.out.println("\n=====================================================\n");

                            if(listaMasajistas.isEmpty()) System.out.println("No hay masajistas en el club.");
                            else
                            {
                                System.out.print("Selecciona una opción --> ");
                                try
                                {
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
                            }
                            break;
                    }
                    break;

                case 'X':
                case 'x':   //Volver al menú principal
                    System.out.println("Volviendo al menú principal.");
                    vuelta = false;
                    break;

                case '3':   //Agregar acompañante (solo si se ha seleccionado la 1ª opción en el menú principal)
                    //Si el usuario introduce '3' pero no seleccinó la 1ª opción en menuPrincipal(), el if no se cumplirá. Al ser él
                    //el que contiene todas las funciones, incluido el break, accederá al default y se tratará como una opción inválida.
                    if(tipoMiembro.equals("jugador"))
                    {
                        System.out.println("=== Mantenimiento de jugadores. Agregar acompañante ===\n");
                        System.out.println("¿A qué jugador le quieres añadir un acompañante?\n");
                        ArrayList<Jugador> listaSeniors = mostrarJugador(true); //mostrarJugadores() recibe true para que devuelva una lista de todos los jugadores que son SENIORS.
                        System.out.println("\n=====================================================\n");

                        if(listaSeniors.isEmpty()) System.out.println("No hay jugadores en el club.");
                        else
                        {
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
                        }
                        break;
                    }

                default:
                    System.out.println("ERROR\nOpción inválida.");
                    break;
            }
        }while(vuelta);
    }

    /**
     * Procecimiento.
     * Muestra al usuario un menu con las posibles listas a mostrar.
     */
    private static void equiposMutxamel()
    {
        System.out.println("\n=== Consultar equipos ===\n");
        System.out.println("¿Qué equipo quieres ver en detalle?\n");
        for(Equipos equipo : Equipos.values()) System.out.println("\t--> "+ equipo);
        System.out.println("\t--> Masajistas");
        System.out.println("\t--> Acompañantes");
        System.out.println("\n===============================\n");
        System.out.print("Seleciona una opción --> ");
    }

    /**
     * Procedimiento.
     * Imprime una lista de objetos de miembrosClub filtrados por la opción seleccionada por el usuario de las mostradas en equiposMutxamel().
     * @param opcion String con la lista que el usuario desea ver.
     */
    private static void mostrarEquipos(String opcion)
    {
        System.out.print("\n=== Consultar equipos. ");

        //Las listas de masajistas y acomañantes no son valores de Equipos, por lo que se deben de comprobar los primeros con if_else.
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
        else //No hace falta filtrar si la opción contiene un Equipo válido, puesto que si no lo es saltará un error el cual el try_catch del menuPrincipal detectará.
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

    /**
     * Procedimiento.
     * Muestra las opciones disponibles para el menuPrincipal()
     */
    private static void mostrarMenuPrincipal()
    {
        System.out.println("\n=== App de mantenimiento del MUTXAMEL FC ===\n");
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

    /**
     * Procedimiento.
     * Contiene un switch para invocar los métodos pertinentes dependiendo de la opción del usuario.
     * Está contenido en un bucle que solo se rompe si se introduce 'X' ó 'x'.
     */
    public static void menuPrincipal()
    {
        boolean vuelta = true;
        do
        {
            mostrarMenuPrincipal();
            switch (FuncionesComunes.solicitudChar())
            {
                case '1':
                    //El String que se envía sirve para alterar el comportamiento de menuAcciones().
                    //Así evito tener que crear un menú individual para cada opción.
                    menuAcciones("jugador");
                    break;

                case '2':
                    menuAcciones("entrenador");
                    break;

                case '3':
                    menuAcciones("masajista");
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
                case 'x':
                    vuelta = false;
                    break;

                default:
                    System.out.println("ERROR\nOpción inválida.");
                    break;
            }
        }while(vuelta);
    }

    /**
     * Procedimiento.
     * Inicializa con datos por defecto el ArrayList miembrosClub.
     * Este método es completamente opcional y existe para poder testear el programa con datos ya introducidos.
     */
    public static void inicializarClub()
    {
        Jugador j1 = new Jugador("Paco", 24, Equipos.SENIOR, 8, Posiciones.DEFENSA);
        Jugador j2 = new Jugador("Gregorio", 28, Equipos.SENIOR, 7, Posiciones.CENTROCAMPISTA);
        Jugador j3 = new Jugador("Pascual", 20, Equipos.SENIOR, 6, Posiciones.PORTERO);

        Entrenador entrenador = new Entrenador("Cristina", 42, Equipos.SENIOR, "4-5-7");

        Masajista masaj1 = new Masajista("Pere", 32, "Masajista pro", 11);
        Masajista masaj2 = new Masajista("Luisa", 22, "Masajista fesional", 2);

        Acompanante acom1 = new Acompanante("Mariano", 65, j3, "padre");
        Acompanante acom2 = new Acompanante("Eugenio", 63, j3, "padre");
        Acompanante acom3 = new Acompanante("Paula", 28, j1, "pareja");
        Acompanante acom4 = new Acompanante("Juan", 4, j2, "hijo");

        miembrosClub.add(j1);
        miembrosClub.add(j2);
        miembrosClub.add(j3);
        miembrosClub.add(entrenador);
        miembrosClub.add(masaj1);
        miembrosClub.add(masaj2);
        miembrosClub.add(acom1);
        miembrosClub.add(acom2);
        miembrosClub.add(acom3);
        miembrosClub.add(acom4);
    }
}
