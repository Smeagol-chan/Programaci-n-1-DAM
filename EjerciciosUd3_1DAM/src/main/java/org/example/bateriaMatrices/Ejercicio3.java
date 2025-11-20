package org.example.bateriaMatrices;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        int numEstudiantes, numAsignaturas, suma;

        System.out.println("¿Cuántos estudiantes tienes?");
        numEstudiantes = key.nextInt();
        System.out.println("¿Cuántas asignaturas tienes?");
        numAsignaturas = key.nextInt();

        String tabla[][] = new String[numEstudiantes+1][numAsignaturas+1];
        tabla[0][0] = "Estudiantes";
        key.nextLine();

        for(int i = 1; i <= numEstudiantes; i++)
        {
            System.out.println("Nombre del estudiante "+ i);
            tabla[i][0] = key.nextLine();
        }
        for(int i = 1; i <= numAsignaturas; i++)
        {
            System.out.println("Nombre de la asignatura "+ i);
            tabla[0][i] = key.nextLine();
        }
        for(int i = 1; i <= numEstudiantes; i++)
        {
            System.out.println("Notas de "+ tabla[i][0]);
            for(int j = 1; j <= numAsignaturas; j++)
            {
                System.out.print(tabla[0][j] +": ");
                tabla[i][j] = key.nextLine();
            }
        }
        System.out.println();
        for(String fila[] : tabla) System.out.println(Arrays.toString(fila));

        System.out.println("\n");
        for(int i = 1; i <= numEstudiantes; i++)
        {
            suma = 0;
            for (int j = 1; j <= numAsignaturas; j++) suma += Integer.parseInt(tabla[i][j]);
            System.out.println("Nota media del alumno "+ tabla[i][0] +": "+ suma);
        }

        System.out.println();
        for(int j = 1; j < numAsignaturas; j++)
        {
            suma = 0;
            for(int i = 1; i < numEstudiantes; i++) suma += Integer.parseInt(tabla[i][j]);
            System.out.println("Nota media en la asignatura "+ tabla[0][j] +": "+ suma);
        }
    }
}
