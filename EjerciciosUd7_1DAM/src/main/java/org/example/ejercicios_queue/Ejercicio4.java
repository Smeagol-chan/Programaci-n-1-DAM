package org.example.ejercicios_queue;
import org.example.FuncionesComunes;
import java.util.LinkedList;

public class Ejercicio4
{
    static void mostrarMenuPrincipal()
    {
        System.out.println("\n--- LISTA DE LA COMPRA ---");
        System.out.println("1. Añadir producto al final");
        System.out.println("2. Eliminar primer producto");
        System.out.println("3. Eliminar producto por nombre");
        System.out.println("4. Ver primer producto");
        System.out.println("5. Buscar producto");
        System.out.println("6. Mostrar lista actual");
        System.out.println("X. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    static void main()
    {
        final String[] PRODUCTOS = {"Plátanos", "Leche", "Aguacates", "Garbanzos", "Avena", "Cacao", "Miel", "Huevos"};
        LinkedList<String> listaCompra = new LinkedList<>();

        for (int i = 0; i < PRODUCTOS.length; i++) listaCompra.offer(PRODUCTOS[i]);

        char opcion;
        boolean running = true;
        while(running)
        {
            mostrarMenuPrincipal();
            opcion = FuncionesComunes.solicitudChar();
            System.out.println("\n--------------------------\n");
            switch(opcion)
            {
                case '1':
                    System.out.print("Producto a añadir: ");
                    listaCompra.offerLast(FuncionesComunes.solicitarString());
                    break;

                case '2':
                    if(listaCompra.isEmpty()) System.out.println("La lista está vacía.");
                    else
                    {
                        System.out.println("Eliminando: "+ listaCompra.pollFirst());
                    }
                    break;

                case '3':
                    if(listaCompra.isEmpty()) System.out.println("La lista está vacía.");
                    else
                    {
                        System.out.print("Producto a eliminar: ");
                        if(listaCompra.remove(FuncionesComunes.solicitarString())) System.out.println("El producto ha sido eliminado.");
                        else System.out.println("El producto no está en la lista.");
                    }
                    break;

                case '4':
                    if(listaCompra.isEmpty()) System.out.println("La lista está vacía.");
                    else
                    {
                        System.out.println("Primer producto de la lista: "+ listaCompra.peekFirst());
                    }
                    break;

                case '5':
                    if(listaCompra.isEmpty()) System.out.println("La lista está vacía.");
                    else
                    {
                        System.out.print("Producto a buscar: ");
                        if(listaCompra.contains(FuncionesComunes.solicitarString())) System.out.println("El producto está en la lista.");
                        else System.out.println("El producto no está en la lista");
                    }
                    break;

                case '6':
                    if(listaCompra.isEmpty()) System.out.println("La lista está vacía.");
                    else
                    {
                        System.out.println("--- Productos de la lista ---");
                        for(String producto : listaCompra)
                            System.out.println((listaCompra.indexOf(producto)+1) +") "+ producto);
                    }
                    break;

                case 'X':
                case 'x':
                    System.out.println("--- FIN DEL PROGRAMA ---");
                    running = false;
                    break;
            }
        }
    }
}
