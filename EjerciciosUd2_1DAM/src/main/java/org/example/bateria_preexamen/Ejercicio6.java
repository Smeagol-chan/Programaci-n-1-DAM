package org.example.bateria_preexamen;

import java.util.Scanner;

public class Ejercicio6
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final int MAYORIA_EDAD = 18, ALTURA_MAYOR_DE = 175;
        int alumnos, altura, edad, contadorEdad = 0, contadorAltura = 0, edadMedia = 0, alturaMedia = 0;

        System.out.print("Inserte cantidad de alumnos: ");
        alumnos = key.nextInt();

        for(int i = 1; i <= alumnos; i++)
        {
            System.out.print("Edad alumno "+ i +"º: ");
            edad = key.nextInt();
            System.out.print("Altura alumno "+ i +"º: ");
            altura = key.nextInt();

            if(edad > MAYORIA_EDAD) contadorEdad++;
            if(altura > ALTURA_MAYOR_DE) contadorAltura++;
            edadMedia += edad;
            alturaMedia += altura;
        }
        System.out.println("\nDe los "+ alumnos +", "+ contadorEdad +" tienen más de "+ MAYORIA_EDAD +" años y "+ contadorAltura +" miden más de "+ ALTURA_MAYOR_DE +"cm.");
        System.out.println("La edad media es: "+ (edadMedia/2) +"\nLa altura media es: "+ (alturaMedia/2));
    }
}
