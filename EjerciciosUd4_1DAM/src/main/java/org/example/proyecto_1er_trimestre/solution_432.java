import java.util.Scanner;

public class solution_432
{
    static Scanner key = new Scanner(System.in);

    private static boolean recorridoViable(String[][] m, int[] coorAct, int h, int w)
    {
        boolean salida = false;
        m[coorAct[0]][coorAct[1]] = "*";

        if(coorAct[1]+1 < w)
        {
            if(m[coorAct[0]][coorAct[1]+1].contains("F")) salida = true;
            else
            {
                if(m[coorAct[0]][coorAct[1]+1].contains("."))
                {
                    coorAct[1] += 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[1] -= 1;
                }
            }
        }
        if(!salida && coorAct[0]+1 < h)
        {
            if(m[coorAct[coorAct[0]+1]][0].contains("F")) salida = true;
            else
            {
                if(m[coorAct[coorAct[0]+1]][0].contains("."))
                {
                    coorAct[0] += 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[0] -= 1;
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
                    coorAct[1] -= 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[1] += 1;
                }
            }
        }
        if(!salida && coorAct[0]-1 >= 0)
        {
            if(m[coorAct[coorAct[0]-1]][0].contains("F")) salida = true;
            else
            {
                if(m[coorAct[coorAct[0]-1]][0].contains("."))
                {
                    coorAct[0] -= 1;
                    salida = recorridoViable(m.clone(), coorAct.clone(), h, w);
                    coorAct[0] += 1;
                }
            }
        }
        return salida;
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

            for (int i = 0; i < h; i++)
            {
                String[] fila = key.nextLine().split("");
                for (int j = 0; j < w; j++)
                {
                    m[i][j] = fila[j];
                    if(fila[j].contains("S"))
                    {
                        coorS[0] = i;
                        coorS[1] = j;
                    }
                }
            }
            System.out.println(recorridoViable(m.clone(), coorS.clone(), h, w) ? "SÍ" : "NO");
            return true;
        }
    }

    public static void main(String[] args)
    {
        while (casoDePrueba());
    }
}
