package org.example;

import java.util.Scanner;
//Escribe un programa para pedirle al usuario el número de horas y la tarifa por hora para calcular el salario bruto
public class Ejercicio1
{
    static void main()
    {
        Scanner key = new Scanner(System.in);
        float horas, tarifa;

        System.out.print("Introduzca el número de horas: ");
        horas = key.nextFloat();
        System.out.print("Introduzca la tarifa por horas: ");
        tarifa = key.nextFloat();

        System.out.println("Salario: "+ (horas * tarifa) +"€");
    }
}
