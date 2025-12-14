package org.example.proyecto_1er_trimestre;
import org.example.FuncionesComunes;

public class EscapandoImperiales_432
{
    private static final String ENTRADA = "S", SALIDA = "F", ASTEROIDE = "*", CAMINO = ".";

    public static boolean filtroMapa(String f, boolean[] haySF, int[] coorS, int y, int x)
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
                    haySF[2] = true;
                    coorS[0] = y;
                    coorS[1] = x;
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
                    haySF[3] = true;
                }
                break;

            default:
                System.out.println("ERROR\nSolo se puede introducir: "+ CAMINO +" "+ ASTEROIDE +" "+ ENTRADA +" "+ SALIDA +"\n");
                return true;
        }
        return false;
    }

    public static String[][] solicitudMapa(String[][] mapa, int altura, int anchura, int[] coordenadasS)
    {
        boolean[] haySF = new boolean[4];
        String[] fila;

        fuera:
        for(int i = 0; i < altura; i++)
        {
            fila = FuncionesComunes.key.nextLine().split("");

            if(fila.length == anchura)
            {
                haySF[2] = false;
                haySF[3] = false;
                for(int j = 0; j < anchura; j++)
                {
                    if(filtroMapa(fila[j], haySF, coordenadasS, i, j))
                    {
                        i--;
                        if(haySF[2])
                        {
                            haySF[0] = false;
                        }
                        if(haySF[3])
                        {
                            haySF[1] = false;
                        }
                        continue fuera;
                    }
                    else
                    {
                        mapa[i][j] = fila[j];
                    }
                }
            }
            else
            {
                System.out.println("ERROR\nCada fila del mapa ha de contener "+ anchura +" carácteres.\n");
                i--;
            }
        }
        return mapa;
    }

    public static boolean recorridoViable(String[][] mapa, int[] coordenadasActuales, int altura, int anchura)
    {
        boolean haySalida = false, avanzarUnaPosicion;
        boolean[] derecha_abajo_izquierda_arriba = new boolean[4];
        int cantidadRutas;

        if(coordenadasActuales[0] == -1) return false;
        do
        {
            mapa[coordenadasActuales[0]][coordenadasActuales[1]] = ASTEROIDE;
            for (int i = 0; i < 4; i++) derecha_abajo_izquierda_arriba[i] = false;
            cantidadRutas = 0;
            avanzarUnaPosicion = false;
            if(coordenadasActuales[1]+1 < anchura)
            {
                if(mapa[coordenadasActuales[0]][coordenadasActuales[1]+1].contains(SALIDA)) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]][coordenadasActuales[1]+1].contains(CAMINO))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[0] = true;
                    }
                }
            }
            if(coordenadasActuales[0]+1 < altura)
            {
                if(mapa[coordenadasActuales[0]+1][coordenadasActuales[1]].contains(SALIDA)) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]+1][coordenadasActuales[1]].contains(CAMINO))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[1] = true;
                    }
                }
            }
            if(!FuncionesComunes.negativoInt(coordenadasActuales[1]-1))
            {
                if(mapa[coordenadasActuales[0]][coordenadasActuales[1]-1].contains(SALIDA)) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]][coordenadasActuales[1]-1].contains(CAMINO))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[2] = true;
                    }
                }
            }
            if(!FuncionesComunes.negativoInt(coordenadasActuales[0]-1))
            {
                if(mapa[coordenadasActuales[0]-1][coordenadasActuales[1]].contains(SALIDA)) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]-1][coordenadasActuales[1]].contains(CAMINO))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[3] = true;
                    }
                }
            }
            if(cantidadRutas == 1)
            {
                cantidadRutas = 0;
                while(!derecha_abajo_izquierda_arriba[cantidadRutas]) cantidadRutas++;

                switch(cantidadRutas)
                {
                    case 0:
                        coordenadasActuales[1] += 1;
                        break;

                    case 1:
                        coordenadasActuales[0] += 1;
                        break;

                    case 2:
                        coordenadasActuales[1] -= 1;
                        break;

                    case 3:
                        coordenadasActuales[0] -= 1;
                        break;
                }
                avanzarUnaPosicion = true;
            }
            else if(cantidadRutas > 1)
            {
                if(derecha_abajo_izquierda_arriba[0])
                {
                    coordenadasActuales[1] += 1;
                    haySalida = recorridoViable(mapa.clone(), coordenadasActuales.clone(), altura, anchura);
                    coordenadasActuales[1] -= 1;
                }
                if(!haySalida && derecha_abajo_izquierda_arriba[1])
                {
                    coordenadasActuales[0] += 1;
                    haySalida = recorridoViable(mapa.clone(), coordenadasActuales.clone(), altura, anchura);
                    coordenadasActuales[0] -= 1;
                }
                if(!haySalida && derecha_abajo_izquierda_arriba[2])
                {
                    coordenadasActuales[1] -= 1;
                    haySalida = recorridoViable(mapa.clone(), coordenadasActuales.clone(), altura, anchura);
                    coordenadasActuales[1] += 1;
                }
                if(!haySalida && derecha_abajo_izquierda_arriba[3])
                {
                    coordenadasActuales[0] -= 1;
                    haySalida = recorridoViable(mapa.clone(), coordenadasActuales.clone(), altura, anchura);
                    coordenadasActuales[0] += 1;
                }
            }
        }while(avanzarUnaPosicion);

        return haySalida;
    }

    public static boolean finalizarPrograma(int[] coorS)
    {
        coorS[0] = -1;
        return FuncionesComunes.key.hasNext();
    }

    static void main()
    {
        final int TAM_MIN = 1, TAM_MAX = 20;
        int[] coordenadasS = new int[2];
        int altura, anchura;

        System.out.println("\t>>> CARGANDO MAPA DE ASTEROIDES <<<");

        while(true)
        {
            System.out.print("Introduzca el alto y el ancho del mapa: ");
            if(!finalizarPrograma(coordenadasS)) break;

            altura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
            anchura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
            FuncionesComunes.key.nextLine();

            String[][] mapa = new String[altura][anchura];

            System.out.println("\nRellena el contenido del mapa:");
            mapa = solicitudMapa(mapa.clone(), altura, anchura, coordenadasS).clone();

            System.out.println("Ruta viable: "+ (recorridoViable(mapa.clone(), coordenadasS.clone(), altura, anchura) ? "SÍ" : "NO") +"\n");
        }
    }
}