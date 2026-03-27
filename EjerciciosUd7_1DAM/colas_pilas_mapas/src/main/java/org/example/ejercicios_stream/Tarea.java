package org.example.ejercicios_stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tarea
{
    static void main()
    {
        final List<String> nombres = Arrays.asList("Ana", "Luís", "Pedro");

        //a)
        nombres.stream()
                .filter(nombre -> nombre.length() > 4)
                //.forEach(nombre -> System.out.println(nombre));
                .forEach(System.out::println);

        //b)
        List<String> nombresMinuscula = nombres.stream().map(String::toLowerCase)
                //.toList()
                .collect(Collectors.toList());
        System.out.println(nombresMinuscula);

        //c)
        long cantidad = nombres.stream().filter(nombre -> nombre.startsWith("A")).count();
        System.out.println("Nombres que empiezan con 'A': "+ cantidad);
    }
}
