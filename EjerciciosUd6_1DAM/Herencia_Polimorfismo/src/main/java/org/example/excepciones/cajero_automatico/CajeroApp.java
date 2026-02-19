package org.example.excepciones.cajero_automatico;

import org.example.FuncionesComunes;

public class CajeroApp
{
    static final char CONSULTAR = '1';
    static final char INGRESAR = '2';
    static final char RETIRAR = '3';
    static final char SALIR = 'X';
    static final char[] OPCIONES_MENU = {CONSULTAR, INGRESAR, RETIRAR, SALIR};

    static void menu()
    {
        System.out.println("=== Cajero Automático ===");
        System.out.println("\t[1]. Consultar saldo");
        System.out.println("\t[2]. Ingresar dinero");
        System.out.println("\t[3]. Retirar dinero");
        System.out.println("\t[X]. Salir");
        System.out.print("\n\tSelecione una opción: ");
    }

    static boolean seleccionarOpcion(char opcion)
    {
        switch ()
        {

        }
    }

    static void main()
    {
        CuentaBancaria cuenta = new CuentaBancaria();
        do
        {
            menu();
        }while(seleccionarOpcion(FuncionesComunes.filtroChar(OPCIONES_MENU)));
    }
}
