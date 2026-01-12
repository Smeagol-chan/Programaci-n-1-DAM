package org.example.recursividad;
import org.example.FuncionesComunes;

import java.io.IOException;

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
                System.out.println("Introduzca un número:");
                int num = FuncionesComunes.solicitudPositivosInt();
                System.out.println(num +" tiene "+ EjerciciosRecursivos.digitos(num) +" dígitos.");
                FuncionesComunes.key.nextLine();
                break;

            case 2:
                System.out.println("Introduzca la base:");
                int base = FuncionesComunes.solicitudInt();
                System.out.println("Introduzca el exponente:");
                int exp = FuncionesComunes.solicitudPositivosInt();
                System.out.println(base +"^"+ exp +" = "+ EjerciciosRecursivos.potencias(base, exp));
                FuncionesComunes.key.nextLine();
                break;

            case 3:
                System.out.println("Introduzca un número:");
                EjerciciosRecursivos.invertirNum(FuncionesComunes.solicitudInt());
                FuncionesComunes.key.nextLine();
                System.out.println("\nIntroduzca una frase:");
                char[] frase = FuncionesComunes.separarLetrasString();
                EjerciciosRecursivos.invertirFrase(frase, frase.length-1, 0);
                System.out.println();
//                Esto es lo que pide, pero con CharAt es bastante mejor.
                break;

            case 4:
                System.out.println("Introduzca un número:");
                System.out.println((EjerciciosRecursivos.comprobarBinario(FuncionesComunes.solicitudPositivosInt()) ? "Sí" : "No") +" es binario.");
                FuncionesComunes.key.nextLine();
                break;

            case 5:
                System.out.println("Introduzca un número:");
                String binario = EjerciciosRecursivos.convertirBinario(FuncionesComunes.solicitudPositivosInt());
                System.out.println(binario);
                FuncionesComunes.key.nextLine();
                break;

            case 6:
                FuncionesComunes.key.nextLine();
                System.out.println("Introduzca una frase:");
                String fraseComprobar = FuncionesComunes.solicitarString();
                fraseComprobar = fraseComprobar.replace(" ", "").toLowerCase();
                System.out.println((EjerciciosRecursivos.fraseOrdenada(fraseComprobar, 0) ? "Sí" : "No") +" está ordenada.");
                break;

            case 7:
                System.out.println("Introduzca un número:");
                String suma = EjerciciosRecursivos.calculoSuma(FuncionesComunes.solicitudPositivosInt());
                System.out.println(suma);
                FuncionesComunes.key.nextLine();
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

    static void main() throws IOException, InterruptedException {
        final char[] LETRAS_REINICIO = {'X', 'M'};
        do
        {
            FuncionesComunes.limpiarConsola();
            mostrarMenu();
            eleccionMenu();
            mostrarVuelta();
        }while(FuncionesComunes.filtroChar(LETRAS_REINICIO.clone()) == 'M');
    }
}
