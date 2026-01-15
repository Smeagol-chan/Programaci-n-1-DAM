package org.example.objetos;

/**
 * Primer objeto creado en el curso.
 */
public class Bocadillo
{
    private String nombre;
    private String pan;
    private String ingredientes;
    private String salsa;
    private double precio;

    /**
     * Constructor parametizado, puesto que cuenta con todos los parámetros (la carencia de alguno no implica la pérdida del adjetivo).
     * @param nombre Nombre del bocadillo.
     * @param pan Tipo del pan.
     * @param ingredientes Nombre de los ingredientes.
     * @param salsa Nombre de la salsa.
     * @param precio Precio asignado.
     */
    public Bocadillo (String nombre, String pan, String ingredientes, String salsa, double precio)
    {
        this.nombre = nombre;
        this.pan = pan;
        this.ingredientes = ingredientes;
        this.salsa = salsa;
        this.precio = precio;
    }

    /**
     * Constructor por defecto.
     */
    public Bocadillo(){}

    //Getters
    public String getNombre()
    {
        return nombre;
    }
    public String getPan()
    {
        return pan;
    }
    public String getIngredientes()
    {
        return ingredientes;
    }
    public String getSalsa()
    {
        return salsa;
    }
    public double getPrecio()
    {
        return precio;
    }

    //Setters
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setPan(String pan)
    {
        this.pan = pan;
    }
    public void setIngredientes(String ingredientes)
    {
        this.ingredientes = ingredientes;
    }
    public void setSalsa(String salsa)
    {
        this.salsa = salsa;
    }
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    /**
     * Procedimiento para imprimir todos los datos del bocadillo.
     */
    public void imprimirBocadillo()
    {
        System.out.println("Nombre: "+ nombre);
        System.out.println("Pan: "+ pan);
        System.out.println("Ingredientes: "+ ingredientes);
        System.out.println("Salsa: "+ salsa);
        System.out.println("Precio: "+ precio +" €");
    }
}
