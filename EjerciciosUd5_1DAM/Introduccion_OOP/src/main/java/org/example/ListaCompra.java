package org.example;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Ejercicio 1 ArrayList
 */
public class ListaCompra
{
    static boolean hayCoincidencias(ArrayList<String> lista, String producto)
    {
        return lista.contains(producto);
    }

    static ArrayList<String> anyadir(ArrayList<String> lista, String producto)
    {
        if(hayCoincidencias(lista, producto)) System.out.println("Ya está en la lista.");
        else lista.add(producto);

        return lista;
    }

    static ArrayList<String> alterar(ArrayList<String> lista, String productoNuevo, String productoViejo)
    {
        if(hayCoincidencias(lista, productoNuevo)) System.out.println("Ya está en la lista.");
        else lista.set(lista.indexOf(productoViejo), productoNuevo);

        return lista;
    }

    static void main()
    {
        //a)
        System.out.println("\na)");
        ArrayList<String> listaCompra = new ArrayList<>();
        System.out.println(listaCompra.isEmpty());
        listaCompra.add("Puerro");
        System.out.println(listaCompra.isEmpty());

        //b)
        System.out.println("\nb)");
        listaCompra.addAll(Arrays.asList("Tomates", "Huevos", "Leche", "Pollo entero", "Almendras"));
        System.out.println(listaCompra);

        //c)
        System.out.println("\nc)");
        System.out.println(listaCompra.get(2));

        //d)
        System.out.println("\nd)");
        listaCompra.set(1, "Queso");
        System.out.println(listaCompra);

        //e)
        System.out.println("\ne)");
        System.out.println(listaCompra.indexOf("Leche"));

        //f)
        System.out.println("\nf)");
        listaCompra = anyadir(listaCompra, "Pizza");
        System.out.println(listaCompra);
        listaCompra = alterar(listaCompra, "Pan", "Pizza");
        System.out.println(listaCompra);

        //g)
        System.out.println("\ng)");
        System.out.println(listaCompra.size());

        //h)
        System.out.println("\nh)");
        ArrayList<String> copiaListaCompra = new ArrayList<>(listaCompra);
        System.out.println(copiaListaCompra);

        //i)
        System.out.println("\ni)");
        copiaListaCompra.clear();
        System.out.println(copiaListaCompra.isEmpty());

        //j)
        System.out.println("\nj)");
        boolean sonIguales = listaCompra.equals(copiaListaCompra);
        System.out.println(sonIguales);

        //k)
        System.out.println("\nk)");
        copiaListaCompra.addAll(Arrays.asList("Tomates", "Almendras"));
        System.out.println(copiaListaCompra);

        //l)
        System.out.println("\nl)");
        ArrayList<String> faltantes = new ArrayList<>(listaCompra);
        faltantes.removeAll(copiaListaCompra);
        System.out.println(faltantes);

        //m)
        System.out.println("\nm)");
        ArrayList<Integer> precios = new ArrayList<>();
        for (int i = 0; i < listaCompra.size(); i++) precios.add(FuncionesComunes.random.nextInt(11));
        for (int i = 0; i < listaCompra.size(); i++) System.out.println(listaCompra.get(i) +" = "+ precios.get(i) +" €");
    }
}
