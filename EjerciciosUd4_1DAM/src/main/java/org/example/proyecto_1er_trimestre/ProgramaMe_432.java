package org.example.proyecto_1er_trimestre;
import org.example.FuncionesComunes;

public class ProgramaMe_432
{
    private static final String ENTRADA = "S", SALIDA = "F", ASTEROIDE = "*", CAMINO = ".";

    private static boolean filtroMapa(String f, boolean[] haySF, int[] cS, int h, int w)
    {
        switch(f)
        {
            case CAMINO:
            case ASTEROIDE:
                break;

            case ENTRADA:
                if(haySF[0])
                {
                    System.out.println("ERROR\nNo pueden haber más de una "+ ENTRADA +".\n");
                    return true;
                }
                else
                {
                    haySF[0] = true;
                    cS[0] = h;
                    cS[1] = w;
                }
                break;

            case SALIDA:
                if(haySF[1])
                {
                    System.out.println("ERROR\nNo pueden haber más de una "+ SALIDA +".\n");
                    return true;
                }
                else
                {
                    haySF[1] = true;
                }
                break;

            default:
                System.out.println("ERROR\nSolo se puede introducir: "+ CAMINO +" "+ ASTEROIDE +" "+ ENTRADA +" "+ SALIDA +"\n");
                return true;
        }
        return false;
    }

    private static String[][] solicitudMapa(String[][] m, int height, int width, int[] coorS)
    {
        boolean[] haySF = {false, false};
        String[] fila;

        fuera:
        for(int i = 0; i < height; i++)
        {
            fila = FuncionesComunes.key.nextLine().split("");

            for(int j = 0; j < width; j++)
            {
                if(filtroMapa(fila[j], haySF, coorS, i, j))
                {
                    i--;
                    continue fuera;
                }
                else
                {
                    m[i][j] = fila[j];
                }
            }
            if(i == height-1)
            {
                if(!haySF[0] || !haySF[1])
                {
                    System.out.println("ERROR\nEl mapa debe contener una entrada ("+ ENTRADA +") y una salida ("+ SALIDA +").\n");
                    i--;
                }
            }
        }
        return m;
    }

    private static boolean recorridoViable(String[][] m, int[] coorAct, int h, int w)
    {
        boolean salida = false;
        m[coorAct[0]][coorAct[1]] = ASTEROIDE;

        if(coorAct[1]+1 < w)
        {
            if(m[coorAct[0]][coorAct[1]+1].contains(SALIDA)) salida = true;
            else
            {
                if(m[coorAct[0]][coorAct[1]+1].contains(CAMINO))
                {
                    coorAct[1] += 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[1] -= 1;
                }
            }
        }
        if(!salida && coorAct[0]+1 < h)
        {
            if(m[coorAct[coorAct[0]+1]][0].contains(SALIDA)) salida = true;
            else
            {
                if(m[coorAct[coorAct[0]+1]][0].contains(CAMINO))
                {
                    coorAct[0] += 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[0] -= 1;
                }
            }
        }
        if(!salida && !FuncionesComunes.negativoInt(coorAct[1]-1))
        {
            if(m[coorAct[0]][coorAct[1]-1].contains(SALIDA)) salida = true;
            else
            {
                if(m[coorAct[0]][coorAct[1]-1].contains(CAMINO))
                {
                    coorAct[1] -= 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[1] += 1;
                }
            }
        }
        if(!salida && !FuncionesComunes.negativoInt(coorAct[0]-1))
        {
            if(m[coorAct[coorAct[0]-1]][0].contains(SALIDA)) salida = true;
            else
            {
                if(m[coorAct[coorAct[0]-1]][0].contains(CAMINO))
                {
                    coorAct[0] -= 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[0] += 1;
                }
            }
        }
        return salida;
    }

    static void main()
    {
        final int TAM_MIN = 1, TAM_MAX = 20;
        int[] coordenadasS = new int[2];
        int altura, anchura;

        System.out.println("\t>>> CARGANDO MAPA DE ASTEROIDES <<<\nIntroduzca el alto y el ancho del mapa:");
        altura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
        anchura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
        FuncionesComunes.key.nextLine();

        String[][] mapa = new String[altura][anchura];

        System.out.println("\nRellena el contenido del mapa:");
        mapa = solicitudMapa(mapa.clone(), altura, anchura, coordenadasS).clone();

        System.out.println("Ruta viable: "+ (recorridoViable(mapa.clone(), coordenadasS.clone(), altura, anchura) ? "SÍ" : "NO") +"\n");
    }
}
