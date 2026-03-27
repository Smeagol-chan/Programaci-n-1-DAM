package org.example.ejercicios_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntroStreams
{
    static void main()
    {
        //Hasta que no se realiza ninguna acción con alumnos, esta línea nunca se va a ejecutar.
        Stream<String> alumnos = Stream.of("Carlos", "Pedro", "Jesús", "Jose", "Luís");
        //Se ejecuta la línea 11.
        List<String> listaAlumnos = alumnos.toList();
        System.out.println(listaAlumnos);


        System.out.println();
        //Los métodos como este que no tienen forma de ejecutarse se denominan 'lazy'.
        Stream<String> alumnos2 = Stream.of("Carlos", "Pedro", "Jesús", "Jose", "Luís")
                .filter(alumno -> alumno.startsWith("J"))
                .filter(alumno -> alumno.contains("ú"));

        List<String> listaAlumnos2 = alumnos2.toList();
        System.out.println(listaAlumnos2);


        System.out.println();
        //Los streams necesitan un método que ejecute para que se cree.
        boolean alumnos3 = Stream.of("Carlos", "Pedro", "Jesús", "Jose", "Luís")
                //Métodos intermedios. Puede haber cualquier cantidad.
                .filter(alumno -> alumno.startsWith("J"))
                .filter(alumno -> alumno.contains("ú"))
                //Método de ejecución. Solo puede haber uno.
                .anyMatch(alumno -> alumno.equals("Jose"));

        System.out.println(alumnos3);


        System.out.println();
        //Los métodos como este que no tienen forma de ejecutarse se denominan 'lazy'.
        Stream<String> alumnos4 = Stream.of("Carlos", "Pedro", "Jesús", "Jose", "Luís")
                .map(alumno -> alumno.toUpperCase());

        System.out.println(alumnos4.toList());


        System.out.println();
        //Lo mismo que en el bloque anterior.
        Stream<String> alumnos5 = Stream.of("Carlos", "Pedro", "Jesús", "Jose", "Luís")
                .map(String::toUpperCase);

        System.out.println(alumnos5.toList());


        System.out.println();
        List<String> turrones = Arrays.asList("Jijona", "Yema", "Piedra", "Duro");
        turrones = turrones.stream().filter(turron -> turron.contains("o")).toList();

        System.out.println(turrones);
    }
}
