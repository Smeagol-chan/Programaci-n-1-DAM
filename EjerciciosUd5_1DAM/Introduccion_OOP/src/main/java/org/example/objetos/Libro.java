package org.example.objetos;
import org.example.FuncionesComunes;

public class Libro
{
    private String titulo;
    private String autor;
    private String id;
    private boolean disponible;

    private static int catidadLibros = 0;
    private static int librosDisponibles = 0;

    private static final int MAXIMO_LIBROS = 999;
    private static final boolean DEF_DISPONIBLES = true;

    public Libro(String titulo, String autor)
    {
        if(hayEspacio())
        {
            catidadLibros++;
            librosDisponibles++;
            this.titulo = titulo;
            this.autor = autor;
            id = calcularId();
            disponible = DEF_DISPONIBLES;
        }
        else
        {
            System.out.println("Límite de libros alcanzado.");
        }
    }

    private String calcularId()
    {
        String id = "LIB";
        int cifras = FuncionesComunes.digitos(catidadLibros);
        int cifrasMaximas = FuncionesComunes.digitos(MAXIMO_LIBROS);
        for (int i = 0; i < cifrasMaximas - cifras; i++) id += "0";

        return id + catidadLibros;
    }

    private static boolean hayEspacio()
    {
        return catidadLibros < MAXIMO_LIBROS;
    }

    public void datosLibro()
    {
        System.out.println("Título: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("ID: "+ id);
        System.out.println("Disponibilidad: "+ disponible);
    }

    public static void datosBiblioteca()
    {
        System.out.println("Cantidad de libros registrados: "+ catidadLibros);
        System.out.println("Cantidad de libros disponibles: "+ librosDisponibles);
    }
}
