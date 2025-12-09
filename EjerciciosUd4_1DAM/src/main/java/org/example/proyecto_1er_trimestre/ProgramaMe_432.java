package org.example.proyecto_1er_trimestre;
import org.example.FuncionesComunes;

public class ProgramaMe_432
{
    private static boolean filtroMapa(String f, boolean[] haySF, int[][] cSF, int h, int w)
    {
        switch(f)
        {
            case ".":
            case "*":
                break;

            case "S":
                if(haySF[0])
                {
                    System.out.println("ERROR\nNo pueden haber más de una S.\n");
                    return true;
                }
                else
                {
                    haySF[0] = true;
                    cSF[0][0] = h;
                    cSF[0][1] = w;
                }
                break;

            case "F":
                if(haySF[1])
                {
                    System.out.println("ERROR\nNo pueden haber más de una F.\n");
                    return true;
                }
                else
                {
                    haySF[1] = true;
                    cSF[1][0] = h;
                    cSF[1][1] = w;
                }
                break;

            default:
                System.out.println("ERROR\nSolo se puede introducir: . * S F\n");
                return true;
        }
        return false;
    }

    private static String[][] solicitudMapa(String[][] m, int height, int width, int[][] coorSF)
    {
        boolean[] haySF = {false, false};
        String[] fila;

        fuera:
        for(int i = 0; i < height; i++)
        {
            fila = FuncionesComunes.key.nextLine().split("");

            for(int j = 0; j < width; j++)
            {
                if(filtroMapa(fila[j], haySF, coorSF, i, j))
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
                    System.out.println("ERROR\nEl mapa debe contener una entrada (S) y una salida (F).\n");
                    i--;
                }
            }
        }
        return m;
    }

    private static boolean recorridoViable(String[][] m, int[][] coorSF, int h, int w)
    {
        if(coorSF[0][1]+1 < w)
        {

        }
    }

    static void main()
    {
        final int TAM_MIN = 1, TAM_MAX = 20;
        int[][] coordenadasSF = new int[2][2];
        int altura, anchura;

        System.out.println("\t>>> CARGANDO MAPA DE ASTEROIDES <<<\nIntroduzca el alto y el ancho del mapa:");
        altura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
        anchura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
        FuncionesComunes.key.nextLine();

        String[][] mapa = new String[altura][anchura];

        System.out.println("\nRellena el contenido del mapa:");
        mapa = solicitudMapa(mapa.clone(), altura, anchura, coordenadasSF).clone();

        System.out.println("Ruta viable: "+ (recorridoViable(mapa.clone(), coordenadasSF.clone(), altura, anchura) ? "SÍ" : "NO") +"\n");
    }
}
