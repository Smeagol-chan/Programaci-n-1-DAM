package org.example.resoluciones;
import org.example.FuncionesComunes;

/**
 * Contiene mi resolución 'bonita' del problema 432 de ProgramaMe
 * @author Eric Ramos Pastor
 * @version 1.0 (13/12/2025)
 * @see <a href="https://aceptaelreto.com/problem/statement.php?id=432">Escapando de las fuerzas imperiales</a>
 */
public class EscapandoFuerzasImperiales
{
    private static final String ENTRADA = "S", SALIDA = "F", ASTEROIDE = "*", CAMINO = ".";

    /**
     * Método para comprobar que los carácteres introducidos en la matriz son válidos y que no hay más de una S y una F.
     * @param f - String que almacena el carácter a comprobar.
     * @param haySF - vector de booleanos que determina si ya se han encontrado S o F con anterioridad y si han sido encontrados en esta misma comprobación.
     * @param coorS - vector de enteros que almacenará las coordenadas de S una vez se encuentre.
     * @param y - entero con el valor de la coordenada y (altura)
     * @param x - entero con el valor de la coordenada x (anchura)
     * @return true/false - devuelve true si he ha encontrado un carácter unválido o más de una S o F. Devuelve true si todos los carácteres son válidos.
     */
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

    /**
     * Método encargado de solicitar los datos que contrendrá el mapa al usuario.
     * @param mapa - matriz de Strings vacía a la que hay que relenar.
     * @param altura - entero que almacena la altura máxima del mapa.
     * @param anchura - entero que almacena la anchura máxima del mapa.
     * @param coordenadasS - vector de enteros vacía que contendrá las coordenadas de S una vez hallada.
     * @return mapa - devuelve el contenido de la matriz rellenado por el usuario y validado.
     */
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

    /**
     * Método recursivo encargado de hallar un camino que conecte S con F dentro del mapa.
     * @param mapa - matriz de Strings que contiene el laberinto a recorrer.
     * @param coordenadasActuales - vector de tipo int que contiene las coordenadas de la matriz donde realizar las comprobaciones.
     * @param altura - entero que almacena la altura máxima del mapa.
     * @param anchura - entero que almacena la anchura máxima del mapa.
     * @return haySalida - devuelve true si se ah encontrado F y false si no.
     */
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

    /**
     * Método para finalizar la ejecución si el usuario no introduce datos por el teclado.
     * @param coorS - vector de enteros parado por referencia al que se le inicializa la posición 0 para saber más adelante si el usuario ha introducid S en algún momento.
     * @return true/false - devuelve false o true dependiendo de si hay respuesta del teclado o no.
     */
    public static boolean finalizarPrograma(int[] coorS)
    {
        coorS[0] = -1;
        return FuncionesComunes.key.hasNext();
    }

    /**
     * Método main. Encargado de realizar todas las llamadas a otras funciones y almacenar los datos relevantes.
     */
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