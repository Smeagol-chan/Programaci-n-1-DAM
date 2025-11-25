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
        final int RESOLUCION_MAX = 48, RESULUCION_MIN = 8;  //Rango de la resolución
        String fila, pixel1ro, pixel2do;    //fila
        int alto = 0, ancho = 0, byteColumn = 0, byteRow, column, row;
        boolean fallo, segundoDato = false;

        System.out.println("\t**** VALIDADOR DE COMPATIBILIDAD ZX SPECTRUM ****\nIntroduce la resolución de tu pantalla (ancho x alto)...");
        do
        {
            fallo = false;
            System.out.print("> "+ (!segundoDato ? "Anchura" : "Altura") +": ");
            try
            {
                alto = key.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR\nSolo se permiten números.\n");
                fallo = true;
                key.nextLine();
            }
            if(!fallo)
            {
                if(alto >= RESULUCION_MIN && alto <= RESOLUCION_MAX)
                {
                    if(alto%8 == 0)
                    {
                        if(!segundoDato) ancho = alto;
                        segundoDato = !segundoDato;
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
        String resolucion[][] = new String[alto][ancho];
        key.nextLine();

        System.out.println("Introduce los colores de tu imagen píxel a píxel:");
        for(int i = 0; i < alto; i++)
        {
            System.out.print("> Fila "+ (i+1) +": ");
            fila = key.nextLine();

            if(fila.length() == ancho)
            {
                if(fila.matches("[A-O]+"))
                {
                    resolucion[i] = fila.split("");
                }
                else
                {
                    System.out.println("ERROR\nValor de píxel incorrecto (A-O).\n");
                    i--;
                }
            }
            else
            {
                System.out.println("ERROR\nSe deben introducir "+ ancho +" píxeles por fila.\n");
                i--;
            }
        }

        System.out.println("\n");
        for(int i = 0; i < alto; i++)
        {
            for(int j = 0; j < ancho; j++)
            {
                System.out.print(resolucion[i][j] +" ");
            }
            System.out.println();
        }

        while(byteColumn < alto/8 && !fallo)
        {
            byteRow = 0;
            while(byteRow < ancho/8 && !fallo)
            {
                pixel1ro = resolucion[8*byteColumn][8*byteRow];
                pixel2do = "z";
                column = (8*byteColumn);
                while(column < (8*byteColumn)+8 && !fallo)
                {
                    row = (8*byteRow);
                    while(row < ((8*byteRow)+8)-1 && !fallo)
                    {
                        if(!resolucion[column][row].contains(resolucion[column][row+1]))
                        {
                            if(!resolucion[column][row+1].contains(pixel1ro))
                            {
                                if(pixel2do.contains("z"))
                                {
                                    pixel2do = resolucion[column][row+1];
                                }
                                else
                                {
                                    if(!resolucion[column][row+1].contains(pixel2do)) fallo = true;
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

        if(!fallo)
        {
            System.out.println("\nEs compatible con un ZX Spectrum.");
        }
        else
        {
            System.out.println("\nNo es compatible con un ZX Spectrum.");
        }
    }
}