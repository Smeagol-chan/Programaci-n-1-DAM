package org.example.ampliacion_modular_seleccion_olimpiadas;

import org.example.FuncionesComunes;

public class Saltos_Mario
{
    private static final int L_INF = 1, L_SUP = 10;
    private static final String SEPARADOR = " ";

    private static int subidas, bajadas;

    private static void saltos(int[] hM)
    {
        subidas = 0;
        bajadas = 0;
        for(int i = 0; i < hM.length-1; i++)
        {
            if(hM[i] > hM[i+1]) bajadas++;
            if(hM[i] < hM[i+1]) subidas++;
        }
    }

    static void main()
    {
        System.out.println("\t>> SALTOS DE MARIO <<\n¿Cuántos muros hay en el escenario?");
        int cantidadMuros = FuncionesComunes.filtroLimitesInt(L_INF, L_SUP);
        FuncionesComunes.key.nextLine();

        System.out.println("¿Cuáles son sus alturas?");
        int[] alturaMuros = FuncionesComunes.solicitudVectorInt(cantidadMuros, SEPARADOR).clone();

        saltos(alturaMuros);
        System.out.println("\n"+ subidas +" "+ bajadas);
    }
}
