package org.example.biblioteca_malo;

public class Libro_v1
{
    private static final boolean DEF_DISPONIBLE = true;
    private static final String DEF_ID = "LIB";
    private static int cantidadLibrosTotales = 0;
    private static int cantidadLibrosDisponibles = 0;

    private String titulo;
    private String autor;
    private String id;
    private boolean disponible;
    private Estudiante_v1 estudianteV1Prestado;
    private Editorial_v1 editorial;

    public Libro_v1(String titulo, String autor, Editorial_v1 editorial)
    {
        setId();
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        setDisponible(DEF_DISPONIBLE);
        estudianteV1Prestado = new Estudiante_v1();
    }

    public Libro_v1()
    {
        this(null, null, null);
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

    private void setId()
    {
        calcularId();
        cantidadLibrosDisponibles++;
    }

    public boolean getDisponible() {
        return disponible;
    }

    private void setDisponible(boolean disponible)
    {
        this.disponible = disponible;
    }

    private void calcularId()
    {
        id = DEF_ID + (++cantidadLibrosTotales);
    }

    public void prestar(Estudiante_v1 estudianteV1)
    {
        if(disponible && estudianteV1.getLibro() == null)
        {
            System.out.println("El libro ha sido prestado con éxito.");
            setDisponible(false);
            cantidadLibrosDisponibles--;
            estudianteV1Prestado = estudianteV1;
            estudianteV1Prestado.setLibro(this);
        }
        else if(disponible && estudianteV1.getLibro() != null)
        {
            System.out.println(estudianteV1.getNombre() +" ya tiene un libro en posesión. No puede recibir más.");
        }
        else
        {
            System.out.println("El libro ya ha sido prestado con anterioridad.");
        }
    }

    public void devolver()
    {
        if(!disponible)
        {
            System.out.println("El libro ha sido devuelto con éxito.");
            setDisponible(true);
            cantidadLibrosDisponibles++;
            estudianteV1Prestado.setLibro(null);
            estudianteV1Prestado = null;
        }
        else System.out.println("El libro ya ha sido devuelto con anterioridad.");
    }

    public void estaDisponible()
    {
        System.out.println(disponible ? "Está disponible." : "No está disponible.");
    }

    public static int getCantidadLibrosTotales()
    {
        return cantidadLibrosTotales;
    }

    public static int getCantidadLibrosDisponibles()
    {
        return cantidadLibrosDisponibles;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", id='" + id + '\'' +
                ", disponible=" + disponible + '\'' +
                ", estidiantePrestado=" + estudianteV1Prestado + '\'' +
                ", editorial=" + editorial + '\'' +
                '}';
    }
}
