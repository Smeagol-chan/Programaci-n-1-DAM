package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
Es enta práctica hay que validar si una matrices de letras -representando cada una uno de los colores posibles para la Spectrum- si es compatible con la ZX Spectrum.
La matriz ha de tener una altura y anchura mínima y máxima de 8 y 48 respectivamente. Además, los valores han de ser múltiplos de 8.
Las letras deben estar en un rango de A a O, ambos incluidos.
Para validar si la matriz es compatible o no, se ha de comprobar si hay como máximo 2 letras diferentes en grupos de 8x8. En estas agrupaciones puede haber un máximo de 2 letras diferentes.
 */
public class Practica3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int RESOLUCION_MAX = 48, RESULUCION_MIN = 8;  //Rango del tamaño de la matriz
        String fila, pixel1ro, pixel2do;    //fila guarda la fila de la matriz que el usuario haya introducido. pixxel1ro ý pixel2do son para hacer la comprobación dentro de cada cuadro de 8x8
        int alto = 0, ancho = 0, byteColumn = 0, byteRow, column, row;  //alto y ancho de la matriz. Las otras cuatro es para poder validar la matriz. Cuando llegue a la comprobación profundizo en su forma de empleo.
        boolean fallo, segundoDato = false; //Son los mismo booleanos que siempre uso. fallo para controlar el do_while y los while ý segundoDato para poder pedir el ancho y la altura con la misma estructura.

        //Pido el ancho y la altura de la matriz. En cualquier momento en el que el dato no sea correcto se reiniciará el bucle y se volverá a poder el dato.
        System.out.println("\t**** VALIDADOR DE COMPATIBILIDAD ZX SPECTRUM ****\nIntroduce la resolución de tu pantalla (ancho x alto)...");
        do
        {
            fallo = false;
            System.out.print("> "+ (!segundoDato ? "Anchura" : "Altura") +": ");    //Cambia dependiendo de si ya se ha ingreasado una anchura correcta o no
            try
            {
                alto = key.nextInt();   //Se solicita un entero. Si el usuario introduce un carácter, la excepción InputMismatch lo detectará
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se permiten números.\n");   //Si salta un error, se informa de ello y fallo se convierte en true
                fallo = true;
                key.nextLine();
            }
            if(!fallo)  //Si no ha habido un fallo
            {
                if(alto >= RESULUCION_MIN && alto <= RESOLUCION_MAX)    //Compruebo que el número se encuentre entre el rango que se estableció en los final anteriores (8, 48)
                {
                    if(alto%8 == 0) //Solo son válidos los números múltiplos de 8
                    {
                        if(!segundoDato) ancho = alto;  //Si se trata de la primera vez que se pide un número, la condición y el dato se almacena en ancho.
                        segundoDato = !segundoDato; //Invierto el valor de segundoDato. Así controlo si se han introducido los dos números o solo 1
                    }
                    else
                    {
                        System.out.println("ERROR\nLa resolución ha de ser un múltiplo de 8.\n");
                        fallo = true;
                    }
                }
                else
                {
                    System.out.println("ERROR\nEl valor no puede ser inferior a "+ RESULUCION_MIN +" ni superior a "+ RESOLUCION_MAX +".\n");
                    fallo = true;
                }
            }
        }while(fallo || segundoDato);
        String resolucion[][] = new String[alto][ancho];    //Se crea la matriz con el tamaño introcucido por el usuario.
        key.nextLine();

        //Ahora pido que rellene la matriz línea a línea
        System.out.println("Introduce los colores de tu imagen píxel a píxel:");
        for(int i = 0; i < alto; i++)
        {
            System.out.print("> Fila "+ (i+1) +": ");   //He visto que Denis y Kevin podían introducir la matriz entera (las 8 filas de la matriz que pusiste de ejemplo en un solo ctrl+v). Yo no sé cómo se hace.
            fila = key.nextLine();  //Se introduce cada fila de una en una. Lo guardo en un String

            if(fila.length() == ancho)  //Compruebo que la longitud del string. Si es diferente a la anchura introducida, la fila es incorrecta y se vuelve a pedir.
            {
                if(fila.matches("[A-O]+"))   //Compruebo con un .matches si las letras se encuentran entre A y O. El + es porque compruebo más de un carácter a la vez.
                {
                    resolucion[i] = fila.split(""); //Si se cumple el formato, uso .split sobre el string fila y lo guardo en cada fila de la matriz.
                }
                else
                {
                    System.out.println("ERROR\nValor de píxel incorrecto (A-O).\n");
                    i--;    //Para volver a pedir la misma fila, resto 1 a i, así se vuelve a pedir la misma posición.
                }
            }
            else
            {
                System.out.println("ERROR\nSe deben introducir "+ ancho +" píxeles por fila.\n");
                i--;
            }
        }

        //Imprimo la matriz
        System.out.println("\n");
        for(int i = 0; i < alto; i++)
        {
            for(int j = 0; j < ancho; j++)
            {
                System.out.print(resolucion[i][j] +" ");
            }
            System.out.println();
        }

        //Es el momento de comprobar si la matriz es válida.
        //Uso whiles porque tengo principios morales y, como no es seguro que haga la cantiddad de vueltas máximas, prefiero usar whiles.
        while(byteColumn < alto/8 && !fallo)    //byteColumn y byteRow controla el movimiento entre bloques de 8x8.
        {
            byteRow = 0;
            while(byteRow < ancho/8 && !fallo)
            {
                pixel1ro = resolucion[8*byteColumn][8*byteRow]; //La primera letra de cada bloque la almaceno en esta variable.
                pixel2do = "z"; //El auxiliar que almacenará la segunda letra encontrada la inicializo con un valor que es imposible que la matriz contenga. Con la primera letra diferente, pixel2do tomará su valor.
                column = (8*byteColumn);
                while(column < (8*byteColumn)+8 && !fallo)  //Se desplaza posición a posición dentro de los bloques de 8x8
                {
                    row = (8*byteRow);  //Con esta fórmula puedo cambiar la posición inicial dependiendo del bloque 8x8 que se esté analizando.
                    while(row < ((8*byteRow)+8)-1 && !fallo)
                    {
                        if(!resolucion[column][row].contains(resolucion[column][row+1]))    //Esta primera coprobación es innecesaria, pero la he dejado estar. Si la letra en la posición que se está mirando es direcente a la de su derecha...
                        {
                            if(!resolucion[column][row+1].contains(pixel1ro))   //... y tampoco coincide con la primera letra única guardada...
                            {
                                if(pixel2do.contains("z"))  //... se mira si el segundo auxiliar no ha sido utilizada todavía.
                                {
                                    pixel2do = resolucion[column][row+1];   //Si es == "z", significa que no almacena una segunda letra. Por lo que le doy el valor de la letra de la derecha.
                                }
                                else    //Si pixel2do ya tiene valor...
                                {
                                    if(!resolucion[column][row+1].contains(pixel2do)) fallo = true; //... compruebo si es el mismo a la letra de la derecha. Si es diferente, fallo = true y sale de todos los whiles.
                                }
                            }
                        }
                        row++;
                    }
                    column++;
                }
                byteRow++;
            }
            byteColumn++;
        }

        if(!fallo)  //Si no ha habido fallo...
        {
            System.out.println("\nEs compatible con un ZX Spectrum.");  //... la matriz es compatible, si no...
        }
        else
        {
            System.out.println("\nNo es compatible con un ZX Spectrum.");   //... la matriz no es compatible.
        }
    }
}