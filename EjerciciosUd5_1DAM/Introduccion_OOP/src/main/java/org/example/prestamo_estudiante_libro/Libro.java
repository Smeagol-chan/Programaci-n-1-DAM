package org.example.prestamo_estudiante_libro;

public class Libro
{
    private static final boolean DEF_DISPONIBLE = true;
    private static final String DEF_ID = "LIB";
    private static final int DIGITOS_ID = 3;
    private static int cantidadLibrosTotales = 0;
    private static int cantidadLibrosDisponibles = 0;

    private String titulo;
    private String autor;
    private String id;
    private boolean disponible;
    private Editorial editorial;

    public Libro(String titulo, String autor, Editorial editorial)
    {
        if(limiteSuperado())
        {
            this.titulo = titulo;
            this.autor = autor;
            setId();
            this.editorial = editorial;
            disponible = DEF_DISPONIBLE;
            cantidadLibrosDisponibles++;
        }
        else System.out.println("ERROR\nLímite de libros alcanzado.");
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getId() {
        return id;
    }

    private void setId() {
        id = generarId();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    protected void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public static int getCantidadLibrosTotales()
    {
        return cantidadLibrosTotales;
    }

    public static int getCantidadLibrosDisponibles()
    {
        return cantidadLibrosDisponibles;
    }

    private static boolean limiteSuperado()
    {
        return String.valueOf(cantidadLibrosTotales+1).length() > DIGITOS_ID;
    }

    private static String generarId()
    {
        String id = String.valueOf(++cantidadLibrosTotales);
        while(id.length() < DIGITOS_ID) id = "0" + id;
        return DEF_ID + id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", id='" + id + '\'' +
                ", disponible=" + disponible +
                ", editorial=" + editorial +
                '}';
    }
}