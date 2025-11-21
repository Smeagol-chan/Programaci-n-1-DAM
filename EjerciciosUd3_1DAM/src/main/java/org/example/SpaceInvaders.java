package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceInvaders
{
    static void main() {
        Scanner key = new Scanner(System.in);
         System.out.print("Introduce cantidad de filas: ");
         int nFilas = key.nextInt();

         key.nextLine();

         String mensaje[][] = new String[nFilas][3];

         for(int i = 0; i < nFilas; i++)
         {
             String fila[] = key.next().split("");

             if(fila.length == mensaje[i].length)
             {
                 for(int j = 0; j < mensaje[i].length; j++)
                 {
                     mensaje[i][j] = fila[j];
                 }
             }
             else
             {
                 System.out.println("Tamaño incorrecto.");
                 i--;
             }

         }

         for(String fila[] : mensaje)
         {
             System.out.println(Arrays.toString(fila));
         }

         for(int j = 0; j < mensaje[0].length; j++)
         {
             for(int i = 0; i < mensaje.length; i++)
             {
                 System.out.print(mensaje[i][j]);
             }
         }
    }
}
