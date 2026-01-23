package org.example.biblioteca;

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
    private Estudiante estudiantePrestado;
    private Editorial editorial;

    public Libro(String titulo, String autor, Editorial editorial)
    {
        setId();
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        setDisponible(DEF_DISPONIBLE);
        estudiantePrestado = new Estudiante();
    }

    public Libro()
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

    public void prestar(Estudiante estudiante)
    {
        if(disponible && estudiante.getLibro() == null)
        {
            System.out.println("El libro ha sido prestado con éxito.");
            setDisponible(false);
            cantidadLibrosDisponibles--;
            estudiantePrestado = estudiante;
            estudiantePrestado.setLibro(this);
        }
        else if(disponible && estudiante.getLibro() != null)
        {
            System.out.println(estudiante.getNombre() +" ya tiene un libro en posesión. No puede recibir más.");
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
            estudiantePrestado.setLibro(null);
            estudiantePrestado = null;
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
                ", estidiantePrestado=" + estudiantePrestado + '\'' +
                ", editorial=" + editorial + '\'' +
                '}';
    }
}
