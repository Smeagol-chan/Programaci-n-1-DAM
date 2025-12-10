package org.example.proyecto_1er_trimestre;
import org.example.FuncionesComunes;

public class EscapandoImperiales_432
{
    private static final String ENTRADA = "S", SALIDA = "F", ASTEROIDE = "*", CAMINO = ".";

    public static boolean filtroMapa(String f, boolean[] haySF, int[] cS, int h, int w)
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

    public static String[][] solicitudMapa(String[][] m, int height, int width, int[] coorS)
    {
        boolean[] haySF = {false, false};
        String[] fila;

        fuera:
        for(int i = 0; i < height; i++)
        {
            fila = FuncionesComunes.key.nextLine().split("");

            if(fila.length == width)
            {
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
            }
            else
            {
                System.out.println("ERROR\nCada fila del mapa ha de contener "+ width +" carácteres.\n");
                i--;
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

    public static boolean recorridoViable(String[][] m, int[] coorAct, int altura, int anchura)
    {
        boolean salida, vuelta;
        boolean[] eswn = new boolean[4];
        int cruces;

        do
        {
            salida = false;
            m[coorAct[0]][coorAct[1]] = ASTEROIDE;
            for (int i = 0; i < 4; i++) eswn[i] = false;
            cruces = 0;
            vuelta = false;
            if(coorAct[1]+1 < anchura)
            {
                if(m[coorAct[0]][coorAct[1]+1].contains(SALIDA)) salida = true;
                else
                {
                    if(m[coorAct[0]][coorAct[1]+1].contains(CAMINO))
                    {
                        cruces++;
                        eswn[0] = true;
                    }
                }
            }
            if(!salida && coorAct[0]+1 < altura)
            {
                if(m[coorAct[coorAct[0]+1]][0].contains(SALIDA)) salida = true;
                else
                {
                    if(m[coorAct[coorAct[0]+1]][0].contains(CAMINO))
                    {
                        cruces++;
                        eswn[1] = true;
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
                        cruces++;
                        eswn[2] = true;
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
                        cruces++;
                        eswn[3] = true;
                    }
                }
            }
            if(!salida)
            {
                if(cruces == 1)
                {
                    cruces = 0;
                    while(!eswn[cruces]) cruces++;

                    switch(cruces)
                    {
                        case 0:
                            coorAct[1] += 1;
                            break;

                        case 1:
                            coorAct[0] += 1;
                            break;

                        case 2:
                            coorAct[1] -= 1;
                            break;

                        case 3:
                            coorAct[0] -= 1;
                            break;
                    }
                    vuelta = true;
                }
                else if(cruces > 1)
                {
                    if(eswn[0])
                    {
                        coorAct[1] += 1;
                        salida = recorridoViable(m.clone(), coorAct.clone(), altura, anchura);
                        coorAct[1] -= 1;
                    }
                    if(eswn[1])
                    {
                        coorAct[0] += 1;
                        salida = recorridoViable(m.clone(), coorAct.clone(), altura, anchura);
                        coorAct[0] -= 1;
                    }
                    if(eswn[2])
                    {
                        coorAct[1] -= 1;
                        salida = recorridoViable(m.clone(), coorAct.clone(), altura, anchura);
                        coorAct[1] += 1;
                    }
                    if(eswn[3])
                    {
                        coorAct[0] -= 1;
                        salida = recorridoViable(m.clone(), coorAct.clone(), altura, anchura);
                        coorAct[0] += 1;
                    }
                }
            }
        }while(vuelta);

        return salida;
    }

    public static boolean nuevoMapa(int a, int b)
    {
        return a == b;
    }

    static void main()
    {
        final int TAM_MIN = 0, TAM_MAX = 20;
        int[] coordenadasS = new int[2];
        int altura, anchura;
        boolean vuelta;

        System.out.println("\t>>> CARGANDO MAPA DE ASTEROIDES <<<");

        do
        {
            vuelta = true;

            System.out.print("Introduzca el alto y el ancho del mapa: ");
            altura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
            anchura = FuncionesComunes.filtroLimitesInt(TAM_MIN, TAM_MAX);
            FuncionesComunes.key.nextLine();

            if(nuevoMapa(TAM_MIN, altura) || nuevoMapa(TAM_MIN, anchura)) vuelta = false;
            if(vuelta)
            {
                String[][] mapa = new String[altura][anchura];

                System.out.println("\nRellena el contenido del mapa:");
                mapa = solicitudMapa(mapa.clone(), altura, anchura, coordenadasS).clone();

                System.out.println("Ruta viable: "+ (recorridoViable(mapa.clone(), coordenadasS.clone(), altura, anchura) ? "SÍ" : "NO") +"\n");
            }
        }while(vuelta);
    }
}
