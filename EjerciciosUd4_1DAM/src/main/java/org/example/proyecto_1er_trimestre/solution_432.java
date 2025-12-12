import java.util.Scanner;

public class solution_432
{
    static Scanner key = new Scanner(System.in);

    public static boolean recorridoViable(String[][] m, int[] coorAct, int altura, int anchura)
    {
        boolean salida = false, vuelta;
        boolean[] eswn = new boolean[4];
        int cruces;

        do
        {
            m[coorAct[0]][coorAct[1]] = "*";
            for (int i = 0; i < 4; i++) eswn[i] = false;
            cruces = 0;
            vuelta = false;
            if(coorAct[1]+1 < anchura)
            {
                if(m[coorAct[0]][coorAct[1]+1].contains("F")) salida = true;
                else
                {
                    if(m[coorAct[0]][coorAct[1]+1].contains("."))
                    {
                        cruces++;
                        eswn[0] = true;
                    }
                }
            }
            if(!salida && coorAct[0]+1 < altura)
            {
                if(m[coorAct[0]+1][coorAct[1]].contains("F")) salida = true;
                else
                {
                    if(m[coorAct[0]+1][coorAct[1]].contains("."))
                    {
                        cruces++;
                        eswn[1] = true;
                    }
                }
            }
            if(!salida && coorAct[1]-1 >= 0)
            {
                if(m[coorAct[0]][coorAct[1]-1].contains("F")) salida = true;
                else
                {
                    if(m[coorAct[0]][coorAct[1]-1].contains("."))
                    {
                        cruces++;
                        eswn[2] = true;
                    }
                }
            }
            if(!salida && coorAct[0]-1 >= 0)
            {
                if(m[coorAct[0]-1][coorAct[1]].contains("F")) salida = true;
                else
                {
                    if(m[coorAct[0]-1][coorAct[1]].contains("."))
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
                    if(!salida && eswn[1])
                    {
                        coorAct[0] += 1;
                        salida = recorridoViable(m.clone(), coorAct.clone(), altura, anchura);
                        coorAct[0] -= 1;
                    }
                    if(!salida && eswn[2])
                    {
                        coorAct[1] -= 1;
                        salida = recorridoViable(m.clone(), coorAct.clone(), altura, anchura);
                        coorAct[1] += 1;
                    }
                    if(!salida && eswn[3])
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

    public static String[][] solicitudMapa(String[][] m, int height, int width, int[] coorS)
    {
        String[] fila;

        for(int i = 0; i < height; i++)
        {
            fila = key.nextLine().split("");
            for(int j = 0; j < width; j++)
            {
                m[i][j] = fila[j];
                if(fila[j].contains("S"))
                {
                    coorS[0] = i;
                    coorS[1] = j;
                }
            }
        }
        return m;
    }

    public static boolean casoDePrueba()
    {
        if (!key.hasNext()) return false;
        else
        {
            int h = key.nextInt();
            int w = key.nextInt();
            int[] coorS = new int[2];
            String[][] m = new String[h][w];
            key.nextLine();

            m = solicitudMapa(m.clone(), h, w, coorS).clone();

            System.out.println(recorridoViable(m.clone(), coorS.clone(), h, w) ? "SÍ" : "NO");
            return true;
        }
    }

    public static void main(String[] args)
    {
        while (casoDePrueba());
    }
}
