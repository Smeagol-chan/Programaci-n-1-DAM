package org.example.excepciones.cajero_automatico;

import org.example.FuncionesComunes;

import java.util.Arrays;

public class CajeroApp
{
    static final char CONSULTAR = '1';
    static final char INGRESAR = '2';
    static final char RETIRAR = '3';
    static final char SALIR = 'X';

    static CuentaBancaria cuentaBancaria = new CuentaBancaria();

    static void menu()
    {
        System.out.println("\n\n=== Cajero Automático ===");
        System.out.println("\t[1]. Consultar saldo");
        System.out.println("\t[2]. Ingresar dinero");
        System.out.println("\t[3]. Retirar dinero");
        System.out.println("\t[X]. Salir");
        System.out.print("\n\tSelecione una opción: ");
    }

    static double solicitarImporte()
    {
        System.out.print("Introduzca el importe: ");
        return FuncionesComunes.solicitudPositivosNumero();
    }

    static boolean seleccionarOpcion(char opcion)
    {
        switch(opcion)
        {
            case CONSULTAR:
                cuentaBancaria.consultarSaldo();
                return true;

            case INGRESAR:
                cuentaBancaria.ingresarDinero(solicitarImporte());
                FuncionesComunes.key.nextLine();
                return true;

            case RETIRAR:
                cuentaBancaria.retirarDinero(solicitarImporte());
                FuncionesComunes.key.nextLine();
                return true;

            default:
                System.out.println("\n=== Fin del programa ===");
                return false;

        }
    }

    static void main()
    {
        do
        {
            menu();
        }while(seleccionarOpcion(FuncionesComunes.filtroChar(new char[] {CONSULTAR, INGRESAR, RETIRAR, SALIR})));
    }
}
