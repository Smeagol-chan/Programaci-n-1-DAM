package org.example.ejercicios_lambdas;

public class Ejercicios
{
    public static void ejercicio1()
    {
        Ejecutor lambda = (n) -> n > 10;
        System.out.println(lambda.ejecutar(15));
        System.out.println(lambda.ejecutar(5));
    }

    public static void ejercicio2()
    {
        VerificadorVoto lambda = (nombre, edad) ->{
            System.out.print("Probando "+ nombre +" con "+ edad +" años...");
            return edad > 18;
        };

        System.out.println(lambda.puedeVotar("María", 14));
        System.out.println(lambda.puedeVotar("Lucía", 21));
    }

    static void main()
    {
        ejercicio1();
        System.out.println();
        ejercicio2();
        System.out.println();
    }
}