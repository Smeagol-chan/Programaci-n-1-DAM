package org.example.proyecto_1er_trimestre;
import java.util.Scanner;

public class solution_432
{
    static Scanner key = new Scanner(System.in);

    public static boolean recorridoViable(String[][] mapa, int[] coordenadasActuales, int altura, int anchura)
    {
        boolean haySalida = false, avanzarUnaPosicion;
        boolean[] derecha_abajo_izquierda_arriba = new boolean[4];
        int cantidadRutas;
        if(coordenadasActuales[0] == -1) return false;
        do
        {
            cantidadRutas = 0;
            avanzarUnaPosicion = false;

            mapa[coordenadasActuales[0]][coordenadasActuales[1]] = "*";
            for (int i = 0; i < 4; i++) derecha_abajo_izquierda_arriba[i] = false;
            if(coordenadasActuales[1]+1 < anchura)
            {
                if(mapa[coordenadasActuales[0]][coordenadasActuales[1]+1].contains("F")) haySalida = true;
                else
                {
                    if(mapa[coordenadasActuales[0]][coordenadasActuales[1]+1].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[0] = true;
                    }
                }
            }
            if(!haySalida && coordenadasActuales[0]+1 < altura)
            {
                if(mapa[coordenadasActuales[0]+1][coordenadasActuales[1]].contains("F")) haySalida = true;
                else
                {
                    if(mapa[coordenadasActuales[0]+1][coordenadasActuales[1]].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[1] = true;
                    }
                }
            }
            if(!haySalida && coordenadasActuales[1]-1 >= 0)
            {
                if(mapa[coordenadasActuales[0]][coordenadasActuales[1]-1].contains("F")) haySalida = true;
                else
                {
                    if(mapa[coordenadasActuales[0]][coordenadasActuales[1]-1].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[2] = true;
                    }
                }
            }
            if(!haySalida && coordenadasActuales[0]-1 >= 0)
            {
                if(mapa[coordenadasActuales[0]-1][coordenadasActuales[1]].contains("F")) haySalida = true;
                else
                {
                    if(mapa[coordenadasActuales[0]-1][coordenadasActuales[1]].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[3] = true;
                    }
                }
            }
            if(!haySalida)
            {
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
            }
        }while(avanzarUnaPosicion);

        return haySalida;
    }

    public static String[][] solicitudMapa(String[][] mapa, int altura, int anchura, int[] coordenadasS)
    {
        String[] fila;
        coordenadasS[0] = -1;
        for(int i = 0; i < altura; i++)
        {
            fila = key.nextLine().split("");
            for(int j = 0; j < anchura; j++)
            {
                mapa[i][j] = fila[j];
                if(fila[j].contains("S"))
                {
                    coordenadasS[0] = i;
                    coordenadasS[1] = j;
                }
            }
        }
        return mapa;
    }

    public static boolean casoDePrueba()
    {
        if (!key.hasNext()) return false;
        else
        {
            int altura = key.nextInt();
            int anchura = key.nextInt();
            int[] coordenadasS = new int[2];
            String[][] mapa = new String[altura][anchura];
            key.nextLine();

            mapa = solicitudMapa(mapa.clone(), altura, anchura, coordenadasS).clone();

            System.out.println(recorridoViable(mapa.clone(), coordenadasS.clone(), altura, anchura) ? "SI" : "NO");
            return true;
        }
    }

    public static void main(String[] args)
    {
        while (casoDePrueba());
    }
}
