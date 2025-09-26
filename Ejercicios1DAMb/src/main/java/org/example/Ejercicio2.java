package org.example;

import java.util.Scanner;
//Reescribe el programa anterior para darle al empleado 1.5 veces la tarifa horaria para todas las horas trabajadas que excedan de 40
public class Ejercicio2
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        final double EXTRA = 1.5, LIMITE = 40;
        double horas, haux = 0, tarifa, taux = 0, salario;

        System.out.print("Introduzca el número de horas: ");
        horas = key.nextFloat();
        System.out.print("Introduzca la tarifa por horas: ");
        tarifa = key.nextFloat();

        if(horas > LIMITE)
        {
            haux = horas - LIMITE;
            taux = tarifa * EXTRA;
            taux *= haux;
        }

        salario = horas * tarifa;
        salario += taux;
        System.out.println("Salario: "+ salario +"€");
    }
}
