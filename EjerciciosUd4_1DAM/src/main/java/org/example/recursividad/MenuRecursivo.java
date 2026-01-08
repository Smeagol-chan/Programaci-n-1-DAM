package org.example.recursividad;

import org.example.FuncionesComunes;

public class MenuRecursivo
{
    private static void mostrarMenu()
    {
        System.out.println("*** Batería de ejercicios sobre recursividad ***");
        System.out.println("Selecciona a continuación el modo que quieras ejecutar...");
        System.out.println("1 - Dígitos");
        System.out.println("2 - Potencias");
        System.out.println("3 - Del revés");
        System.out.println("4 - Binario");
        System.out.println("5 - A binario");
        System.out.println("6 - Orden alfabético");
        System.out.println("7 - Mostrar suma");
    }

    private static void eleccionMenu()
    {
        switch(FuncionesComunes.filtroLimitesInt(1, 7))
        {
            case 1:
                int num = FuncionesComunes.solicitudIntpositivos();
                System.out.println(num +" tiene "+ Ej1.digitos(num) +" dígitos.");
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            default:
                System.out.println("ERROR");
                break;
        }
    }

    private static void mostrarVuelta()
    {
        System.out.println("\nElige una opción:");
        System.out.println("\t[M] - Volver al menú principal");
        System.out.println("\t[X] - Salir");
    }

    static void main()
    {
        final char[] LETRAS_REINICIO = {'X', 'M'};
        do
        {
            mostrarMenu();
            eleccionMenu();
            mostrarVuelta();
        }while(FuncionesComunes.filtroChar(LETRAS_REINICIO.clone()) == 'M');
    }
}
