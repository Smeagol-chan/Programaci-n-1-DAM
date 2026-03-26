package org.example.ejercicios_lambdas;

public class IntroLambda
{
    static void main()
    {
        //Clase anónima SIN lambda
        Prueba anonima = new Prueba() {
            @Override
            public String aprobar(int nota) {
                System.out.println("Corrigiendo a anónimo...");
                return nota < 5 ? "AL MIÉRCOLES" : "APROBADO";
            }
        };

        Prueba lambda = (nota) -> {
            System.out.println("Corrigiendo a lambda...");
            return nota < 5 ? "AL MIÉRCOLES" : "APROBADO";
        };

        System.out.println(anonima.aprobar(4));
        System.out.println(lambda.aprobar(8));
    }
}
