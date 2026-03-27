package org.example.ejercicios_lambdas;

import org.example.FuncionesComunes;

import java.util.ArrayList;

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

    public static void ejercicio3()
    {
        final String[] categorias = {"Electrónica", "Interiorismo", "Oficina"};
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        FriltroProducto lambda = (producto) -> producto.getCategoria().equals("Electrónica") && producto.getPrecio() > 100;

        for(int i = 1; i <= 10; i++)
            productos.add(new Producto("producto "+ i
                    , FuncionesComunes.random.nextFloat(500)
                    , categorias[FuncionesComunes.random.nextInt(categorias.length)]));

        for(Producto producto : productos)
            if(lambda.filtrar(producto)) productosFiltrados.add(producto);

        System.out.println("Productos filtrados (Electrónica y precio > 100):");
        for(Producto producto : productosFiltrados)
            System.out.println("Nombre: "+ producto.getNombre() +", Precio: "+ producto.getPrecio());
    }

    static void main()
    {
        ejercicio1();
        System.out.println();
        ejercicio2();
        System.out.println();
        ejercicio3();
    }
}