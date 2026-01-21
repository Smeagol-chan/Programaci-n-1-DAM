package org.example.objetos;

public class Libro
{
    private static final boolean DEF_DISPONIBLE = true;
    private static final String DEF_ID = "LIB";
    private static int cantidadLibrosTotales = 0;
    private static int cantidadLibrosDisponibles = 0;

    private String titulo;
    private String autor;
    private String id;
    private boolean disponible;

    public Libro()
    {
        setDisponible(DEF_DISPONIBLE);
        setId();
    }

    public Libro(String titulo, String autor)
    {
        this.titulo = titulo;
        this.autor = autor;
        this();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    private void setId() {
        calcularId();
    }

    public boolean getDisponible() {
        return disponible;
    }

    private void setDisponible(boolean disponible)
    {
        cantidadLibrosDisponibles++;
        this.disponible = disponible;
    }

    private void calcularId()
    {
        id = DEF_ID + (++cantidadLibrosTotales);
    }

    //UML   ->  no recibe parámetros
    public void prestar()
    {
        if(disponible)
        {
            System.out.println("El libro ha sido prestado con éxito.");
            setDisponible(false);
            cantidadLibrosDisponibles--;
        }
        else System.out.println("El libro ya ha sido prestado con anterioridad.");
    }

    //UML   ->  no recibe parámetros
    public void devolver()
    {
        if(!disponible)
        {
            System.out.println("El libro ha sido devuelto con éxito.");
            setDisponible(true);
            cantidadLibrosDisponibles++;
        }
        else System.out.println("El libro ya ha sido devuelto con anterioridad.");
    }

    //UML   ->  no recibe parámetros
    public void estaDisponible()
    {
        System.out.println(disponible ? "Está disponible." : "No está disponible.");
    }
}
