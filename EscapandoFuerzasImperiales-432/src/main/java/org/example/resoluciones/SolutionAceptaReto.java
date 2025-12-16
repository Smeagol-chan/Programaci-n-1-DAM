package org.example.resoluciones;
import java.util.Scanner;

/**
 * Contiene la solución del problema 432 de ProgramaMe
 * @author: Eric Ramos Pastor
 * @version: 2.0 (14/12/2025)
 * @see <a href="https://aceptaelreto.com/problem/statement.php?id=432">Escapando de las fuerzas imperiales</a>
 */
public class SolutionAceptaReto
{
    static Scanner key = new Scanner(System.in);

    /**
     * Método para recorrer la matriz, partiendo de la posición S, hasta encontrar F.
     * @param mapa - matriz de tipo String que contiene el laberinto a recorrer.
     * @param coordenadasActuales - vector de tipo int que contiene las coordenadas de la matriz donde realizar las comprobaciones.
     * @param altura - entero que contiene la altura máxima de la matriz.
     * @param anchura - entero que contiene la anchura máxima de la matriz.
     * @return haySalida - devuelve true si S y F están conectados por puntos y false en caso contrario.
     */
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
                if(mapa[coordenadasActuales[0]][coordenadasActuales[1]+1].contains("F")) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]][coordenadasActuales[1]+1].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[0] = true;
                    }
                }
            }
            if(coordenadasActuales[0]+1 < altura)
            {
                if(mapa[coordenadasActuales[0]+1][coordenadasActuales[1]].contains("F")) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]+1][coordenadasActuales[1]].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[1] = true;
                    }
                }
            }
            if(coordenadasActuales[1]-1 >= 0)
            {
                if(mapa[coordenadasActuales[0]][coordenadasActuales[1]-1].contains("F")) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]][coordenadasActuales[1]-1].contains("."))
                    {
                        cantidadRutas++;
                        derecha_abajo_izquierda_arriba[2] = true;
                    }
                }
            }
            if(coordenadasActuales[0]-1 >= 0)
            {
                if(mapa[coordenadasActuales[0]-1][coordenadasActuales[1]].contains("F")) return true;
                else
                {
                    if(mapa[coordenadasActuales[0]-1][coordenadasActuales[1]].contains("."))
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

    /**
     * Método para rellenar el contenido de la matriz que se ha de recorrer.
     * @param mapa - matriz de Strings vacía que almacenará los datos ofrecidos por el usuario.
     * @param altura - entero que contiene la altura máxima de la matriz.
     * @param anchura - entero que contiene la anchura máxima de la matriz.
     * @param coordenadasS - vector de enteros que registrará las coordenadas de S al encotrarla, sirviendo como punto de partida en el recorrido por el mapa.
     * @return mapa - devuelve la matriz una vez rellenada.
     */
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

    /**
     * Método que se encarga de realizar todas las llamadas a los métodos y a finalizar la ejecución del programa.
     * @return true/false - devolverá true mientras detecte entradas de datos por teclado, buclando de forma infinita el programa. Devolverá false cuando no se introduzcan más datos, finalizando la ejecución.
     */
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